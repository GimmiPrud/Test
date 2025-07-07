package entity;

import config.Exeption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class EsercizioCorsoExeption extends Exception {
    private String codice;

    public EsercizioCorsoExeption(String codice) {
        this.codice = codice;
    }

    public EsercizioCorsoExeption(String message, String codice) {
        super(message);
        this.codice = codice;
    }

//    public String getCodice(Path p) throws IOException {
//        try(BufferedReader r = new BufferedReader(new FileReader(p.toFile()))){
//            String err = "";
//            switch (Exeption.valueOf(err)
//        }
//
//
//    }
}
