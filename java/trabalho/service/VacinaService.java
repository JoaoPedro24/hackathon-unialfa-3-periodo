package trabalho.service;

import trabalho.dao.CadastroVacinaDao;
import trabalho.model.CadastroVacina;

import java.util.Collections;
import java.util.List;

public class VacinaService {

    public void salvar(CadastroVacina cadastroVacina) {
        try {
            var dao = new CadastroVacinaDao();
            if (cadastroVacina.getId() == null) {
                dao.inserirVacinas(cadastroVacina);
            } else {
                dao.atualizarVacinas(cadastroVacina);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletar(CadastroVacina cadastroVacina) {
        try {
            var dao = new CadastroVacinaDao();
            dao.deletarVacinas(cadastroVacina.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<CadastroVacina> listarVacinas() {
        try {
            var dao = new CadastroVacinaDao();
            return dao.listarTodasVacinas();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }


}
