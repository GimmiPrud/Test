package entity;

public class CustomExeption extends Exception {
    private String codice;

    public CustomExeption(String codice) {
        this.codice = codice;
    }

    public CustomExeption(String message, String codice) {
        super(message);
        this.codice = codice;
    }

//    public String getCodice(){
//
//    }
}
