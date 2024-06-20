package atividade.view;
import atividade.model.Diretor;
import atividade.service.DiretorService;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import static java.lang.Integer.parseInt;

public class DiretorForm extends JFrame {

    private DiretorService service;

    private JLabel labelId;
    private JTextField campoId;

    private JLabel labelNome;
    private JTextField campoNome;

    private JLabel labelNacionalidade;
    private JTextField campoNacionalidade;

    private JLabel labelDataNascimento;
    private JTextField campoDataNascimento;

    private JLabel labelPremiacao;
    private JTextField campoPremiacao;

    private JLabel labelDataInicioCarreira;
    private JTextField campoDataInicioCarreira;

    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JButton botaoExcluir;
    private JTable tabelaDiretor;



    public DiretorForm(){
        service = new DiretorService();

        setTitle("Diretores");
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

        labelNacionalidade = new JLabel("Nacionalidade:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelNacionalidade, constraints);

        campoNacionalidade = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoNacionalidade, constraints);

        labelDataNascimento = new JLabel("Data de Nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelDataNascimento, constraints);

        campoDataNascimento = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoDataNascimento,constraints);

        labelPremiacao = new JLabel("Premiação:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelPremiacao,constraints);

        campoPremiacao = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoPremiacao,constraints);

        labelDataInicioCarreira = new JLabel("Data trabalho.Inicio Carreira:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelDataInicioCarreira,constraints);

        campoDataInicioCarreira = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoDataInicioCarreira, constraints);

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
        botaoExcluir.addActionListener(e ->excluirDados() );
        constraints.gridx = 2;
        constraints.gridy = 7;
        painelEntrada.add(botaoExcluir, constraints);

        JPanel painelSaida = new JPanel(new BorderLayout());

        tabelaDiretor = new JTable();
        tabelaDiretor.setModel(carregarDadosLocadoras());
        tabelaDiretor.getSelectionModel().addListSelectionListener(e -> selecionarDiretor(e));
        tabelaDiretor.setDefaultEditor(Object.class, null);


        JScrollPane scrollPane = new JScrollPane(tabelaDiretor);
        painelSaida.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private boolean soLetra(String string) {
        return string.matches("[a-zA-Z]+");
    }

    private boolean dataValida(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    private void limparCampos() {
        campoId.setText("");
        campoNome.setText("");
        campoNacionalidade.setText("");
        campoDataNascimento.setText("");
        campoPremiacao.setText("");
        campoDataInicioCarreira.setText("");
    }

    private DefaultTableModel carregarDadosLocadoras() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Nacionalidade");
        model.addColumn("Data de Nascimento");
        model.addColumn("Premiação");
        model.addColumn("Data trabalho.Inicio Carreira");


        service.listarDiretores().forEach(diretor ->
                model.addRow(new Object[]{
                        diretor.getId(),
                        diretor.getNome(),
                        diretor.getNacionalidade(),
                        diretor.getDataNascimento(),
                        diretor.getPremiacao(),
                        diretor.getDataInicioCarreira()
                        }
                )
        );
        return  model;
    }

    private void excluirDados(){
        service.deletar(construirDiretor());
        limparCampos();
        tabelaDiretor.setModel(carregarDadosLocadoras());
    }

    private void executarAcaoDoBotao() {
        try {
            String nome = campoNome.getText();
            String nacionalidade = campoNacionalidade.getText();
            String data_nasc = campoDataNascimento.getText();
            String premiacao = campoPremiacao.getText();
            String data_carreira = campoDataInicioCarreira.getText();

            if (nome.isEmpty() || nacionalidade.isEmpty() || premiacao.isEmpty() || data_nasc.isEmpty() || data_carreira.isEmpty()) {
                throw new IllegalArgumentException("Por favor, preencha todos os campos.");
            }

            if (!soLetra(nome) || !soLetra(premiacao)||!soLetra(premiacao)) {
                throw new IllegalArgumentException("Os campos devem conter apenas letras.");
            }
            if (!dataValida(data_carreira)||!dataValida(data_nasc)) {
                throw new IllegalArgumentException("O formato da data deve ser AAAA-MM-DD.");
            }

            service.salvar(construirDiretor());
            limparCampos();
            tabelaDiretor.setModel(carregarDadosLocadoras());

            JOptionPane.showMessageDialog(DiretorForm.this, "Cadastro realizado com sucesso!");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(DiretorForm.this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Diretor construirDiretor(){
        return campoId.getText().isEmpty()
                ? new Diretor( campoNome.getText(), campoNacionalidade.getText(), LocalDate.parse(campoDataNascimento.getText()), campoPremiacao.getText(),  LocalDate.parse(campoDataInicioCarreira.getText()))
                : new Diretor(
                parseInt(campoId.getText()),
                campoNome.getText(),
                campoNacionalidade.getText(),
                LocalDate.parse(campoDataNascimento.getText()) ,
                campoPremiacao.getText(),
                LocalDate.parse(campoDataInicioCarreira.getText()));
    }

    private void selecionarDiretor(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaDiretor.getSelectedRow();
            if (selectedRow != -1) {

                var id = (Integer) tabelaDiretor.getValueAt(selectedRow, 0);
                campoId.setText(id.toString());

                var nome = (String) tabelaDiretor.getValueAt(selectedRow, 1);
                campoNome.setText(nome);

                var diretor = (String) tabelaDiretor.getValueAt(selectedRow, 2);
                campoNacionalidade.setText(diretor);

                var dataNasc = (LocalDate) tabelaDiretor.getValueAt(selectedRow, 3);
                campoDataNascimento.setText(String.valueOf(dataNasc));

                var premiacao = (String) tabelaDiretor.getValueAt(selectedRow, 4);
                campoPremiacao.setText(premiacao);

                var dataInicioCarreira = (LocalDate) tabelaDiretor.getValueAt(selectedRow, 5);
                campoDataInicioCarreira.setText(String.valueOf(dataInicioCarreira));
            }
        }
    }



}
