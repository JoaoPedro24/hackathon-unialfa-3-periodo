package testService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import trabalho.model.CadastroEnfermeiro;
import trabalho.service.CadastroEnfermeiroService;
import trabalho.view.CadastroEnfermeiroForm;

import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CadastroEnfermeiroServiceTest {

    private CadastroEnfermeiroForm cadastroEnfermeiroForm;

    @Mock
    private CadastroEnfermeiroService cadastroEnfermeiroServiceMock;

    @BeforeEach
    public void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        cadastroEnfermeiroForm = new CadastroEnfermeiroForm();
        cadastroEnfermeiroForm.service = cadastroEnfermeiroServiceMock;
    }


    @Test
    public void testExecutarAcaoDoBotao_FalhaCamposVazios() {
        cadastroEnfermeiroForm.campoNome.setText("");
        cadastroEnfermeiroForm.campoTelefone.setText("");
        cadastroEnfermeiroForm.campoCpf.setText("");

        cadastroEnfermeiroForm.executarAcaoDoBotao();

        verify(cadastroEnfermeiroServiceMock, never()).salvar(any(CadastroEnfermeiro.class));
    }

    @Test
    public void testExecutarAcaoDoBotao_FalhaLetrasNoTelefone() {
        cadastroEnfermeiroForm.campoNome.setText("João");
        cadastroEnfermeiroForm.campoTelefone.setText("1234abc5678");
        cadastroEnfermeiroForm.campoCpf.setText("12345678900");

        cadastroEnfermeiroForm.executarAcaoDoBotao();

        verify(cadastroEnfermeiroServiceMock, never()).salvar(any(CadastroEnfermeiro.class));
    }

    @Test
    public void testExecutarAcaoDoBotao_FalhaFormatoCPF() {
        cadastroEnfermeiroForm.campoNome.setText("João");
        cadastroEnfermeiroForm.campoTelefone.setText("12345678901");
        cadastroEnfermeiroForm.campoCpf.setText("1234567890");

        cadastroEnfermeiroForm.executarAcaoDoBotao();

        verify(cadastroEnfermeiroServiceMock, never()).salvar(any(CadastroEnfermeiro.class));
    }


    @Test
    public void testLimparCampos() {
        cadastroEnfermeiroForm.campoId.setText("1");
        cadastroEnfermeiroForm.campoNome.setText("João");
        cadastroEnfermeiroForm.campoTelefone.setText("12345678901");
        cadastroEnfermeiroForm.campoCpf.setText("12345678900");

        cadastroEnfermeiroForm.limparCampos();

        assertEquals("", cadastroEnfermeiroForm.campoId.getText());
        assertEquals("", cadastroEnfermeiroForm.campoNome.getText());
        assertEquals("", cadastroEnfermeiroForm.campoTelefone.getText());
        assertEquals("", cadastroEnfermeiroForm.campoCpf.getText());
    }

    @Test
    public void testExcluirDados() {

        cadastroEnfermeiroForm.campoId.setText("1");
        CadastroEnfermeiro cadastroEnfermeiro = new CadastroEnfermeiro(1, "João", "12345678901", "12345678900");

        doNothing().when(cadastroEnfermeiroServiceMock).deletar(any(CadastroEnfermeiro.class));

        cadastroEnfermeiroForm.excluirDados();

        verify(cadastroEnfermeiroServiceMock, times(1)).deletar(any(CadastroEnfermeiro.class));
        assertEquals("", cadastroEnfermeiroForm.campoId.getText());
    }

    @Test
    public void testCarregarDadosLocadoras() {

        List<CadastroEnfermeiro> cadastroEnfermeiros = Arrays.asList(
                new CadastroEnfermeiro(1, "João", "12345678901", "12345678900"),
                new CadastroEnfermeiro(2, "Maria", "98765432109", "98765432100")
        );
        when(cadastroEnfermeiroServiceMock.listarCadastro()).thenReturn(cadastroEnfermeiros);

        DefaultTableModel model = cadastroEnfermeiroForm.carregarDadosLocadoras();


        assertEquals(2, model.getRowCount());
        assertEquals(4, model.getColumnCount());
        assertEquals("ID", model.getColumnName(0));
        assertEquals("Nome", model.getColumnName(1));
        assertEquals("Telefone", model.getColumnName(2));
        assertEquals("CPF", model.getColumnName(3));
        assertEquals(1, model.getValueAt(0, 0));
        assertEquals("João", model.getValueAt(0, 1));
        assertEquals("12345678901", model.getValueAt(0, 2));
        assertEquals("12345678900", model.getValueAt(0, 3));
    }

}
