package atividade;

import atividade.view.DiretorForm;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new DiretorForm();
            form.setVisible(true);
        });
    }
}
