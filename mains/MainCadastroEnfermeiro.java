package trabalho.mains;


import trabalho.view.CadastroEnfermeiroForm;

import javax.swing.*;
import java.text.ParseException;


public class MainCadastroEnfermeiro {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroEnfermeiroForm form = null;
            try {
                form = new CadastroEnfermeiroForm();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            form.setVisible(true);
        });
    }
}

