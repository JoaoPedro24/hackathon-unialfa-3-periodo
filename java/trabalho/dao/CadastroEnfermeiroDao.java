package trabalho.dao;

import trabalho.model.Alerta;
import trabalho.model.CadastroEnfermeiro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroEnfermeiroDao {

    private static final String URL = "jdbc:mysql://localhost:3306/hackton";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    private Connection connection;

    public CadastroEnfermeiroDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hackton?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }

    //Enfermeiros//
    public void inserir(CadastroEnfermeiro cadastroEnfermeiro) throws SQLException {
        String sql = "insert into enfermeiro(nome, telefone, cpf) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cadastroEnfermeiro.getNome());
        ps.setString(2, cadastroEnfermeiro.getTelefone());
        ps.setString(3, cadastroEnfermeiro.getCpf());
        ps.execute();
    }

    public List<CadastroEnfermeiro> listarTodos() throws SQLException {
        List<CadastroEnfermeiro> cadastroEnfermeiros = new ArrayList<>();
        ResultSet rs = connection.prepareStatement("select * from enfermeiro").executeQuery();
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
        String sql = "update enfermeiro set nome = ?, telefone = ?, cpf = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cadastroEnfermeiro.getNome());
        ps.setString(2, cadastroEnfermeiro.getTelefone());
        ps.setString(3, cadastroEnfermeiro.getCpf());
        ps.setInt(4, cadastroEnfermeiro.getId());
        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from enfermeiro where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }


    //Idosos//


    //Alertas//
        public List<Alerta> listarTodosAlertas() throws SQLException {
            List<Alerta> alertas = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
                 PreparedStatement stmt = conn.prepareStatement(
                         "SELECT idoso.nome as nome_idoso, idoso.cpf, idoso.telefone, agendamento.data, vacina.nome as nome_vacina " +
                                 "FROM agendamento " +
                                 "JOIN idoso ON agendamento.id_idoso = idoso.id " +
                                 "JOIN vacina ON agendamento.id_vacina = vacina.id " +
                                 "WHERE agendamento.data >= CURDATE() " +
                                 "ORDER BY agendamento.data")) {

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String nomeIdoso = rs.getString("nome_idoso");
                    String cpf = rs.getString("cpf");
                    String telefone = rs.getString("telefone");
                    Date data = rs.getDate("data");
                    String nomeVacina = rs.getString("nome_vacina");

                    Alerta alerta = new Alerta(nomeIdoso, cpf, telefone, data, nomeVacina);
                    alertas.add(alerta);
                }
            } catch (SQLException e) {
                throw new SQLException("Erro ao listar alertas: " + e.getMessage());
            }

            return alertas;
        }









}