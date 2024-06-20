package trabalho.mains;

import trabalho.Inicio.TelaInicial;

import javax.swing.*;

public class MainTelaP {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new TelaInicial();
            form.setVisible(true);
        });
    }
}
