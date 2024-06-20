package trabalho.service;

import trabalho.dao.CadastroEnfermeiroDao;
import trabalho.model.CadastroEnfermeiro;

import java.util.Collections;
import java.util.List;

public class CadastroService {

    public void salvar(CadastroEnfermeiro cadastroEnfermeiro) {
        try {
            var dao = new CadastroEnfermeiroDao();
            if (cadastroEnfermeiro.getId() == null) {
                dao.inserir(cadastroEnfermeiro);
            }else {
                dao.atualizar(cadastroEnfermeiro);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deletar(CadastroEnfermeiro cadastroEnfermeiro) {
        try {
            var dao = new CadastroEnfermeiroDao();
            dao.deletar(cadastroEnfermeiro.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<CadastroEnfermeiro> listarCadastro() {
        try {
            var dao = new CadastroEnfermeiroDao();
            return dao.listarTodos();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }




}
