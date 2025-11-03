package dao;

import model.Estado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {

    public List<Estado> getAllEstados() {
        List<Estado> estados = new ArrayList<>();
        String sql = "SELECT id, codigo_ibge, sigla, nome FROM estados ORDER BY nome"; // Ordena por nome
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setCodigo_ibge(rs.getString("codigo_ibge"));
                estado.setSigla(rs.getString("sigla"));
                estado.setNome(rs.getString("nome"));
                estados.add(estado);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os estados no banco de dados", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return estados;
    }

    public Estado getEstadoByNome(String nomeEstado) {
        Estado estado = null;
        String sql = "SELECT id, codigo_ibge, sigla, nome FROM estados WHERE nome LIKE ?"; // Busca por nome
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nomeEstado + "%");
            rs = stmt.executeQuery();

            if (rs.next()) {
                estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setCodigo_ibge(rs.getString("codigo_ibge"));
                estado.setSigla(rs.getString("sigla"));
                estado.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar estado por nome no banco de dados", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return estado;
    }

}