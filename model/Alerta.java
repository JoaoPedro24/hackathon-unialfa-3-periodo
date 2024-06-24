package trabalho.model;

import java.time.LocalDate;

public class Alerta {
    private String nomeIdoso;
    private String cpf;
    private String telefone;
    private LocalDate data;
    private String nomeVacina;

    public Alerta(String nomeIdoso, String cpf, String telefone, LocalDate data, String nomeVacina) {
        this.nomeIdoso = nomeIdoso;
        this.cpf = cpf;
        this.telefone = telefone;
        this.data = data;
        this.nomeVacina = nomeVacina;
    }

    public String getNomeIdoso() {
        return nomeIdoso;
    }

    public void setNomeIdoso(String nomeIdoso) {
        this.nomeIdoso = nomeIdoso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }
}
