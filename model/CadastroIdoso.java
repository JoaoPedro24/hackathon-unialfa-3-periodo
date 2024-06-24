package trabalho.model;

import java.time.LocalDate;

public class CadastroIdoso {
    private Integer id;
    private Integer idResponsavel;
    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private String cep;
    private String rua;
    private String bairro;
    private Integer numeroCasa;
    private String complemento;
    private String uf;
    private String cidade;


    public CadastroIdoso(Integer id, Integer idResponsavel, String nome, String cpf, String telefone, LocalDate dataNascimento, String cep, String rua, String bairro, Integer numeroCasa, String complemento, String uf, String cidade) {
        this.id = id;
        this.idResponsavel = idResponsavel;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
        this.uf = uf;
        this.cidade = cidade;
    }

    public CadastroIdoso(Integer idResponsavel, String nome, String cpf, String telefone, LocalDate dataNascimento, String cep, String rua, String bairro, Integer numeroCasa, String complemento, String uf, String cidade) {
        this.idResponsavel = idResponsavel;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
        this.uf = uf;
        this.cidade = cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Idoso{" +
                "id=" + id +
                ", idResponsavel=" + idResponsavel +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numeroCasa='" + numeroCasa + '\'' +
                ", complemento='" + complemento + '\'' +
                ", uf='" + uf + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
