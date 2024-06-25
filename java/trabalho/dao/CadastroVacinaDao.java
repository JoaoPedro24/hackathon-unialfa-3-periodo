package trabalho.dao;

import trabalho.model.CadastroVacina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroVacinaDao {
    public Connection connection;

    public CadastroVacinaDao() throws SQLException {
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


    public void inserirVacinas(CadastroVacina cadastroVacina) throws SQLException {
        String sql = "insert into vacinas(nome, prazo, idade_minima) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cadastroVacina.getNome());
        ps.setInt(2, cadastroVacina.getPrazo());
        ps.setInt(3, cadastroVacina.getIdade_minima());
        ps.execute();
    }

    public List<CadastroVacina> listarTodasVacinas() throws SQLException {
        List<CadastroVacina> cadastroVacinas = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("select * from vacinas").executeQuery();
        while (rs.next()) {
            cadastroVacinas.add(new CadastroVacina(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("prazo"),
                    rs.getInt("idade_minima")

            ));
        }
        rs.close();

        return cadastroVacinas;
    }

    public void atualizarVacinas(CadastroVacina cadastroVacina) throws SQLException {
        String sql = "update vacinas set nome = ?, prazo = ?, idade_minima = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cadastroVacina.getNome());
        ps.setInt(2, cadastroVacina.getPrazo());
        ps.setInt(3, cadastroVacina.getIdade_minima());
        ps.setInt(4, cadastroVacina.getId());
        ps.execute();
    }

    public void deletarVacinas(int id) throws SQLException {
        String sql = "delete from vacinas where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

}

