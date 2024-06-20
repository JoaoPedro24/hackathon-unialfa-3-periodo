package trabalho.model;

import java.time.LocalDate;

public class Idoso {
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private int idResponsavel;
    private String cep;
    private String rua;
    private String numeroCasa;
    private String cidade;
    private String bairro;
    private String uf;
    private String complemento;


    public Idoso(int id, String nome, String cpf, LocalDate dataNascimento, String telefone, int idResponsavel, String cep, String rua, String numeroCasa, String cidade, String bairro, String uf, String complemento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.idResponsavel = idResponsavel;
        this.cep = cep;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
        this.complemento = complemento;
    }

    public Idoso( String nome, String cpf, LocalDate dataNascimento, String telefone, int idResponsavel, String cep, String rua, String numeroCasa, String cidade, String bairro, String uf, String complemento) {

        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.idResponsavel = idResponsavel;
        this.cep = cep;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
        this.complemento = complemento;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Idoso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                ", idResponsavel=" + idResponsavel +
                ", cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", numeroCasa='" + numeroCasa + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", uf='" + uf + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
