package trabalho.model;

public class HistoricoMedico {

    private Integer id;
    private Integer id_idoso;
    private String alergias;
    private String condicoes;
    private String observacoes;

    public HistoricoMedico(Integer id, Integer id_idoso, String alergias, String condicoes, String observacoes) {
        this.id = id;
        this.id_idoso = id_idoso;
        this.alergias = alergias;
        this.condicoes = condicoes;
        this.observacoes = observacoes;
    }

    public HistoricoMedico(Integer id_idoso, String alergias, String condicoes, String observacoes) {
        this.id_idoso = id_idoso;
        this.alergias = alergias;
        this.condicoes = condicoes;
        this.observacoes = observacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_idoso() {
        return id_idoso;
    }

    public void setId_idoso(Integer id_idoso) {
        this.id_idoso = id_idoso;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCondicoes() {
        return condicoes;
    }

    public void setCondicoes(String condicoes) {
        this.condicoes = condicoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "HistoricoMedico{" +
                "id=" + id +
                ", id_idoso=" + id_idoso +
                ", alergias='" + alergias + '\'' +
                ", condicoes='" + condicoes + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}
