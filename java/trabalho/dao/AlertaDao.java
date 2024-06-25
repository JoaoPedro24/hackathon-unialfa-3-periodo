package trabalho.dao;

import trabalho.model.Alerta;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlertaDao {

    private static final String URL = "jdbc:mysql://localhost:3306/hackathon_3_periodo";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public List<Alerta> listarTodosAlertas() throws SQLException {
        List<Alerta> alertas = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT idosos.nome as nome_idosos, idosos.cpf, idosos.telefone, agendamentos.data, vacinas.nome as nome_vacinas " +
                             "FROM agendamentos " +
                             "JOIN idosos ON agendamentos.id_idoso = idosos.id " +
                             "JOIN vacinas ON agendamentos.id_vacina = vacinas.id " +
                             "WHERE agendamentos.data >= CURDATE() " +
                             "ORDER BY agendamentos.data")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nomeIdoso = rs.getString("nome_idosos");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                LocalDate data = rs.getObject("data", LocalDate.class);

                String nomeVacina = rs.getString("nome_vacinas");

                Alerta alerta = new Alerta(nomeIdoso, cpf, telefone, data, nomeVacina);
                alertas.add(alerta);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar alertas: " + e.getMessage());
        }

        return alertas;
    }
}
