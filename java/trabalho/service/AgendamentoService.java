package trabalho.service;

import trabalho.dao.AgendamentoDao;
import trabalho.model.Agendamento;

import java.sql.SQLException;
import java.util.List;

public class AgendamentoService {

    public AgendamentoDao agendamentoDAO;

    public AgendamentoService() throws SQLException {
        this.agendamentoDAO = new AgendamentoDao();
    }

    public void agendarVisita(Agendamento agendamento) {
        agendamentoDAO.agendarVisita(agendamento);
    }

    public List<String> getNomes(String tabela) {
        return agendamentoDAO.getNomes(tabela);
    }

    public int getId(String tabela, String nome) {
        return agendamentoDAO.getId(tabela, nome);
    }
}
