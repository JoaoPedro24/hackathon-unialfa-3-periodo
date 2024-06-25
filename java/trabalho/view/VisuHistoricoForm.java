package trabalho.view;

import com.formdev.flatlaf.FlatLightLaf;
import trabalho.model.HistoricoMedico;
import trabalho.service.HistoricoService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static java.lang.Integer.parseInt;

public class VisuHistoricoForm extends JFrame {


    private HistoricoService service;
    private JLabel labelId;
    private JTextField campoId;

    private JLabel labelIdIdoso;
    private JTextField campoIdIdoso;

    private JLabel labelAlergias;
    private JTextField campoAlergias;

    private JLabel labelCondicoes;
    private JTextField campoCondicoes;

    private JLabel labelObservacoes;
    private JTextField campoObservacoes;

    private JTable tabelaCadastro;

    public VisuHistoricoForm() {

        service = new HistoricoService();

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Visualizar Historicos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 1050);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        labelId = new JLabel("ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painelEntrada.add(labelId, constraints);

        campoId = new JTextField(20);
        campoId.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painelEntrada.add(campoId, constraints);

        labelIdIdoso = new JLabel("ID Idoso");
        constraints.gridx = 2;
        constraints.gridy = 0;
        painelEntrada.add(labelIdIdoso, constraints);

        campoIdIdoso = new JTextField(20);
        campoIdIdoso.setEnabled(false);
        constraints.gridx = 3;
        constraints.gridy = 0;
        painelEntrada.add(campoIdIdoso, constraints);

        labelAlergias = new JLabel("Alergias:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelAlergias, constraints);

        campoAlergias = new JTextField(20);
        campoAlergias.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoAlergias, constraints);

        labelCondicoes = new JLabel("Condições:");
        constraints.gridx = 2;
        constraints.gridy = 1;
        painelEntrada.add(labelCondicoes, constraints);

        campoCondicoes = new JTextField(20);
        campoCondicoes.setEnabled(false);
        constraints.gridx = 3;
        constraints.gridy = 1;
        painelEntrada.add(campoCondicoes, constraints);

        labelObservacoes = new JLabel("Observações:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelObservacoes, constraints);

        campoObservacoes = new JTextField(20);
        campoObservacoes.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoObservacoes, constraints);


        JPanel painelSaida = new JPanel(new BorderLayout());

        tabelaCadastro = new JTable();
        tabelaCadastro.setModel(carregarDadosHistorico());
        tabelaCadastro.getSelectionModel().addListSelectionListener(e -> selecionarHistorico(e));
        tabelaCadastro.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(tabelaCadastro);
        painelSaida.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private void limparCampos() {
        campoId.setText("");
        campoIdIdoso.setText("");
        campoAlergias.setText("");
        campoCondicoes.setText("");
        campoObservacoes.setText("");

    }


    private HistoricoMedico construirHistorico() {
        return campoId.getText().isEmpty()
                ? new HistoricoMedico(parseInt(campoIdIdoso.getText()), campoAlergias.getText(), campoCondicoes.getText(), campoObservacoes.getText())
                : new HistoricoMedico(
                parseInt(campoId.getText()),
                parseInt(campoIdIdoso.getText()),
                campoAlergias.getText(),
                campoCondicoes.getText(),
                campoObservacoes.getText());

    }

    private DefaultTableModel carregarDadosHistorico() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("ID Idoso");
        model.addColumn("Alergias");
        model.addColumn("Condições");
        model.addColumn("Observações");


        service.listarHistorico().forEach(cadastroHistorico ->
                model.addRow(new Object[]{
                                cadastroHistorico.getId(),
                                cadastroHistorico.getId_idoso(),
                                cadastroHistorico.getAlergias(),
                                cadastroHistorico.getCondicoes(),
                                cadastroHistorico.getObservacoes()
                        }
                )
        );
        return model;

    }


    private void selecionarHistorico(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaCadastro.getSelectedRow();
            if (selectedRow != -1) {

                var id = (Integer) tabelaCadastro.getValueAt(selectedRow, 0);
                campoId.setText(id.toString());

                var idIdoso = (Integer) tabelaCadastro.getValueAt(selectedRow, 1);
                campoIdIdoso.setText(idIdoso.toString());

                var alergias = (String) tabelaCadastro.getValueAt(selectedRow, 2);
                campoAlergias.setText(alergias);

                var condicoes = (String) tabelaCadastro.getValueAt(selectedRow, 3);
                campoCondicoes.setText(condicoes);

                var observacoes = (String) tabelaCadastro.getValueAt(selectedRow, 4);
                campoObservacoes.setText(observacoes);


            }
        }
    }
}


