package service;
import config.ParamPersona;
import entity.Persona;

import java.io.*;
import java.util.*;

/**
 * @author Giammarco
 * @version 1.0
 * @since 3/07/2025
 */
public class Service implements IService {
/**
     * <h2> Creazione di una classe service che implementa alcuni metodi</h2>
     *     <p> Lista dei metodi utilizzati per la conversione e la gestione di stringhe e liste </p>
     *         <h2> metodo crealista()</h2>
     *         <p> Questo metodo converte una stringa in una lista di elementi che si riferiscono alla classe Persona </p>
     * @param s Stringa che verrà convertita
     * @return p Lista di oggetti che come parametri avranno le informazioni della stringa
     *     </li>
     * </ul>
     */
    @Override
    public ArrayList<Persona> creaLista(String s) {
        String[] lS = s.split(";");
        ArrayList<Persona> p = new ArrayList<>();
        for( String i:lS){
            String[] k = i.split(", ");
            String nome = " ";
            String cognome = " ";
            int eta = 0;
            String comune = " ";
            for(String n: k){
                String[] c = n.split(":");

                String Key = c[0].trim().toUpperCase();
                String val = c[1].trim().trim();

                switch (ParamPersona.valueOf(Key)){
                    case NOME:
                        nome = val;
                        break;
                    case COGNOME:
                        cognome = val;
                        break;
                    case ETA:
                        eta = Integer.parseInt(val);
                        break;
                    case COMUNE:
                        comune = val;
                        break;
                }
            }
                p.add(new Persona(nome, cognome, eta, comune));
            // old method:
//            String nome = k[0];
//            String cognome = k[1];
//            int eta = Integer.parseInt(k[2]);
//            String comune = k[3];
//            p.add(new Persona(nome, cognome, eta, comune));
        }
        return p;
    }

    /**
     *<h2> metodo mediaEta()</h2>
     * <p> questo metodo permette di fare una media delle eta delle Persone di una determinata lista </p>
     * @param p Lista di oggetti Persona che verrà utilizzata per fare la media delle età
     * @return media delle età delle persone della lista
     */

    @Override
    public Double mediaEta(ArrayList<Persona> p) {
        int m = 0;
        for( Persona i: p){
            m += i.getEta();
        }
        return (double) m/p.size();
    }

    /**
     * <h2> metodo ordinaPerNome() </h2>
     * <p> Questo metodo permette di ordinare una lista di persone in ordine alfabetico partendo dal nome</p>
     * @param p Lista di Persone
     * @return La lista di Persone p ordinat in ordine alfabetico
     */

    @Override
    public ArrayList<Persona> ordinaPerNome(ArrayList<Persona> p) {
        Collections.sort(p, Comparator.comparing(Persona::getNome));
        return p;
    }

    /**
     * <h2> Metodo comune()</h2>
     * <p> Crea un mappa dei comuni che avranno come chiave il nome dei comuni e come valore il numero di persone associate a quel comune</p>
     * @param p lista di persone
     * @return mappa dei comuni e del numero di persone associate
     */

    @Override
    public TreeMap<String, Integer> comune(ArrayList<Persona> p) {
        HashMap<String, Integer> c = new HashMap<>();
        for (Persona i: p){
            c.put(i.getCommune(), c.getOrDefault(i.getCommune(),0)+1);
        }
        TreeMap<String,Integer> ord = new TreeMap<>(c);
        return ord;
    }

    /**
     * <h2> metodo com()</h2>
     * <p> Prende come input un comune e restituisce una lista di persone appartenenti a quel comune </p>
     * @param s stringa con il comune
     * @param p Lista di persone
     * @return lista di persone appartenenti a quel comune
     */

    @Override
    public ArrayList<Persona> com(ArrayList<Persona> p, String s) {
        ArrayList<Persona> P = new ArrayList<>();
        String ss = s.toLowerCase().trim();
        try {
            for (Persona i : p) {
                if (i.getCommune() != null && i.getCommune().toLowerCase().trim().contains(ss)) {
                    p.add(i);
                    System.out.println("Comune trovato");
                    return P;
                } else {
                    System.out.println(" mi dispiace comune non trovato ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Errore nella ricerca", e);
        }
        return null;
    }

    /**
     * <h2> metodo listaStringa()</h2>
     *  <p> Prende in input una stringa e restituisce una lista di persone il cui nome contiene la stringa presa in input</p>
     * @param s stringa contenente i nomi da analizzare
     * @param p Lista di persone
     * @return lista di persone il cui nome è contenuto nella stringa
     */

    @Override
    public ArrayList<Persona> listaStringa(ArrayList<Persona> p, String s) {
        ArrayList<Persona> pers = new ArrayList<>();
        String ss = s.toLowerCase().trim();
        StringBuffer sb = new StringBuffer(ss);
        for(Persona i: p){
            if (i.getNome().toLowerCase().trim().contains(ss) || i.getNome().toLowerCase().trim().contains(sb.reverse())){
                pers.add(i);
            }
        }
        return pers;
    }

    public String ReadFileRepString(String s , File p) throws IOException {
        if(p.exists()) {
            try (BufferedReader b = new BufferedReader(new FileReader(p))) {
                String lS = b.readLine();
                s = lS;
                System.out.println("Stringa sostituita");
            } catch (Exception e) {
                System.out.println("Errore");
            }
        } else {
            System.out.println("Il file non esiste");
        }
        return s;
    }

    public String ReadProp(File f, String Key) throws IOException {
        if(f.exists()){
            try{
                Properties prop = new Properties();
                prop.load(new FileInputStream(f));
                System.out.println("Lettura avvenuta con successo");
                 return prop.getProperty(Key);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "Il file non esiste";
        }
    }

}
