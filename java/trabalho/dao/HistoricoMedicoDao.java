package trabalho.dao;

import trabalho.model.HistoricoMedico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoMedicoDao {
    public Connection connection;

    public HistoricoMedicoDao() throws SQLException {
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

    public void inserirHistorico(HistoricoMedico historicoMedico) throws SQLException {
        String sql = "INSERT INTO historicos_medicos_idosos (id_idoso, alergias, condicoes_preexistentes, observacoes) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, historicoMedico.getId_idoso());
        ps.setString(2, historicoMedico.getAlergias());
        ps.setString(3, historicoMedico.getCondicoes());
        ps.setString(4, historicoMedico.getObservacoes());
        ps.executeUpdate(); // Use executeUpdate() para operações de INSERT, UPDATE, DELETE
    }

    public List<HistoricoMedico> listarHistoricos() throws SQLException {
        List<HistoricoMedico> historicoMedicos = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("SELECT * FROM historicos_medicos_idosos").executeQuery();
        while (rs.next()) {
            historicoMedicos.add(new HistoricoMedico(
                    rs.getInt("id"),
                    rs.getInt("id_idoso"),
                    rs.getString("alergias"),
                    rs.getString("condicoes_preexistentes"),
                    rs.getString("observacoes")
            ));
        }
        rs.close();

        return historicoMedicos;
    }

    public void atualizarHistoricos(HistoricoMedico historicoMedico) throws SQLException {
        String sql = "UPDATE historicos_medicos_idosos SET id_idoso = ?, alergias = ?, condicoes_preexistentes = ?, observacoes = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, historicoMedico.getId_idoso());
        ps.setString(2, historicoMedico.getAlergias());
        ps.setString(3, historicoMedico.getCondicoes());
        ps.setString(4, historicoMedico.getObservacoes());
        ps.setInt(5, historicoMedico.getId());
        ps.executeUpdate(); // Use executeUpdate() para operações de INSERT, UPDATE, DELETE
    }

    public void deletarHistorico(int id) throws SQLException {
        String sql = "DELETE FROM historicos_medicos_idosos WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate(); // Use executeUpdate() para operações de INSERT, UPDATE, DELETE
    }
}
