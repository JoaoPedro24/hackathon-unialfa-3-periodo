package trabalho.model;

public class CadastroVacina {

    private Integer id;
    private String nome;
    private Integer prazo;
    private Integer idade_minima;

    public CadastroVacina(Integer id, String nome, Integer prazo, Integer idade_minima) {
        this.id = id;
        this.nome = nome;
        this.prazo = prazo;
        this.idade_minima = idade_minima;
    }

    public CadastroVacina(String nome, Integer prazo, Integer idade_minima) {

        this.nome = nome;
        this.prazo = prazo;
        this.idade_minima = idade_minima;
    }

    public Integer getId() {
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

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public Integer getIdade_minima() {
        return idade_minima;
    }

    public void setIdade_minima(int idade_minima) {
        this.idade_minima = idade_minima;
    }

    @Override
    public String toString() {
        return "Vacina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prazo=" + prazo +
                ", idade_minima=" + idade_minima +
                '}';
    }
}
