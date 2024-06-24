package trabalho.mains;

import trabalho.Inicio.TelaAlertas;
import trabalho.Inicio.TelaInicial;

import javax.swing.*;

public class MainTelaPrincipal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            var alert = new TelaAlertas();
            var form = new TelaInicial();

            form.setVisible(true);
            alert.setVisible(true);
        });
    }
}
