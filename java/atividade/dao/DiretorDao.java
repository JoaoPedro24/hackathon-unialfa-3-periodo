package atividade.dao;

import atividade.model.Diretor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiretorDao {
    private Connection connection;

    public DiretorDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void inserir(Diretor diretor) throws SQLException {
        String sql = "insert into diretor(nome, nacionalidade, data_nascimento, premiacao, data_inicio_carreira) values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, diretor.getNome());
        ps.setString(2, diretor.getNacionalidade());
        ps.setDate(3, Date.valueOf(diretor.getDataNascimento()));
        ps.setString(4,diretor.getPremiacao());
        ps.setDate(5, Date.valueOf(diretor.getDataInicioCarreira()));
        ps.execute();
    }

    public List<Diretor> listarTodos() throws SQLException {
        List<Diretor> diretores = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("select * from diretor").executeQuery();
        while (rs.next()) {
            diretores.add(new Diretor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("nacionalidade"),
                    rs.getDate("data_nascimento").toLocalDate(),
                    rs.getString("premiacao"),
                    rs.getDate("data_inicio_carreira").toLocalDate()
            ));
        }
        rs.close();

        return diretores;
    }

    public void atualizar(Diretor diretor) throws SQLException {
        String sql = "update diretor set nome = ?, nacionalidade = ?, data_nascimento = ?, premiacao = ?, data_inicio_carreira = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, diretor.getNome());
        ps.setString(2, diretor.getNacionalidade());
        ps.setDate(3, Date.valueOf(diretor.getDataNascimento()));
        ps.setString(4,diretor.getPremiacao());
        ps.setDate(5,Date.valueOf(diretor.getDataInicioCarreira()));
        ps.setInt(6, diretor.getId());
        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from diretor where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }
}
