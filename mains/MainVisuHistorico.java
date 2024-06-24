package trabalho.mains;

import trabalho.view.VisuHistoricoForm;

import javax.swing.*;

public class MainVisuHistorico {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new VisuHistoricoForm();
            form.setVisible(true);
        });
    }
}
