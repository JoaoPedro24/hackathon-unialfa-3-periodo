package trabalho.Inicio;

import trabalho.mains.MainCadastroEnfermeiro;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {

    private JButton botaoCadastro;
    private JButton botaoAgendamento;
    private JButton botaoHistorico;
    private JButton botaoAlertas;
    private JLabel teste;


public TelaInicial(){
    setTitle("Sistema");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);

    JPanel painelEntrada = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.insets = new Insets(7, 7, 7, 7);

    teste = new JLabel("Bem Vindo");
    constraints.gridx = 0;
    constraints.gridy = 1;
    painelEntrada.add(teste, constraints);


    botaoCadastro = new JButton("Cadastrar");
    botaoCadastro.addActionListener(e -> irParaCadastro());
    constraints.gridx = 0;
    constraints.gridy = 2;
    painelEntrada.add(botaoCadastro, constraints);

    botaoAgendamento = new JButton("Agendar Consulta");
    botaoAgendamento.addActionListener(e -> irParaAgendamento());
    constraints.gridx = 0;
    constraints.gridy = 3;
    painelEntrada.add(botaoAgendamento, constraints);

    botaoHistorico = new JButton("Historico Médico");
    botaoHistorico.addActionListener(e -> irParaHistorico());
    constraints.gridx = 0;
    constraints.gridy = 4;
    painelEntrada.add(botaoHistorico, constraints);

    botaoAlertas = new JButton("Alertas e Lembretes");
    botaoAlertas.addActionListener(e -> irParaAlertas());
    constraints.gridx = 0;
    constraints.gridy = 5;
    painelEntrada.add(botaoAlertas, constraints);

    getContentPane().add(painelEntrada, BorderLayout.NORTH);

    setLocationRelativeTo(null);
}

public void irParaCadastro(){
    trabalho.mains.MainCadastros.main(null);
}

public void irParaAgendamento(){
    trabalho.mains.MainAgendamento.main(null);
}
public void irParaHistorico(){
    trabalho.mains.MainHistorico.main(null);
}
public void irParaAlertas(){
    trabalho.mains.MainAlertas.main(null);
}

















}
