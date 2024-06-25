package trabalho.service;

import trabalho.dao.CadastroResponsavelDao;
import trabalho.model.CadastroResponsavel;

import java.util.Collections;
import java.util.List;

public class ResponsavelService {

    public void salvarResponsavel(CadastroResponsavel cadastroResponsavel) {
        try {
            var dao = new CadastroResponsavelDao();
            if (cadastroResponsavel.getId() == null) {
                dao.inserirResponsavel(cadastroResponsavel);
            } else {
                dao.atualizarResponsavel(cadastroResponsavel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletarResponsavel(CadastroResponsavel cadastroResponsavel) {
        try {
            var dao = new CadastroResponsavelDao();
            dao.deletarResponsavel(cadastroResponsavel.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<CadastroResponsavel> listarResponsaveis() {
        try {
            var dao = new CadastroResponsavelDao();
            return dao.listarTodosResponsaveis();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }


}
