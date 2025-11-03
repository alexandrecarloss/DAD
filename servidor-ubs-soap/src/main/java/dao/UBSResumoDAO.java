package dao;

import model.UBSLocalizacao;
import model.UBSResumo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UBSResumoDAO {

    public UBSResumo getResumoPorEstadoMunicipio(String uf, String municipio) {
        int totalUBS = 0;
        int totalMedicos = 0;
        int totalEnfermeiros = 0;
        List<UBSLocalizacao> localizacoes = new ArrayList<>();

        boolean temMunicipio = (municipio != null && !municipio.isEmpty());
        String filtroMunicipio = temMunicipio ? " AND u.IBGE = ?" : "";

        // 1️⃣ Consulta de UBS e localização
        String sqlLocalizacao =
                "SELECT u.NOME, u.LOGRADOURO, u.BAIRRO, u.LATITUDE, u.LONGITUDE " +
                        "FROM ubs_localizacao u " +
                        "WHERE u.UF = ?" + filtroMunicipio;

        // 2️⃣ Contagem de UBS
        String sqlTotalUBS =
                "SELECT COUNT(*) AS total " +
                        "FROM ubs_localizacao " +
                        "WHERE UF = ?" + filtroMunicipio;

        // 3️⃣ Médicos e enfermeiros
        String sqlProfissionais =
                "SELECT " +
                        "SUM(CASE WHEN p.CO_CBO LIKE '225%' THEN 1 ELSE 0 END) AS medicos, " +
                        "SUM(CASE WHEN p.CO_CBO LIKE '2235%' THEN 1 ELSE 0 END) AS enfermeiros " +
                        "FROM estabelecimentoprofissionais p " +
                        "JOIN estabelecimentos e ON p.CO_UNIDADE = e.CNES " +
                        "JOIN municipios m ON LEFT(p.CO_MUNICIPIO, 6) = LEFT(m.CD_MUN, 6) " +
                        "WHERE e.UF = ?" + (temMunicipio ? " AND m.NM_MUN = ?" : "");

        try (Connection conn = ConnectionFactory.getConnection()) {

            // 🏥 Total UBS
            try (PreparedStatement stmt = conn.prepareStatement(sqlTotalUBS)) {
                stmt.setString(1, uf);
                if (temMunicipio) stmt.setString(2, municipio);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) totalUBS = rs.getInt("total");
            }

            // 👩‍⚕️ Médicos e 👨‍⚕️ enfermeiros
            try (PreparedStatement stmt = conn.prepareStatement(sqlProfissionais)) {
                stmt.setString(1, uf);
                if (temMunicipio) stmt.setString(2, municipio);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    totalMedicos = rs.getInt("medicos");
                    totalEnfermeiros = rs.getInt("enfermeiros");
                }
            }

            // 📍 Lista de UBS com coordenadas
            try (PreparedStatement stmt = conn.prepareStatement(sqlLocalizacao)) {
                stmt.setString(1, uf);
                if (temMunicipio) stmt.setString(2, municipio);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    localizacoes.add(new UBSLocalizacao(
                            rs.getString("NOME"),
                            rs.getString("LOGRADOURO"),
                            rs.getString("BAIRRO"),
                            rs.getDouble("LATITUDE"),
                            rs.getDouble("LONGITUDE")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar resumo de UBS", e);
        }

        return new UBSResumo(uf, municipio, totalUBS, totalMedicos, totalEnfermeiros, localizacoes);
    }
}
