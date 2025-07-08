package entity;

public class Persona {
    private String nome;
    private String cognome;
    private Integer eta;
    private String comune;

    public Persona(String nome, String cognome, Integer eta, String commune) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.comune = commune;
    }

    public Persona() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getCommune() {
        return comune;
    }

    public void setCommune(String comune) {
        this.comune = comune;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", commune='" + comune + '\'' +
                '}';
    }
}
