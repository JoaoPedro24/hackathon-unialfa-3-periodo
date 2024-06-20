package trabalho.Inicio;

import javax.swing.*;
import java.awt.*;

public class TelaCadastros extends JFrame{
    private JButton botaoCadastroEnfermeiros;
    private JButton botaoCadastroVacinas;
    private JButton botaoCadastroResponsaveis;
    private JLabel bemVindo;
    public TelaCadastros(){

        setTitle("Tela de Cadastros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

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
        //botaoCadastroResponsaveis.addActionListener(e -> irParaCadastroResponsaveis());
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(botaoCadastroResponsaveis, constraints);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);

        setLocationRelativeTo(null);
    }

    public void irParaCadastroEnfermeiros(){
        trabalho.mains.MainCadastroEnfermeiro.main(null);
    }

    public void irParaCadastroVacinas(){
        trabalho.mains.MainVacinas.main(null);
    }










}
