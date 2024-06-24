package trabalho.mains;

import trabalho.Inicio.TelaCadastros;

import javax.swing.*;

public class MainTelaCadastros {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new TelaCadastros();
            form.setVisible(true);
        });
    }
}
