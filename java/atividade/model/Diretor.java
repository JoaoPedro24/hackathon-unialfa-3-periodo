package atividade.model;

import java.time.LocalDate;


public class Diretor {
    private Integer id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;
    private String premiacao;
    private LocalDate dataInicioCarreira;


    public Diretor(Integer id, String nome, String nacionalidade, LocalDate dataNascimento, String premiacao, LocalDate dataInicioCarreira) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.premiacao = premiacao;
        this.dataInicioCarreira = dataInicioCarreira;
    }

    public Diretor( String nome, String nacionalidade, LocalDate dataNascimento, String premiacao, LocalDate dataInicioCarreira) {

        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.premiacao = premiacao;
        this.dataInicioCarreira = dataInicioCarreira;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPremiacao() {
        return premiacao;
    }

    public void setPremiacao(String premiacao) {
        this.premiacao = premiacao;
    }

    public LocalDate getDataInicioCarreira() {
        return dataInicioCarreira;
    }

    public void setDataInicioCarreira(LocalDate dataInicioCarreira) {
        this.dataInicioCarreira = dataInicioCarreira;
    }

    @Override
    public String toString() {
        return "Id: " + id
                + " Nome: " + nome
                + " Nacionalidade: " + nacionalidade
                + " Data de Nascimento: " + dataNascimento
                + " Premiações: " + premiacao
                + " Data Inicio da Carreira: " + dataInicioCarreira;
    }
}
