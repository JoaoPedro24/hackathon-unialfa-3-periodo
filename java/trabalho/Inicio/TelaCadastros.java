package trabalho.Inicio;

import com.formdev.flatlaf.FlatLightLaf;
import trabalho.mains.MainCadastroResponsavel;

import javax.swing.*;
import java.awt.*;

public class TelaCadastros extends JFrame {
    private JButton botaoCadastroEnfermeiros;
    private JButton botaoCadastroVacinas;
    private JButton botaoCadastroResponsaveis;
    private JLabel bemVindo;
    private JButton botaoCadastroIdoso;

    public TelaCadastros() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setTitle("Tela de Cadastros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(7, 7, 7, 7);

        bemVindo = new JLabel("Bem Vindo");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(bemVindo, constraints);


        botaoCadastroEnfermeiros = new JButton("Cadastrar Enfermeiros");
        botaoCadastroEnfermeiros.addActionListener(e -> irParaCadastroEnfermeiros());
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(botaoCadastroEnfermeiros, constraints);

        botaoCadastroVacinas = new JButton("Cadastrar Vacinas");
        botaoCadastroVacinas.addActionListener(e -> irParaCadastroVacinas());
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(botaoCadastroVacinas, constraints);

        botaoCadastroResponsaveis = new JButton("Cadastrar Responsaveis");
        botaoCadastroResponsaveis.addActionListener(e -> irParaCadastroResponsaveis());
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(botaoCadastroResponsaveis, constraints);

        botaoCadastroIdoso = new JButton("Cadastrar Idosos");
        botaoCadastroIdoso.addActionListener(e -> irParaCadastroIdosos());
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(botaoCadastroIdoso, constraints);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);

        setLocationRelativeTo(null);
    }

    public void irParaCadastroEnfermeiros() {
        trabalho.mains.MainCadastroEnfermeiro.main(null);
    }

    public void irParaCadastroVacinas() {
        trabalho.mains.MainVacinas.main(null);
    }

    public void irParaCadastroResponsaveis() {
        MainCadastroResponsavel.main(null);
    }

    public void irParaCadastroIdosos() {
        trabalho.mains.MainCadastroIdoso.main(null);
    }


}
