package trabalho.mains;



import trabalho.view.CadastroEnfermeiroForm;

import javax.swing.*;


    public class MainCadastroEnfermeiro {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                var form = new CadastroEnfermeiroForm();
                form.setVisible(true);
            });
        }
    }

