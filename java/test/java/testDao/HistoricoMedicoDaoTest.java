package testDao;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import trabalho.dao.HistoricoMedicoDao;
import trabalho.model.HistoricoMedico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoMedicoDaoTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    private HistoricoMedicoDao historicoMedicoDao;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        historicoMedicoDao = new HistoricoMedicoDao();
        historicoMedicoDao.connection = mockConnection;
    }

    @Test
    public void testInserirHistorico() throws SQLException {
        HistoricoMedico historicoMedico = new HistoricoMedico(1, "Alergias", "Condições", "Observações");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        doNothing().when(mockPreparedStatement).setInt(anyInt(), anyInt());
        doNothing().when(mockPreparedStatement).setString(anyInt(), anyString());
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        historicoMedicoDao.inserirHistorico(historicoMedico);

        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testAtualizarHistoricos() throws SQLException {
        HistoricoMedico historicoMedico = new HistoricoMedico(1, 1, "Alergias", "Condições", "Observações");

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        doNothing().when(mockPreparedStatement).setInt(anyInt(), anyInt());
        doNothing().when(mockPreparedStatement).setString(anyInt(), anyString());
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        historicoMedicoDao.atualizarHistoricos(historicoMedico);

        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    public void testDeletarHistorico() throws SQLException {
        int id = 1;

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        doNothing().when(mockPreparedStatement).setInt(anyInt(), anyInt());
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        historicoMedicoDao.deletarHistorico(id);

        verify(mockPreparedStatement, times(1)).executeUpdate();
    }
}
