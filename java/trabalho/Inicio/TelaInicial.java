package trabalho.Inicio;

import com.formdev.flatlaf.FlatLightLaf;
import trabalho.mains.MainTelaCadastros;
import trabalho.mains.MainTelaHistorico;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.Image;
import javax.imageio.ImageIO;

public class TelaInicial extends JFrame {

    private JButton botaoCadastro;
    private JButton botaoAgendamento;
    private JButton botaoHistorico;
    private JButton botaoAlertas;
    private JLabel labelLogo;

    public TelaInicial() {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Sistema");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        ImageIcon icon = createImageIcon("/logo.jpeg", 300, 300);
        labelLogo = new JLabel(icon);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        painelEntrada.add(labelLogo, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1.0;
        painelEntrada.add(Box.createVerticalGlue(), constraints);

        JPanel painelBotoes = new JPanel(new GridBagLayout());
        GridBagConstraints botoesConstraints = new GridBagConstraints();
        botoesConstraints.insets = new Insets(7, 7, 7, 7);

        botaoCadastro = new JButton("Cadastrar");
        botaoCadastro.addActionListener(e -> irParaCadastro());
        botoesConstraints.gridx = 0;
        botoesConstraints.gridy = 0;
        painelBotoes.add(botaoCadastro, botoesConstraints);

        botaoAgendamento = new JButton("Agendar Consulta");
        botaoAgendamento.addActionListener(e -> irParaAgendamento());
        botoesConstraints.gridx = 0;
        botoesConstraints.gridy = 1;
        painelBotoes.add(botaoAgendamento, botoesConstraints);

        botaoHistorico = new JButton("Histórico Médico");
        botaoHistorico.addActionListener(e -> irParaHistorico());
        botoesConstraints.gridx = 0;
        botoesConstraints.gridy = 2;
        painelBotoes.add(botaoHistorico, botoesConstraints);

        botaoAlertas = new JButton("Alertas e Lembretes");
        botaoAlertas.addActionListener(e -> irParaAlertas());
        botoesConstraints.gridx = 0;
        botoesConstraints.gridy = 3;
        painelBotoes.add(botaoAlertas, botoesConstraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        painelEntrada.add(painelBotoes, constraints);

        getContentPane().add(painelEntrada, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private ImageIcon createImageIcon(String path, int width, int height) {
        URL imageUrl = getClass().getResource(path);
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);
            Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } else {
            System.err.println("Imagem não encontrada: " + path);
            return null;
        }
    }

    public void irParaCadastro() {
        MainTelaCadastros.main(null);
    }

    public void irParaAgendamento() {
        trabalho.mains.MainAgendamento.main(null);
    }

    public void irParaHistorico() {
        MainTelaHistorico.main(null);
    }

    public void irParaAlertas() {
        trabalho.mains.MainAlertas.main(null);
    }

}
