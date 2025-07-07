package service;

import entity.Persona;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public interface IService {

    public ArrayList<Persona> creaLista(String s);
    public Double mediaEta(ArrayList<Persona> p);
    public ArrayList<Persona> ordinaPerNome(ArrayList<Persona> p);
    public TreeMap<String, Integer> comune(ArrayList<Persona> p);
    public ArrayList<Persona> com(ArrayList<Persona> p, String s);
    public ArrayList<Persona> listaStringa(ArrayList<Persona> p, String s);
    public String ReadFileRepString(String s , File p) throws IOException;
}

