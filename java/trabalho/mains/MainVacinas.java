package trabalho.mains;

import trabalho.view.CadastroEnfermeiroForm;
import trabalho.view.CadastroVacinasForm;

import javax.swing.*;

public class MainVacinas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new CadastroVacinasForm();
            form.setVisible(true);
        });
    }
}
