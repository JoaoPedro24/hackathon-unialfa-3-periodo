package trabalho.dao;

import trabalho.model.Agendamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDao {
    public Connection connection;

    public AgendamentoDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hackathon_3_periodo?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void agendarVisita(Agendamento agendamento) {
        String sql = "INSERT INTO agendamentos (data, id_idoso, id_enfermeiro, id_vacina, observacoes) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(agendamento.getData()));
            stmt.setInt(2, agendamento.getIdIdoso());
            stmt.setInt(3, agendamento.getIdEnfermeiro());
            stmt.setInt(4, agendamento.getIdVacina());
            stmt.setString(5, agendamento.getObservacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getNomes(String tabela) {
        List<String> nomes = new ArrayList<>();
        String sql = "SELECT nome FROM " + tabela;

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nomes;
    }

    public int getId(String tabela, String nome) {
        String sql = "SELECT id FROM " + tabela + " WHERE nome = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }


}
