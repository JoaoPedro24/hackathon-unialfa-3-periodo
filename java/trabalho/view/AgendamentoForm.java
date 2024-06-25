package trabalho.view;

import trabalho.model.Agendamento;
import trabalho.service.AgendamentoService;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class AgendamentoForm extends JFrame {

    private JTextField dataField;
    private JComboBox<String> idosoComboBox;
    private JComboBox<String> enfermeiroComboBox;
    private JComboBox<String> vacinaComboBox;
    private JTextField observacaoField;
    private AgendamentoService agendamentoService;

    public AgendamentoForm() throws SQLException {

        this.agendamentoService = new AgendamentoService();


        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Agendamento de Visita");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel idosoLabel = new JLabel("Idoso:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(idosoLabel, constraints);

        idosoComboBox = new JComboBox<>();
        carregarNomes("idosos", idosoComboBox);
        constraints.gridx = 1;
        panel.add(idosoComboBox, constraints);


        JLabel enfermeiroLabel = new JLabel("Enfermeiro:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(enfermeiroLabel, constraints);

        enfermeiroComboBox = new JComboBox<>();
        carregarNomes("enfermeiros", enfermeiroComboBox);
        constraints.gridx = 1;
        panel.add(enfermeiroComboBox, constraints);


        JLabel vacinaLabel = new JLabel("Vacina:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(vacinaLabel, constraints);

        vacinaComboBox = new JComboBox<>();
        carregarNomes("vacinas", vacinaComboBox);
        constraints.gridx = 1;
        panel.add(vacinaComboBox, constraints);


        JLabel dataLabel = new JLabel("Data:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(dataLabel, constraints);

        dataField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(dataField, constraints);


        JLabel observacaoLabel = new JLabel("Observação:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(observacaoLabel, constraints);

        observacaoField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(observacaoField, constraints);


        JButton agendarButton = new JButton("Agendar");
        agendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agendarVisita();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(agendarButton, constraints);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));


        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void carregarNomes(String tabela, JComboBox<String> comboBox) {
        List<String> nomes = agendamentoService.getNomes(tabela);
        for (String nome : nomes) {
            comboBox.addItem(nome);
        }
    }

    private void agendarVisita() {
        String idoso = (String) idosoComboBox.getSelectedItem();
        String enfermeiro = (String) enfermeiroComboBox.getSelectedItem();
        String vacina = (String) vacinaComboBox.getSelectedItem();
        String data = dataField.getText();
        String observacao = observacaoField.getText();

        Agendamento agendamento = new Agendamento();
        agendamento.setData(data);
        agendamento.setIdIdoso(agendamentoService.getId("idosos", idoso));
        agendamento.setIdEnfermeiro(agendamentoService.getId("enfermeiros", enfermeiro));
        agendamento.setIdVacina(agendamentoService.getId("vacinas", vacina));
        agendamento.setObservacao(observacao);

        agendamentoService.agendarVisita(agendamento);
        JOptionPane.showMessageDialog(this, "Agendamento realizado com sucesso!");
    }

}
