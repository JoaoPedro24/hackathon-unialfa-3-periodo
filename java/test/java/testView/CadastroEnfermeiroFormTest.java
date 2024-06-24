package testView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import trabalho.model.CadastroEnfermeiro;
import trabalho.service.CadastroEnfermeiroService;
import trabalho.view.CadastroEnfermeiroForm;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CadastroEnfermeiroFormTest {

    private CadastroEnfermeiroForm form;
    private CadastroEnfermeiroService serviceMock;

    @BeforeEach
    void setUp() throws Exception {
        serviceMock = mock(CadastroEnfermeiroService.class);
        form = new CadastroEnfermeiroForm();
        form.service = serviceMock;
    }

    @Test
    void testLimparCampos() {
        form.campoNome.setText("Teste");
        form.campoTelefone.setText("44912345678");
        form.campoCpf.setText("12345678900");

        form.limparCampos();

        assertEquals("", form.campoNome.getText());
        assertEquals("", form.campoTelefone.getText());
        assertEquals("", form.campoCpf.getText());
    }


    @Test
    void testExcluirCadastro() {
        form.campoId.setText("1");
        form.campoNome.setText("Teste");
        form.campoTelefone.setText("44912345678");
        form.campoCpf.setText("12345678900");

        form.excluirDados();

        ArgumentCaptor<CadastroEnfermeiro> captor = ArgumentCaptor.forClass(CadastroEnfermeiro.class);
        verify(serviceMock).deletar(captor.capture());

        CadastroEnfermeiro enfermeiroExcluido = captor.getValue();
        assertEquals(1, enfermeiroExcluido.getId());
        assertEquals("Teste", enfermeiroExcluido.getNome());
        assertEquals("44912345678", enfermeiroExcluido.getTelefone());
        assertEquals("12345678900", enfermeiroExcluido.getCpf());
    }


}
