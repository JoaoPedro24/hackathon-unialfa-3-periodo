package trabalho.mains;

import trabalho.view.HistoricoForm;

import javax.swing.*;
import java.sql.SQLException;

public class MainCadastroHistorico {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HistoricoForm form = null;
            try {
                form = new HistoricoForm();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            form.setVisible(true);
        });
    }
}
