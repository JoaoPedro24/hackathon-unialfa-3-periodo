package trabalho.view;

import com.formdev.flatlaf.FlatLightLaf;
import trabalho.model.HistoricoMedico;
import trabalho.service.HistoricoService;
import trabalho.service.CadastroIdosoService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static java.lang.Integer.parseInt;

public class HistoricoForm extends JFrame {

    private HistoricoService service;
    private CadastroIdosoService idosoService;

    private JLabel labelId;
    private JTextField campoId;

    private JLabel labelIdIdoso;
    private JComboBox<Integer> comboIdIdoso;

    private JLabel labelAlergias;
    private JTextField campoAlergias;

    private JLabel labelCondicoes;
    private JTextField campoCondicoes;

    private JLabel labelObservacoes;
    private JTextField campoObservacoes;

    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JButton botaoExcluir;
    private JTable tabelaHistorico;

    public HistoricoForm() throws SQLException {
        service = new HistoricoService();
        idosoService = new CadastroIdosoService();

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Cadastros de Históricos");
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

        labelIdIdoso = new JLabel("ID Idoso:");
        constraints.gridx = 2;
        constraints.gridy = 0;
        painelEntrada.add(labelIdIdoso, constraints);

        comboIdIdoso = new JComboBox<>();
        carregarIdsIdosos();
        constraints.gridx = 3;
        constraints.gridy = 0;
        painelEntrada.add(comboIdIdoso, constraints);

        labelAlergias = new JLabel("Alergias:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelAlergias, constraints);

        campoAlergias = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoAlergias, constraints);

        labelCondicoes = new JLabel("Cond.Preexist:");
        constraints.gridx = 2;
        constraints.gridy = 1;
        painelEntrada.add(labelCondicoes, constraints);

        campoCondicoes = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 1;
        painelEntrada.add(campoCondicoes, constraints);

        labelObservacoes = new JLabel("Observações:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelObservacoes, constraints);

        campoObservacoes = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoObservacoes, constraints);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 0;
        constraints.gridy = 7;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> executarAcaoDoBotao());
        constraints.gridx = 1;
        constraints.gridy = 7;
        painelEntrada.add(botaoSalvar, constraints);

        botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(e -> excluirDados());
        constraints.gridx = 2;
        constraints.gridy = 7;
        painelEntrada.add(botaoExcluir, constraints);

        JPanel painelSaida = new JPanel(new BorderLayout());

        tabelaHistorico = new JTable();
        tabelaHistorico.setModel(carregarDadosHistorico());
        tabelaHistorico.getSelectionModel().addListSelectionListener(e -> selecionarHistorico(e));
        tabelaHistorico.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(tabelaHistorico);
        painelSaida.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private void carregarIdsIdosos() {
        List<Integer> ids = idosoService.listarIdsIdosos();
        for (Integer id : ids) {
            comboIdIdoso.addItem(id);
        }
    }

    private void limparCampos() {
        campoId.setText("");
        comboIdIdoso.setSelectedIndex(0);
        campoAlergias.setText("");
        campoCondicoes.setText("");
        campoObservacoes.setText("");
    }

    private void excluirDados() {
        service.deletarHistorico(construirHistorico());
        limparCampos();
        tabelaHistorico.setModel(carregarDadosHistorico());
    }

    private HistoricoMedico construirHistorico() {
        return campoId.getText().isEmpty()
                ? new HistoricoMedico((Integer) comboIdIdoso.getSelectedItem(), campoAlergias.getText(), campoCondicoes.getText(), campoObservacoes.getText())
                : new HistoricoMedico(
                parseInt(campoId.getText()),
                (Integer) comboIdIdoso.getSelectedItem(),
                campoAlergias.getText(),
                campoCondicoes.getText(),
                campoObservacoes.getText());
    }

    private DefaultTableModel carregarDadosHistorico() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("ID Idoso");
        model.addColumn("Alergias");
        model.addColumn("Condições Preexistentes");
        model.addColumn("Observações");

        service.listarHistorico().forEach(historicoMedico ->
                model.addRow(new Object[]{
                        historicoMedico.getId(),
                        historicoMedico.getId_idoso(),
                        historicoMedico.getAlergias(),
                        historicoMedico.getCondicoes(),
                        historicoMedico.getObservacoes()
                })
        );
        return model;
    }

    private void executarAcaoDoBotao() {
        try {
            String alergias = campoAlergias.getText();
            String condicoes = campoCondicoes.getText();
            String observacoes = campoObservacoes.getText();

            if (alergias.isEmpty() || condicoes.isEmpty() || observacoes.isEmpty()) {
                throw new IllegalArgumentException("Por favor, preencha todos os campos.");
            }

            service.salvarHistorico(construirHistorico());
            limparCampos();
            tabelaHistorico.setModel(carregarDadosHistorico());

            JOptionPane.showMessageDialog(HistoricoForm.this, "Cadastro realizado com sucesso!");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(HistoricoForm.this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void selecionarHistorico(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaHistorico.getSelectedRow();
            if (selectedRow != -1) {
                var id = (Integer) tabelaHistorico.getValueAt(selectedRow, 0);
                campoId.setText(id.toString());

                var idIdoso = (Integer) tabelaHistorico.getValueAt(selectedRow, 1);
                comboIdIdoso.setSelectedItem(idIdoso);

                var alergias = (String) tabelaHistorico.getValueAt(selectedRow, 2);
                campoAlergias.setText(alergias);

                var condicoes = (String) tabelaHistorico.getValueAt(selectedRow, 3);
                campoCondicoes.setText(condicoes);

                var observacoes = (String) tabelaHistorico.getValueAt(selectedRow, 4);
                campoObservacoes.setText(observacoes);
            }
        }
    }
}
