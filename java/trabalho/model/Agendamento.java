package trabalho.model;

public class Agendamento {
    private int id;
    private String data;
    private int idIdoso;
    private int idEnfermeiro;
    private int idVacina;
    private String observacao;

    public Agendamento() {
        this.id = id;
        this.data = data;
        this.idIdoso = idIdoso;
        this.idEnfermeiro = idEnfermeiro;
        this.idVacina = idVacina;
        this.observacao = observacao;
    }

    public Agendamento(String data, int idIdoso, int idEnfermeiro, int idVacina, String observacao) {
        this.data = data;
        this.idIdoso = idIdoso;
        this.idEnfermeiro = idEnfermeiro;
        this.idVacina = idVacina;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdIdoso() {
        return idIdoso;
    }

    public void setIdIdoso(int idIdoso) {
        this.idIdoso = idIdoso;
    }

    public int getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setIdEnfermeiro(int idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", idIdoso=" + idIdoso +
                ", idEnfermeiro=" + idEnfermeiro +
                ", idVacina=" + idVacina +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}

