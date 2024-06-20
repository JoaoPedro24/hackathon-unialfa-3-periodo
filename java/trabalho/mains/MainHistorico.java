package trabalho.mains;

import trabalho.Inicio.TelaHist1;

import javax.swing.*;

public class MainHistorico {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new TelaHist1();
            form.setVisible(true);
        });
    }
}
