package testService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import trabalho.dao.AgendamentoDao;
import trabalho.model.Agendamento;
import trabalho.service.AgendamentoService;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AgendamentoServiceTest {

    private AgendamentoService agendamentoService;

    @Mock
    private AgendamentoDao agendamentoDaoMock;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        agendamentoService = new AgendamentoService();
        agendamentoService.agendamentoDAO = agendamentoDaoMock;
    }

    @Test
    public void testAgendarVisita() {
        Agendamento agendamento = new Agendamento(/* Construa um objeto Agendamento válido */);

        doNothing().when(agendamentoDaoMock).agendarVisita(agendamento);

        agendamentoService.agendarVisita(agendamento);

        verify(agendamentoDaoMock, times(1)).agendarVisita(agendamento);
    }

    @Test
    public void testGetNomes() {
        String tabela = "alguma_tabela";
        List<String> nomesEsperados = Arrays.asList("Nome1", "Nome2", "Nome3");

        when(agendamentoDaoMock.getNomes(tabela)).thenReturn(nomesEsperados);

        List<String> nomesRetornados = agendamentoService.getNomes(tabela);

        assertEquals(nomesEsperados.size(), nomesRetornados.size());
        assertEquals(nomesEsperados, nomesRetornados);

        verify(agendamentoDaoMock, times(1)).getNomes(tabela);
    }

    @Test
    public void testGetId() {
        String tabela = "alguma_tabela";
        String nome = "Nome1";
        int idEsperado = 1;

        when(agendamentoDaoMock.getId(tabela, nome)).thenReturn(idEsperado);

        int idRetornado = agendamentoService.getId(tabela, nome);

        assertEquals(idEsperado, idRetornado);

        verify(agendamentoDaoMock, times(1)).getId(tabela, nome);
    }
}
