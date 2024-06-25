package trabalho.dao;

import trabalho.model.CadastroResponsavel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroResponsavelDao {
    private Connection connection;

    public CadastroResponsavelDao() throws SQLException {
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

    public void inserirResponsavel(CadastroResponsavel cadastroResponsavel) throws SQLException {
        String sql = "insert into responsaveis(nome, cpf, telefone, data_nascimento, cep, rua, bairro, numero, complemento,uf, cidade) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cadastroResponsavel.getNome());
        ps.setString(2, cadastroResponsavel.getCpf());
        ps.setString(3, cadastroResponsavel.getTelefone());
        ps.setDate(4, Date.valueOf(cadastroResponsavel.getDataNascimento()));
        ps.setString(5, cadastroResponsavel.getCep());
        ps.setString(6, cadastroResponsavel.getRua());
        ps.setString(7, cadastroResponsavel.getBairro());
        ps.setInt(8, cadastroResponsavel.getNumeroCasa());
        ps.setString(9, cadastroResponsavel.getComplemento());
        ps.setString(10, cadastroResponsavel.getUf());
        ps.setString(11, cadastroResponsavel.getCidade());
        ps.execute();
    }

    public List<CadastroResponsavel> listarTodosResponsaveis() throws SQLException {
        List<CadastroResponsavel> cadastroResponsavels = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("select * from responsaveis").executeQuery();
        while (rs.next()) {
            cadastroResponsavels.add(new CadastroResponsavel(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getDate("data_nascimento").toLocalDate(),
                    rs.getString("cep"),
                    rs.getString("rua"),
                    rs.getString("bairro"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("uf"),
                    rs.getString("cidade")

            ));
        }
        rs.close();

        return cadastroResponsavels;
    }

    public void atualizarResponsavel(CadastroResponsavel cadastroResponsavel) throws SQLException {
        String sql = "update responsaveis set nome = ?, cpf = ?, telefone = ?, data_nascimento = ?, cep = ?, rua = ?, bairro = ?, numero = ?, complemento = ?, uf = ?, cidade = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cadastroResponsavel.getNome());
        ps.setString(2, cadastroResponsavel.getCpf());
        ps.setString(3, cadastroResponsavel.getTelefone());
        ps.setDate(4, Date.valueOf(cadastroResponsavel.getDataNascimento()));
        ps.setString(5, cadastroResponsavel.getCep());
        ps.setString(6, cadastroResponsavel.getRua());
        ps.setString(7, cadastroResponsavel.getBairro());
        ps.setInt(8, cadastroResponsavel.getNumeroCasa());
        ps.setString(9, cadastroResponsavel.getComplemento());
        ps.setString(10, cadastroResponsavel.getUf());
        ps.setString(11, cadastroResponsavel.getCidade());
        ps.setInt(12, cadastroResponsavel.getId());
        ps.execute();
    }

    public void deletarResponsavel(int id) throws SQLException {
        String sql = "delete from responsaveis where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }


}
