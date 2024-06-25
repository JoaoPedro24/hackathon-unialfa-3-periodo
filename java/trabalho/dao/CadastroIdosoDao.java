package trabalho.dao;

import trabalho.model.CadastroIdoso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroIdosoDao {
    public Connection connection;

    public CadastroIdosoDao() throws SQLException {
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

    public List<Integer> listarIdsIdosos() throws SQLException {
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT id FROM idosos";

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ids.add(rs.getInt("id"));
        }

        return ids;
    }

    public List<Integer> listarIdsResponsaveis() throws SQLException {
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT id FROM responsaveis";

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ids.add(rs.getInt("id"));
        }

        return ids;
    }

    public void inserirIdoso(CadastroIdoso cadastroIdoso) throws SQLException {
        String sql = "insert into idosos(id_responsavel, nome, cpf, telefone, data_nascimento, cep, rua, bairro, numero, complemento, uf, cidade) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cadastroIdoso.getIdResponsavel());
        ps.setString(2, cadastroIdoso.getNome());
        ps.setString(3, cadastroIdoso.getCpf());
        ps.setString(4, cadastroIdoso.getTelefone());
        ps.setDate(5, Date.valueOf(cadastroIdoso.getDataNascimento()));
        ps.setString(6, cadastroIdoso.getCep());
        ps.setString(7, cadastroIdoso.getRua());
        ps.setString(8, cadastroIdoso.getBairro());
        ps.setInt(9, cadastroIdoso.getNumeroCasa());
        ps.setString(10, cadastroIdoso.getComplemento());
        ps.setString(11, cadastroIdoso.getUf());
        ps.setString(12, cadastroIdoso.getCidade());
        ps.execute();
    }

    public List<CadastroIdoso> listarTodosIdosos() throws SQLException {
        List<CadastroIdoso> cadastroIdosos = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("select * from idosos").executeQuery();
        while (rs.next()) {
            cadastroIdosos.add(new CadastroIdoso(
                    rs.getInt("id"),
                    rs.getInt("id_responsavel"),
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

        return cadastroIdosos;
    }

    public void atualizarIdoso(CadastroIdoso cadastroIdoso) throws SQLException {
        String sql = "update idosos set id_responsavel = ?, nome = ?, cpf = ?, telefone = ?, data_nascimento = ?, cep = ?, rua = ?, bairro = ?, numero = ?, complemento = ?, uf = ?, cidade = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cadastroIdoso.getIdResponsavel());
        ps.setString(2, cadastroIdoso.getNome());
        ps.setString(3, cadastroIdoso.getCpf());
        ps.setString(4, cadastroIdoso.getTelefone());
        ps.setDate(5, Date.valueOf(cadastroIdoso.getDataNascimento()));
        ps.setString(6, cadastroIdoso.getCep());
        ps.setString(7, cadastroIdoso.getRua());
        ps.setString(8, cadastroIdoso.getBairro());
        ps.setInt(9, cadastroIdoso.getNumeroCasa());
        ps.setString(10, cadastroIdoso.getComplemento());
        ps.setString(11, cadastroIdoso.getUf());
        ps.setString(12, cadastroIdoso.getCidade());
        ps.setInt(13, cadastroIdoso.getId());
        ps.execute();
    }

    public void deletarIdoso(int id) throws SQLException {
        String sql = "delete from idosos where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

}
