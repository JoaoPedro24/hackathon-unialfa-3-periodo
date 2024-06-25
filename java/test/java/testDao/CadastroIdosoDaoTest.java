package testDao;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import trabalho.dao.CadastroIdosoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroIdosoDaoTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    private CadastroIdosoDao cadastroIdosoDao;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        cadastroIdosoDao = new CadastroIdosoDao();
        cadastroIdosoDao.connection = mockConnection;
    }

    @Test
    public void testListarIdsIdosos() throws SQLException {
        List<Integer> expectedIds = new ArrayList<>();
        expectedIds.add(1);
        expectedIds.add(2);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, false);
        when(mockResultSet.getInt("id")).thenReturn(1, 2);

        List<Integer> actualIds = cadastroIdosoDao.listarIdsIdosos();

        assertEquals(expectedIds, actualIds);
    }

    @Test
    public void testListarIdsResponsaveis() throws SQLException {
        List<Integer> expectedIds = new ArrayList<>();
        expectedIds.add(1);
        expectedIds.add(2);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, false);
        when(mockResultSet.getInt("id")).thenReturn(1, 2);

        List<Integer> actualIds = cadastroIdosoDao.listarIdsResponsaveis();

        assertEquals(expectedIds, actualIds);
    }


}

