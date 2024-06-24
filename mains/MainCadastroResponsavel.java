package trabalho.mains;

import trabalho.view.CadastroResponsavelForm;

import javax.swing.*;

public class MainCadastroResponsavel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new CadastroResponsavelForm();
            form.setVisible(true);
        });
    }
}
