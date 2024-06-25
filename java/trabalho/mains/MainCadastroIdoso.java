package trabalho.mains;

import trabalho.view.CadastroIdosoForm;
import trabalho.view.CadastroResponsavelForm;

import javax.swing.*;
import java.sql.SQLException;

public class MainCadastroIdoso {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroIdosoForm form = null;
            try {
                form = new CadastroIdosoForm();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            form.setVisible(true);
        });
    }
}
