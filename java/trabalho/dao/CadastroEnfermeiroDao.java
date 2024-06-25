package trabalho.dao;

import trabalho.model.Alerta;
import trabalho.model.CadastroEnfermeiro;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastroEnfermeiroDao {

    private static final String URL = "jdbc:mysql://localhost:3306/hackathon_3_periodo";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    private Connection connection;

    public CadastroEnfermeiroDao() throws SQLException {
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

    //Enfermeiros//
    public void inserir(CadastroEnfermeiro cadastroEnfermeiro) throws SQLException {
        String sql = "insert into enfermeiros(nome, telefone, cpf) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cadastroEnfermeiro.getNome());
        ps.setString(2, cadastroEnfermeiro.getTelefone());
        ps.setString(3, cadastroEnfermeiro.getCpf());
        ps.execute();
    }

    public List<CadastroEnfermeiro> listarTodos() throws SQLException {
        List<CadastroEnfermeiro> cadastroEnfermeiros = new ArrayList<>();
        ResultSet rs = connection.prepareStatement("select * from enfermeiros").executeQuery();
        while (rs.next()) {
            cadastroEnfermeiros.add(new CadastroEnfermeiro(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("cpf")

            ));
        }
        rs.close();

        return cadastroEnfermeiros;
    }

    public void atualizar(CadastroEnfermeiro cadastroEnfermeiro) throws SQLException {
        String sql = "update enfermeiros set nome = ?, telefone = ?, cpf = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cadastroEnfermeiro.getNome());
        ps.setString(2, cadastroEnfermeiro.getTelefone());
        ps.setString(3, cadastroEnfermeiro.getCpf());
        ps.setInt(4, cadastroEnfermeiro.getId());
        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from enfermeiros where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

}

