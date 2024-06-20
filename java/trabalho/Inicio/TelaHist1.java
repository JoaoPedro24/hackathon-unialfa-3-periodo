package trabalho.Inicio;

import javax.swing.*;
import java.awt.*;

public class TelaHist1 extends JFrame{

    private JLabel bemVindo;
    private JButton botaoCadastro;
    private JButton botaoHistorico;


public TelaHist1(){
    setTitle("Bem Vindo");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);

    JPanel painelEntrada = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.insets = new Insets(7, 7, 7, 7);

    bemVindo = new JLabel("Bem Vindo");
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

public void irParaCadastro(){


}

public void irParaHistorico(){

}




}
