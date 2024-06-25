package trabalho.view;

import com.formdev.flatlaf.FlatLightLaf;
import trabalho.model.CadastroEnfermeiro;
import trabalho.service.CadastroEnfermeiroService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class CadastroEnfermeiroForm extends JFrame {

    public CadastroEnfermeiroService service;

    private JLabel labelId;
    public JTextField campoId;

    private JLabel labelNome;
    public JTextField campoNome;

    private JLabel labelTelefone;
    public JFormattedTextField campoTelefone;

    private JLabel labelCpf;
    public JFormattedTextField campoCpf;

    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JButton botaoExcluir;
    private JTable tabelaCadastro;

    public CadastroEnfermeiroForm() throws ParseException {
        service = new CadastroEnfermeiroService();

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Cadastrar Enfermeiros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        labelTelefone = new JLabel("Telefone:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelTelefone, constraints);

        try {
            MaskFormatter telefoneFormatter = new MaskFormatter("(##) #####-####");
            campoTelefone = new JFormattedTextField(telefoneFormatter);
            campoTelefone.setColumns(20);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoTelefone, constraints);

        labelCpf = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelCpf, constraints);

        try {
            MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
            campoCpf = new JFormattedTextField(cpfFormatter);
            campoCpf.setColumns(20);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoCpf, constraints);

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
        tabelaCadastro.setModel(carregarDadosLocadoras());
        tabelaCadastro.getSelectionModel().addListSelectionListener(e -> selecionarCadastro(e));
        tabelaCadastro.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(tabelaCadastro);
        painelSaida.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private boolean soLetra(String string) {
        return string.matches("[\\p{L}\\s]+");
    }

    public void limparCampos() {
        campoId.setText("");
        campoNome.setText("");
        campoTelefone.setText("");
        campoCpf.setText("");
    }

    public void excluirDados() {
        service.deletar(construirCadastro());
        limparCampos();
        tabelaCadastro.setModel(carregarDadosLocadoras());
    }

    public void validarCPF() {
        String cpf = campoCpf.getText().replaceAll("\\D", "");
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("O CPF deve conter 11 dígitos numéricos.");
        }
    }

    public void validarTelefone() {
        String telefone = campoTelefone.getText().replaceAll("\\D", "");
        if (!telefone.matches("\\d{11}")) {
            throw new IllegalArgumentException("O telefone deve conter 11 dígitos numéricos.");
        }
    }

    public void executarAcaoDoBotao() {
        try {
            String nome = campoNome.getText();
            String telefone = campoTelefone.getText();
            String cpf = campoCpf.getText();

            if (nome.isEmpty() || telefone.isEmpty() || cpf.isEmpty()) {
                throw new IllegalArgumentException("Por favor, preencha todos os campos.");
            }
            if (nome.isBlank() || telefone.isBlank() || cpf.isBlank()) {
                throw new IllegalArgumentException("Espaços em Branco não são aceitaveis.");
            }
            if (!soLetra(nome)) {
                throw new IllegalArgumentException("Os campos devem conter apenas letras.");
            }
            validarCPF();
            validarTelefone();

            service.salvar(construirCadastro());
            limparCampos();
            tabelaCadastro.setModel(carregarDadosLocadoras());

            JOptionPane.showMessageDialog(CadastroEnfermeiroForm.this, "Cadastro realizado com sucesso!");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(CadastroEnfermeiroForm.this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private CadastroEnfermeiro construirCadastro() {
        return campoId.getText().isEmpty()
                ? new CadastroEnfermeiro(campoNome.getText(), campoTelefone.getText(), campoCpf.getText())
                : new CadastroEnfermeiro(
                Integer.parseInt(campoId.getText()),
                campoNome.getText(),
                campoTelefone.getText(),
                campoCpf.getText());
    }

    public DefaultTableModel carregarDadosLocadoras() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Telefone");
        model.addColumn("CPF");

        service.listarCadastro().forEach(cadastroEnfermeiro ->
                model.addRow(new Object[]{
                        cadastroEnfermeiro.getId(),
                        cadastroEnfermeiro.getNome(),
                        cadastroEnfermeiro.getTelefone(),
                        cadastroEnfermeiro.getCpf()
                })
        );
        return model;
    }

    private void selecionarCadastro(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaCadastro.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) tabelaCadastro.getValueAt(selectedRow, 0);
                campoId.setText(String.valueOf(id));

                String nome = (String) tabelaCadastro.getValueAt(selectedRow, 1);
                campoNome.setText(nome);

                String telefone = (String) tabelaCadastro.getValueAt(selectedRow, 2);
                campoTelefone.setText(telefone);

                String cpf = (String) tabelaCadastro.getValueAt(selectedRow, 3);
                campoCpf.setText(cpf); // Define o valor formatado
            }
        }
    }
}
