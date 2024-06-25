package trabalho.view;

import com.formdev.flatlaf.FlatLightLaf;
import trabalho.model.CadastroIdoso;
import trabalho.service.CadastroIdosoService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public class CadastroIdosoForm extends JFrame {
    private CadastroIdosoService service;

    private JLabel labelId;
    private JTextField campoId;

    private JLabel labelIdResponsavel;
    private JComboBox<Integer> comboIdResponsavel;

    private JLabel labelNome;
    private JTextField campoNome;

    private JLabel labelCpf;
    private JFormattedTextField campoCpf;

    private JLabel labelTelefone;
    private JFormattedTextField campoTelefone;

    private JLabel labelDataNasc;
    private JTextField campoDataNasc;

    private JLabel labelCep;
    private JTextField campoCep;

    private JLabel labelRua;
    private JTextField campoRua;

    private JLabel labelBairro;
    private JTextField campoBairro;

    private JLabel labelNumero;
    private JTextField campoNumero;

    private JLabel labelComplemento;
    private JTextField campoComplemento;

    private JLabel labelUf;
    private JTextField campoUf;

    private JLabel labelCidade;
    private JTextField campoCidade;

    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JButton botaoExcluir;
    private JTable tabelaCadastro;

    public CadastroIdosoForm() throws SQLException {
        service = new CadastroIdosoService();

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Cadastro De Idosos");
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

        labelIdResponsavel = new JLabel("ID Responsavel:");
        constraints.gridx = 2;
        constraints.gridy = 0;
        painelEntrada.add(labelIdResponsavel, constraints);

        comboIdResponsavel = new JComboBox<>();
        carregarIdsResponsaveis();
        constraints.gridx = 3;
        constraints.gridy = 0;
        painelEntrada.add(comboIdResponsavel, constraints);

        labelNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNome, constraints);

        campoNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNome, constraints);

        labelCpf = new JLabel("CPF:");
        constraints.gridx = 2;
        constraints.gridy = 1;
        painelEntrada.add(labelCpf, constraints);

        try {
            MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
            campoCpf = new JFormattedTextField(cpfFormatter);
            campoCpf.setColumns(20);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        constraints.gridx = 3;
        constraints.gridy = 1;
        painelEntrada.add(campoCpf, constraints);

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

        labelDataNasc = new JLabel("Data:");
        constraints.gridx = 2;
        constraints.gridy = 2;
        painelEntrada.add(labelDataNasc, constraints);

        campoDataNasc = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 2;
        painelEntrada.add(campoDataNasc, constraints);

        labelCep = new JLabel("Cep:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelCep, constraints);

        campoCep = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoCep, constraints);

        labelRua = new JLabel("Rua:");
        constraints.gridx = 2;
        constraints.gridy = 3;
        painelEntrada.add(labelRua, constraints);

        campoRua = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 3;
        painelEntrada.add(campoRua, constraints);

        labelBairro = new JLabel("Bairro:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelBairro, constraints);

        campoBairro = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoBairro, constraints);

        labelNumero = new JLabel("Numero:");
        constraints.gridx = 2;
        constraints.gridy = 4;
        painelEntrada.add(labelNumero, constraints);

        campoNumero = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 4;
        painelEntrada.add(campoNumero, constraints);

        labelComplemento = new JLabel("Complemento:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelComplemento, constraints);

        campoComplemento = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoComplemento, constraints);

        labelUf = new JLabel("UF:");
        constraints.gridx = 2;
        constraints.gridy = 5;
        painelEntrada.add(labelUf, constraints);

        campoUf = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 5;
        painelEntrada.add(campoUf, constraints);

        labelCidade = new JLabel("Cidade:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        painelEntrada.add(labelCidade, constraints);

        campoCidade = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 6;
        painelEntrada.add(campoCidade, constraints);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 0;
        constraints.gridy = 7;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> executarAcaoDoBotao());
        constraints.gridx = 2;
        constraints.gridy = 7;
        painelEntrada.add(botaoSalvar, constraints);

        botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(e -> excluirDados());
        constraints.gridx = 4;
        constraints.gridy = 7;
        painelEntrada.add(botaoExcluir, constraints);

        JPanel painelSaida = new JPanel(new BorderLayout());

        tabelaCadastro = new JTable();
        tabelaCadastro.setModel(carregarDadosIdosos());
        tabelaCadastro.getSelectionModel().addListSelectionListener(e -> selecionarIdosos(e));
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

    private boolean dataValida(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    private void carregarIdsResponsaveis() {
        List<Integer> ids = service.listarIdsResponsaveis();
        for (Integer id : ids) {
            comboIdResponsavel.addItem(id);
        }
    }

    private void limparCampos() {
        campoId.setText("");
        comboIdResponsavel.setSelectedIndex(0);
        campoNome.setText("");
        campoCpf.setText("");
        campoTelefone.setText("");
        campoDataNasc.setText("");
        campoCep.setText("");
        campoRua.setText("");
        campoBairro.setText("");
        campoNumero.setText("");
        campoComplemento.setText("");
        campoUf.setText("");
        campoCidade.setText("");
    }

    private void excluirDados() {
        service.deletarIdoso(construirIdoso());
        limparCampos();
        tabelaCadastro.setModel(carregarDadosIdosos());
    }

    private CadastroIdoso construirIdoso() {
        int idResponsavel = (int) comboIdResponsavel.getSelectedItem();
        if (campoId.getText().isEmpty()) {
            return new CadastroIdoso(
                    idResponsavel,
                    campoNome.getText(),
                    campoCpf.getText(),
                    campoTelefone.getText(),
                    LocalDate.parse(campoDataNasc.getText()),
                    campoCep.getText(),
                    campoRua.getText(),
                    campoBairro.getText(),
                    Integer.parseInt(campoNumero.getText()),
                    campoComplemento.getText(),
                    campoUf.getText(),
                    campoCidade.getText()
            );
        } else {
            return new CadastroIdoso(
                    Integer.parseInt(campoId.getText()),
                    idResponsavel,
                    campoNome.getText(),
                    campoCpf.getText(),
                    campoTelefone.getText(),
                    LocalDate.parse(campoDataNasc.getText()),
                    campoCep.getText(),
                    campoRua.getText(),
                    campoBairro.getText(),
                    Integer.parseInt(campoNumero.getText()),
                    campoComplemento.getText(),
                    campoUf.getText(),
                    campoCidade.getText()
            );
        }
    }

    private DefaultTableModel carregarDadosIdosos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("ID Responsavel");
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Telefone");
        model.addColumn("Data");
        model.addColumn("Cep");
        model.addColumn("Rua");
        model.addColumn("Bairro");
        model.addColumn("Numero");
        model.addColumn("Complemento");
        model.addColumn("UF");
        model.addColumn("Cidade");

        List<CadastroIdoso> idosos = service.listarIdoso();
        idosos.forEach(cadastroIdoso -> {
            model.addRow(new Object[]{
                    cadastroIdoso.getId(),
                    cadastroIdoso.getIdResponsavel(),
                    cadastroIdoso.getNome(),
                    cadastroIdoso.getCpf(),
                    cadastroIdoso.getTelefone(),
                    cadastroIdoso.getDataNascimento(),
                    cadastroIdoso.getCep(),
                    cadastroIdoso.getRua(),
                    cadastroIdoso.getBairro(),
                    cadastroIdoso.getNumeroCasa(),
                    cadastroIdoso.getComplemento(),
                    cadastroIdoso.getUf(),
                    cadastroIdoso.getCidade(),
            });
        });

        return model;
    }

    private void selecionarIdosos(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaCadastro.getSelectedRow();
            if (selectedRow != -1) {
                campoId.setText(tabelaCadastro.getValueAt(selectedRow, 0).toString());
                comboIdResponsavel.setSelectedItem(tabelaCadastro.getValueAt(selectedRow, 1));
                campoNome.setText((String) tabelaCadastro.getValueAt(selectedRow, 2));
                campoCpf.setText((String) tabelaCadastro.getValueAt(selectedRow, 3));
                campoTelefone.setText((String) tabelaCadastro.getValueAt(selectedRow, 4));
                campoDataNasc.setText(tabelaCadastro.getValueAt(selectedRow, 5).toString());
                campoCep.setText((String) tabelaCadastro.getValueAt(selectedRow, 6));
                campoRua.setText((String) tabelaCadastro.getValueAt(selectedRow, 7));
                campoBairro.setText((String) tabelaCadastro.getValueAt(selectedRow, 8));
                campoNumero.setText(tabelaCadastro.getValueAt(selectedRow, 9).toString());
                campoComplemento.setText((String) tabelaCadastro.getValueAt(selectedRow, 10));
                campoUf.setText((String) tabelaCadastro.getValueAt(selectedRow, 11));
                campoCidade.setText((String) tabelaCadastro.getValueAt(selectedRow, 12));
            }
        }
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

    private void executarAcaoDoBotao() {
        try {
            String nome = campoNome.getText();
            String cpf = campoCpf.getText();
            String telefone = campoTelefone.getText();
            String data = campoDataNasc.getText();
            String cep = campoCep.getText();
            String rua = campoRua.getText();
            String bairro = campoBairro.getText();
            String numero = campoNumero.getText();
            String complemento = campoComplemento.getText();
            String uf = campoUf.getText();
            String cidade = campoCidade.getText();


            if (nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || data.isEmpty() || cep.isEmpty()
                    || rua.isEmpty() || bairro.isEmpty() || numero.isEmpty() || complemento.isEmpty() || uf.isEmpty() || cidade.isEmpty()) {
                throw new IllegalArgumentException("Por favor, preencha todos os campos.");
            }
            if (nome.isBlank() || cpf.isBlank() || telefone.isBlank() || data.isBlank() || cep.isBlank() || rua.isBlank() || bairro.isBlank()
                    || numero.isBlank() || complemento.isBlank() || uf.isBlank() || cidade.isBlank()) {
                throw new IllegalArgumentException("Apenas Espaços não são permitidos.");
            }
            if (!soLetra(nome) || !soLetra(bairro) || !soLetra(complemento) || !soLetra(uf) || !soLetra(cidade)) {
                throw new IllegalArgumentException("Os campos devem conter apenas letras.");
            }
            if (!dataValida(data)) {
                throw new IllegalArgumentException("O formato da data deve ser AAAA-MM-DD.");
            }

            validarCPF();
            validarTelefone();

            service.salvarIdoso(construirIdoso());
            limparCampos();
            tabelaCadastro.setModel(carregarDadosIdosos());

            JOptionPane.showMessageDialog(CadastroIdosoForm.this, "Cadastro realizado com sucesso!");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(CadastroIdosoForm.this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


}

