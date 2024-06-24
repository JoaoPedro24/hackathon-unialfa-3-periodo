package trabalho.mains;

import trabalho.Inicio.TelaHistoricos;

import javax.swing.*;

public class MainTelaHistorico {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new TelaHistoricos();
            form.setVisible(true);
        });
    }
}
