package dao;

import model.Municipio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MunicipioDAO {

    public Municipio getMunicipioByNomeAndEstado(String nomeMunicipio, String nomeEstado) {
        Municipio municipio = null;

        String sql = "SELECT CD_MUN, ESTADO, NM_MUN, total_moradores, sexo_masculino, sexo_feminino, " +
                "sexo_idade0a9, sexo_idade10a19, sexo_idade20a39, sexo_idade40mais " +
                "FROM municipios WHERE NM_MUN LIKE ? AND ESTADO LIKE ?"; // Usamos LIKE para maior flexibilidade

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nomeMunicipio + "%");
            stmt.setString(2, "%" + nomeEstado + "%");
            rs = stmt.executeQuery();

            if (rs.next()) { // Se encontrar um resultado
                municipio = new Municipio();
                municipio.setCd_mun(rs.getInt("CD_MUN"));
                municipio.setEstado(rs.getString("ESTADO"));
                municipio.setNm_mun(rs.getString("NM_MUN"));
                municipio.setTotal_moradores(rs.getInt("total_moradores"));
                municipio.setSexo_masculino(rs.getInt("sexo_masculino"));
                municipio.setSexo_feminino(rs.getInt("sexo_feminino"));
                municipio.setSexo_idade0a9(rs.getInt("sexo_idade0a9"));
                municipio.setSexo_idade10a19(rs.getInt("sexo_idade10a19"));
                municipio.setSexo_idade20a39(rs.getInt("sexo_idade20a39"));
                municipio.setSexo_idade40mais(rs.getInt("sexo_idade40mais"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar município por nome e estado no banco de dados", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close(); // Fechar a conexão aqui para garantir
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return municipio;
    }
}