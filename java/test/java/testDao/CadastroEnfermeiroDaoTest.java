package testDao;

import org.junit.jupiter.api.*;
import trabalho.dao.CadastroEnfermeiroDao;
import trabalho.model.CadastroEnfermeiro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CadastroEnfermeiroDaoTest {

    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private CadastroEnfermeiroDao dao;
    private Connection connection;

    @BeforeAll
    static void setupDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.createStatement().execute("CREATE TABLE enfermeiros (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nome VARCHAR(255)," +
                "telefone VARCHAR(255)," +
                "cpf VARCHAR(255)" +
                ")");
        connection.close();
    }

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        dao = new CadastroEnfermeiroDao() {
            @Override
            public Connection getConnection() {
                return connection;
            }
        };
        connection.createStatement().execute("TRUNCATE TABLE enfermeiros");
    }

    @Test
    void testAtualizar() throws SQLException {
        CadastroEnfermeiro enfermeiro = new CadastroEnfermeiro(null, "Teste", "44912345678", "12345678900");
        dao.inserir(enfermeiro);

        CadastroEnfermeiro enfermeiroInserido = dao.listarTodos().get(0);
        enfermeiroInserido.setNome("Atualizado");
        dao.atualizar(enfermeiroInserido);

        CadastroEnfermeiro enfermeiroAtualizado = dao.listarTodos().get(0);
        assertEquals("Atualizado", enfermeiroAtualizado.getNome());
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }

    @AfterAll
    static void teardownDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.createStatement().execute("DROP TABLE enfermeiros");
        connection.close();
    }
}
