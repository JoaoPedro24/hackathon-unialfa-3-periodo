package trabalho.service;

import trabalho.dao.CadastroIdosoDao;
import trabalho.model.CadastroIdoso;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CadastroIdosoService {
    private CadastroIdosoDao dao;

    public CadastroIdosoService() throws SQLException {
        this.dao = new CadastroIdosoDao();
    }

    public void salvarIdoso(CadastroIdoso cadastroIdoso) {
        try {
            if (cadastroIdoso.getId() == null) {
                dao.inserirIdoso(cadastroIdoso);
            } else {
                dao.atualizarIdoso(cadastroIdoso);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }


    public void deletarIdoso(CadastroIdoso cadastroIdoso) {
        try {
            dao.deletarIdoso(cadastroIdoso.getId());
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public List<CadastroIdoso> listarIdoso() {
        try {
            return dao.listarTodosIdosos();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Integer> listarIdsIdosos() {
        try {
            return dao.listarIdsIdosos();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Integer> listarIdsResponsaveis() {
        try {
            return dao.listarIdsResponsaveis();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
