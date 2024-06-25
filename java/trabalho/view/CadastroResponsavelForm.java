package trabalho.view;

import com.formdev.flatlaf.FlatLightLaf;
import trabalho.model.CadastroResponsavel;
import trabalho.service.ResponsavelService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class CadastroResponsavelForm extends JFrame {
    private ResponsavelService service;

    private JLabel labelId;
    private JTextField campoId;


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

    public CadastroResponsavelForm() {
        service = new ResponsavelService();

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Cadastro De Responsaveis");
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

        labelNome = new JLabel("Nome:");
        constraints.gridx = 2;
        constraints.gridy = 0;
        painelEntrada.add(labelNome, constraints);

        campoNome = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 0;
        painelEntrada.add(campoNome, constraints);

        labelCpf = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelCpf, constraints);

        try {
            MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
            campoCpf = new JFormattedTextField(cpfFormatter);
            campoCpf.setColumns(20);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoCpf, constraints);

        labelTelefone = new JLabel("Telefone:");
        constraints.gridx = 2;
        constraints.gridy = 1;
        painelEntrada.add(labelTelefone, constraints);

        try {
            MaskFormatter telefoneFormatter = new MaskFormatter("(##) #####-####");
            campoTelefone = new JFormattedTextField(telefoneFormatter);
            campoTelefone.setColumns(20);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        constraints.gridx = 3;
        constraints.gridy = 1;
        painelEntrada.add(campoTelefone, constraints);

        labelDataNasc = new JLabel("Data:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelDataNasc, constraints);

        campoDataNasc = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoDataNasc, constraints);

        labelCep = new JLabel("Cep:");
        constraints.gridx = 2;
        constraints.gridy = 2;
        painelEntrada.add(labelCep, constraints);

        campoCep = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 2;
        painelEntrada.add(campoCep, constraints);

        labelRua = new JLabel("Rua:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelRua, constraints);

        campoRua = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoRua, constraints);

        labelBairro = new JLabel("Bairro:");
        constraints.gridx = 2;
        constraints.gridy = 3;
        painelEntrada.add(labelBairro, constraints);

        campoBairro = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 3;
        painelEntrada.add(campoBairro, constraints);

        labelNumero = new JLabel("Numero:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelNumero, constraints);

        campoNumero = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoNumero, constraints);

        labelComplemento = new JLabel("Complemento:");
        constraints.gridx = 2;
        constraints.gridy = 4;
        painelEntrada.add(labelComplemento, constraints);

        campoComplemento = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 4;
        painelEntrada.add(campoComplemento, constraints);

        labelUf = new JLabel("UF:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelUf, constraints);

        campoUf = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoUf, constraints);

        labelCidade = new JLabel("Cidade:");
        constraints.gridx = 2;
        constraints.gridy = 5;
        painelEntrada.add(labelCidade, constraints);

        campoCidade = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 5;
        painelEntrada.add(campoCidade, constraints);


        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 0;
        constraints.gridy = 6;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> executarAcaoDoBotao());
        constraints.gridx = 2;
        constraints.gridy = 6;
        painelEntrada.add(botaoSalvar, constraints);

        botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(e -> excluirDados());
        constraints.gridx = 4;
        constraints.gridy = 6;
        painelEntrada.add(botaoExcluir, constraints);

        JPanel painelSaida = new JPanel(new BorderLayout());

        tabelaCadastro = new JTable();
        tabelaCadastro.setModel(carregarDadosResponsaveis());
        tabelaCadastro.getSelectionModel().addListSelectionListener(e -> selecionarResponsavel(e));
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

    private boolean soLetra(String string) {
        return string.matches("[\\p{L}\\s]+");
    }

    private boolean dataValida(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
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

    private void excluirDados() {
        service.deletarResponsavel(construirCadastro());
        limparCampos();
        tabelaCadastro.setModel(carregarDadosResponsaveis());
    }

    private CadastroResponsavel construirCadastro() {
        return campoId.getText().isEmpty()
                ? new CadastroResponsavel(campoNome.getText(), campoCpf.getText(), campoTelefone.getText(), LocalDate.parse(campoDataNasc.getText()), campoCep.getText(), campoRua.getText(), campoBairro.getText(), parseInt(campoNumero.getText()), campoComplemento.getText(), campoUf.getText(), campoCidade.getText())
                : new CadastroResponsavel(
                parseInt(campoId.getText()),
                campoNome.getText(),
                campoCpf.getText(),
                campoTelefone.getText(),
                LocalDate.parse(campoDataNasc.getText()),
                campoCep.getText(),
                campoRua.getText(),
                campoBairro.getText(),
                parseInt(campoNumero.getText()),
                campoComplemento.getText(),
                campoUf.getText(),
                campoCidade.getText());
    }

    private DefaultTableModel carregarDadosResponsaveis() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
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

        service.listarResponsaveis().forEach(cadastroResponsavel ->
                model.addRow(new Object[]{
                                cadastroResponsavel.getId(),
                                cadastroResponsavel.getNome(),
                                cadastroResponsavel.getCpf(),
                                cadastroResponsavel.getTelefone(),
                                cadastroResponsavel.getDataNascimento(),
                                cadastroResponsavel.getCep(),
                                cadastroResponsavel.getRua(),
                                cadastroResponsavel.getBairro(),
                                cadastroResponsavel.getNumeroCasa(),
                                cadastroResponsavel.getComplemento(),
                                cadastroResponsavel.getUf(),
                                cadastroResponsavel.getCidade(),

                        }
                )
        );
        return model;

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
            if (!soLetra(nome) || !soLetra(bairro) || !soLetra(complemento) || !soLetra(uf) || !soLetra(cidade)) {
                throw new IllegalArgumentException("Os campos devem conter apenas letras.");
            }
            if (!dataValida(data)) {
                throw new IllegalArgumentException("O formato da data deve ser AAAA-MM-DD.");
            }
            validarCPF();
            validarTelefone();


            service.salvarResponsavel(construirCadastro());
            limparCampos();
            tabelaCadastro.setModel(carregarDadosResponsaveis());

            JOptionPane.showMessageDialog(CadastroResponsavelForm.this, "Cadastro realizado com sucesso!");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(CadastroResponsavelForm.this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void selecionarResponsavel(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaCadastro.getSelectedRow();
            if (selectedRow != -1) {

                var id = (Integer) tabelaCadastro.getValueAt(selectedRow, 0);
                campoId.setText(id.toString());

                var nome = (String) tabelaCadastro.getValueAt(selectedRow, 1);
                campoNome.setText(nome);

                var cpf = (String) tabelaCadastro.getValueAt(selectedRow, 2);
                campoCpf.setText(cpf);

                var telefone = (String) tabelaCadastro.getValueAt(selectedRow, 3);
                campoTelefone.setText(telefone);

                var data = (LocalDate) tabelaCadastro.getValueAt(selectedRow, 4);
                campoDataNasc.setText(String.valueOf(data));

                var cep = (String) tabelaCadastro.getValueAt(selectedRow, 5);
                campoCep.setText(cep);

                var rua = (String) tabelaCadastro.getValueAt(selectedRow, 6);
                campoRua.setText(rua);

                var bairro = (String) tabelaCadastro.getValueAt(selectedRow, 7);
                campoBairro.setText(bairro);

                var numero = (Integer) tabelaCadastro.getValueAt(selectedRow, 8);
                campoNumero.setText(numero.toString());

                var complemento = (String) tabelaCadastro.getValueAt(selectedRow, 9);
                campoComplemento.setText(complemento);

                var uf = (String) tabelaCadastro.getValueAt(selectedRow, 10);
                campoUf.setText(uf);

                var cidade = (String) tabelaCadastro.getValueAt(selectedRow, 11);
                campoCidade.setText(cidade);


            }
        }
    }


}
