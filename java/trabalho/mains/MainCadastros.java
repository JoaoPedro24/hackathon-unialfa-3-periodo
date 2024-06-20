package trabalho.mains;

import trabalho.Inicio.TelaCadastros;
import trabalho.view.CadastroVacinasForm;

import javax.swing.*;

public class MainCadastros {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new TelaCadastros();
            form.setVisible(true);
        });
    }
}
