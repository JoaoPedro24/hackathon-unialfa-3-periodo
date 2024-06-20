package trabalho.view;

import trabalho.model.CadastroVacina;
import trabalho.service.VacinaService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static java.lang.Integer.parseInt;

public class CadastroVacinasForm  extends JFrame{
    private VacinaService service;

    private JLabel labelId;
    private JTextField campoId;

    private JLabel labelNome;
    private JTextField campoNome;

    private JLabel labelPrazo;
    private JTextField campoPrazo;

    private JLabel labelIdadeMinima;
    private JTextField campoIdadeMinima;

    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JButton botaoExcluir;
    private JTable tabelaCadastro;

    public CadastroVacinasForm(){
        service = new VacinaService();

        setTitle("Cadastro De Vacinas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 550);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelId = new JLabel("ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painelEntrada.add(labelId, constraints);

        campoId = new JTextField(20);
        campoId.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painelEntrada.add(campoId, constraints);

        labelNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNome, constraints);

        campoNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNome, constraints);

        labelPrazo = new JLabel("Prazo:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelPrazo, constraints);

        campoPrazo = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoPrazo, constraints);

        labelIdadeMinima = new JLabel("Idade Minima");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelIdadeMinima, constraints);

        campoIdadeMinima = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoIdadeMinima, constraints);

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

        tabelaCadastro = new JTable();
        tabelaCadastro.setModel(carregarDadosVacinas());
        tabelaCadastro.getSelectionModel().addListSelectionListener(e -> selecionarVacinas(e));
        tabelaCadastro.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(tabelaCadastro);
        painelSaida.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private void limparCampos() {
        campoId.setText("");
        campoNome.setText("");
        campoPrazo.setText("");
        campoIdadeMinima.setText("");
    }

    private boolean soLetra(String string) {
        return string.matches("[a-zA-Z]+");
    }

    private void excluirDados() {
        service.deletar(construirCadastro());
        limparCampos();
        tabelaCadastro.setModel(carregarDadosVacinas());
    }

    private void executarAcaoDoBotao() {
        try {
            String nome = campoNome.getText();
            String prazoTexto = campoPrazo.getText();
            String idadeMinimaTexto = campoIdadeMinima.getText();

            if (nome.isEmpty() || prazoTexto.isEmpty() || idadeMinimaTexto.isEmpty()) {
                throw new IllegalArgumentException("Por favor, preencha todos os campos.");
            }
            if (!soLetra(nome)) {
                throw new IllegalArgumentException("Os campos devem conter apenas letras.");
            }

            Integer prazo = Integer.valueOf(prazoTexto);
            Integer idadeMinima = Integer.valueOf(idadeMinimaTexto);

            service.salvar(construirCadastro());
            limparCampos();
            tabelaCadastro.setModel(carregarDadosVacinas());

            JOptionPane.showMessageDialog(CadastroVacinasForm.this, "Cadastro realizado com sucesso!");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(CadastroVacinasForm.this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    private CadastroVacina construirCadastro() {
        return campoId.getText().isEmpty()
                ? new CadastroVacina(campoNome.getText(), parseInt(campoPrazo.getText()),parseInt(campoIdadeMinima.getText()))
                : new CadastroVacina(
                parseInt(campoId.getText()),
                campoNome.getText(),
                parseInt(campoPrazo.getText()),
                parseInt(campoIdadeMinima.getText()));
    }

    private DefaultTableModel carregarDadosVacinas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Prazo");
        model.addColumn("Idade Minima");

        service.listarVacinas().forEach(cadastroVacina ->
                model.addRow(new Object[]{
                                cadastroVacina.getId(),
                                cadastroVacina.getNome(),
                                cadastroVacina.getPrazo(),
                                cadastroVacina.getIdade_minima()
                        }
                )
        );
        return model;

    }


    private void selecionarVacinas(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaCadastro.getSelectedRow();
            if (selectedRow != -1) {

                var id = (Integer) tabelaCadastro.getValueAt(selectedRow, 0);
                campoId.setText(id.toString());

                var nome = (String) tabelaCadastro.getValueAt(selectedRow, 1);
                campoNome.setText(nome);

                var prazo = (Integer) tabelaCadastro.getValueAt(selectedRow, 2);
                campoPrazo.setText(id.toString());

                var idadeMinima = (Integer) tabelaCadastro.getValueAt(selectedRow, 3);
                campoIdadeMinima.setText(id.toString());

            }
        }
    }







}
