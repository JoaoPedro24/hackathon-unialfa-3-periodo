package testDao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import trabalho.dao.CadastroVacinaDao;
import trabalho.model.CadastroVacina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CadastroVacinaDaoTest {

    private CadastroVacinaDao vacinaDao;

    @Mock
    private Connection connectionMock;

    @Mock
    private PreparedStatement preparedStatementMock;

    @Mock
    private ResultSet resultSetMock;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        vacinaDao = new CadastroVacinaDao();
        vacinaDao.connection = connectionMock;
    }

    @Test
    public void testInserirVacinas() throws SQLException {
        CadastroVacina vacina = new CadastroVacina("Vacina A", 30, 18);

        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
        doNothing().when(preparedStatementMock).setString(anyInt(), anyString());
        doNothing().when(preparedStatementMock).setInt(anyInt(), anyInt());
        when(preparedStatementMock.execute()).thenReturn(true);

        vacinaDao.inserirVacinas(vacina);

        verify(connectionMock, times(1)).prepareStatement(anyString());
        verify(preparedStatementMock, times(1)).setString(1, "Vacina A");
        verify(preparedStatementMock, times(1)).setInt(2, 30);
        verify(preparedStatementMock, times(1)).setInt(3, 18);
        verify(preparedStatementMock, times(1)).execute();
    }


    @Test
    public void testAtualizarVacinas() throws SQLException {
        CadastroVacina vacina = new CadastroVacina(1, "Vacina A", 30, 18);

        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
        doNothing().when(preparedStatementMock).setString(anyInt(), anyString());
        doNothing().when(preparedStatementMock).setInt(anyInt(), anyInt());
        when(preparedStatementMock.execute()).thenReturn(true);

        vacinaDao.atualizarVacinas(vacina);

        verify(connectionMock, times(1)).prepareStatement(anyString());
        verify(preparedStatementMock, times(1)).setString(1, "Vacina A");
        verify(preparedStatementMock, times(1)).setInt(2, 30);
        verify(preparedStatementMock, times(1)).setInt(3, 18);
        verify(preparedStatementMock, times(1)).setInt(4, 1);
        verify(preparedStatementMock, times(1)).execute();
    }

    @Test
    public void testDeletarVacinas() throws SQLException {
        int id = 1;

        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
        doNothing().when(preparedStatementMock).setInt(anyInt(), anyInt());
        when(preparedStatementMock.execute()).thenReturn(true);

        vacinaDao.deletarVacinas(id);

        verify(connectionMock, times(1)).prepareStatement(anyString());
        verify(preparedStatementMock, times(1)).setInt(1, 1);
        verify(preparedStatementMock, times(1)).execute();
    }
}
