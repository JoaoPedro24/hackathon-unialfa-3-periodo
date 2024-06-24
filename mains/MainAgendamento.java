package trabalho.mains;

import trabalho.view.AgendamentoForm;

import javax.swing.*;
import java.sql.SQLException;

public class MainAgendamento {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AgendamentoForm form = null;
            try {
                form = new AgendamentoForm();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            form.setVisible(true);
        });
    }
}
