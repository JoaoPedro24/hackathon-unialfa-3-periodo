package testDao;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import trabalho.dao.AgendamentoDao;
import trabalho.model.Agendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDaoTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    private AgendamentoDao agendamentoDao;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        agendamentoDao = new AgendamentoDao();
        agendamentoDao.connection = mockConnection;
    }

    @Test
    public void testAgendarVisita() throws SQLException {
        Agendamento agendamento = new Agendamento(
                "2024-06-25", 1, 2, 3, "Observações");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        doNothing().when(mockPreparedStatement).setDate(anyInt(), any());
        doNothing().when(mockPreparedStatement).setInt(anyInt(), anyInt());
        doNothing().when(mockPreparedStatement).setString(anyInt(), anyString());
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        agendamentoDao.agendarVisita(agendamento);

        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testGetNomes() throws SQLException {
        List<String> expectedNomes = new ArrayList<>();
        expectedNomes.add("Idoso 1");
        expectedNomes.add("Idoso 2");
        expectedNomes.add("Idoso 3");

        when(mockConnection.createStatement()).thenReturn(mock(Statement.class));
        when(mockConnection.createStatement().executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, true, false);
        when(mockResultSet.getString("nome")).thenReturn("Idoso 1", "Idoso 2", "Idoso 3");

        List<String> actualNomes = agendamentoDao.getNomes("idosos");

        assertEquals(expectedNomes, actualNomes);
    }

    @Test
    public void testGetId() throws SQLException {
        String nome = "Enfermeiro 1";
        int expectedId = 1;

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(expectedId);

        int actualId = agendamentoDao.getId("enfermeiros", nome);

        assertEquals(expectedId, actualId);
    }
}
