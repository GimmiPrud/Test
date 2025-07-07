package entity;

import config.Exeption;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class EsercizioCorsoExeption extends Exception {

    public EsercizioCorsoExeption(){}
    public EsercizioCorsoExeption( String mex) {
        super(mex);
    }
}

