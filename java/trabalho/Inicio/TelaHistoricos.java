package trabalho.Inicio;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class TelaHistoricos extends JFrame {

    private JLabel bemVindo;
    private JButton botaoCadastro;
    private JButton botaoHistorico;


    public TelaHistoricos() {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Sistema");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(7, 7, 7, 7);

        bemVindo = new JLabel("Históricos");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(bemVindo, constraints);

        botaoCadastro = new JButton("Cadastrar Historico");
        botaoCadastro.addActionListener(e -> irParaCadastro());
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(botaoCadastro, constraints);

        botaoHistorico = new JButton("Visualizar Historico");
        botaoHistorico.addActionListener(e -> irParaHistorico());
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(botaoHistorico, constraints);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);

        setLocationRelativeTo(null);
    }

    public void irParaCadastro() {
        trabalho.mains.MainCadastroHistorico.main(null);

    }

    public void irParaHistorico() {
        trabalho.mains.MainVisuHistorico.main(null);
    }


}
