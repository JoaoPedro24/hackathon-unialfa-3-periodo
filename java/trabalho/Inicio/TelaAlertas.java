package trabalho.Inicio;

import com.formdev.flatlaf.FlatLightLaf;
import trabalho.dao.AlertaDao;
import trabalho.model.Alerta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class TelaAlertas extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public TelaAlertas() {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Alertas e Lembretes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tableModel = new DefaultTableModel(new Object[]{"Nome", "CPF", "Telefone", "Data", "Vacina"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        carregarDados();
        setLocationRelativeTo(null);
    }

    private void carregarDados() {

        try {
            AlertaDao dao = new AlertaDao();
            List<Alerta> alertas = dao.listarTodosAlertas();
            if (alertas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não há vacinas agendadas.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                LocalDate hoje = LocalDate.now();
                LocalDate proximoAno = hoje.plusYears(1);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                for (Alerta alerta : alertas) {
                    LocalDate dataAlerta = alerta.getData();

                    if (dataAlerta.isAfter(hoje.minusDays(1)) && dataAlerta.isBefore(proximoAno.plusDays(1))) {
                        tableModel.addRow(new Object[]{
                                alerta.getNomeIdoso(),
                                alerta.getCpf(),
                                alerta.getTelefone(),
                                dataAlerta.format(formatter),
                                alerta.getNomeVacina()
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
