package trabalho.mains;

import trabalho.Inicio.TelaAlertas;

import javax.swing.*;

public class MainAlertas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new TelaAlertas();
            form.setVisible(true);
        });
    }
}
