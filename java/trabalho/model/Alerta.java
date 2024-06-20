package trabalho.model;

import java.time.LocalDate;
import java.util.Date;

public class Alerta {
    private String nome;
    private String cpf;
    private String telefone;
    private Date data;
    private String vacina;

    public Alerta(String nome, String cpf, String telefone, Date data, String vacina) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.data = data;
        this.vacina = vacina;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public Date getData() {
        return data;
    }

    public String getVacina() {
        return vacina;
    }
}

