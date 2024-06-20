package trabalho.Inicio;

import trabalho.dao.CadastroEnfermeiroDao;
import trabalho.model.Alerta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class TelaAlertas extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public TelaAlertas() {
        setTitle("Alertas e Lembretes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel(new Object[]{"Nome", "CPF", "Telefone", "Data", "Vacina"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        carregarDados();
    }

    private void carregarDados() {
        try {
            CadastroEnfermeiroDao dao = new CadastroEnfermeiroDao();
            List<Alerta> alertas = dao.listarTodosAlertas();
            if (alertas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não há vacinas agendadas.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Calendar cal = Calendar.getInstance();
                int anoAtual = cal.get(Calendar.YEAR);
                int proximoAno = anoAtual + 1;

                SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");

                for (Alerta alerta : alertas) {
                    Calendar dataAlerta = Calendar.getInstance();
                    dataAlerta.setTime(alerta.getData());
                    int anoAlerta = dataAlerta.get(Calendar.YEAR);

                    if (anoAlerta == anoAtual || anoAlerta == proximoAno) {
                        tableModel.addRow(new Object[]{
                                alerta.getNome(),
                                alerta.getCpf(),
                                alerta.getTelefone(),
                                formataData.format(alerta.getData()),
                                alerta.getVacina()
                        });
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar alertas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
