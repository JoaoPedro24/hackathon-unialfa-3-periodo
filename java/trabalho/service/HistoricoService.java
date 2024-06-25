package trabalho.service;

import trabalho.dao.CadastroIdosoDao;
import trabalho.dao.HistoricoMedicoDao;
import trabalho.model.CadastroIdoso;
import trabalho.model.HistoricoMedico;

import java.util.Collections;
import java.util.List;

public class HistoricoService {

    public void salvarHistorico(HistoricoMedico historicoMedico) {
        try {
            var dao = new HistoricoMedicoDao();
            if (historicoMedico.getId() == null) {
                dao.inserirHistorico(historicoMedico);
            } else {
                dao.atualizarHistoricos(historicoMedico);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletarHistorico(HistoricoMedico historicoMedico) {
        try {
            var dao = new HistoricoMedicoDao();
            dao.deletarHistorico(historicoMedico.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<HistoricoMedico> listarHistorico() {
        try {
            var dao = new HistoricoMedicoDao();
            return dao.listarHistoricos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

}
