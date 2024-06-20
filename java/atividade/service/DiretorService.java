package atividade.service;

import atividade.dao.DiretorDao;
import atividade.model.Diretor;
import java.util.Collections;
import java.util.List;

public class DiretorService {

        public void salvar(Diretor diretor) {
            try {
                var dao = new DiretorDao();
                if (diretor.getId() == null) {
                    dao.inserir(diretor);
                }else {
                    dao.atualizar(diretor);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        public void deletar(Diretor diretor) {
            try {
                var dao = new DiretorDao();
                dao.deletar(diretor.getId());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        public List<Diretor> listarDiretores() {
            try {
                var dao = new DiretorDao();
                return dao.listarTodos();
            }catch (Exception e){
                System.out.println(e.getMessage());
                return Collections.emptyList();
            }
        }
    }

