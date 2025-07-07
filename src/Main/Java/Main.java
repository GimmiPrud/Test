package Main.Java;

import service.Service;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

//        String s = "Giammarco, Cognome1, 18, Roma; Alessandro, Cognome2, 19, Bari; Marim, Cognome3, 30, Roma; Davide, Cognome4, 23, Torino";

//        String sAgg = "cognome:Ocrammaig, nome:Giammarco, eta:18, comune:Roma; nome:Alessandro, eta:19, cognome:Ordnassela, comune:Bari; nome:Marim, cognome:Miram, comune:Roma, eta:30; nome:Davide, cognome:Edivad, eta:23, comune:Torino";

//        ArrayList<Persona> p = new ArrayList<>();
//        p.add(new Persona("Giammarco","Cognome1",18,"Roma"));
//        p.add(new Persona("Alessandro","Cognome2",19,"Bari"));
//        p.add(new Persona("Marim","Cognome3",30,"Roma"));
//        p.add(new Persona("Davide","Cognome4",23,"Torino"));

//        Service I = new Service();
//
//        System.out.println(I.creaLista(sAgg));
//        System.out.println(I.mediaEta(p));
//        System.out.println(I.ordinaPerNome(p));
//        System.out.println(I.comune(p));
//        System.out.println(I.com(p,"Roma"));
//        System.out.println(I.listaStringa(p,s));

//-------------------------------------------------------\\
        String sAgg = "cognome:Ocrammaig, nome:Giammarco, eta:18, comune:Roma; nome:Alessandro, eta:19, cognome:Ordnassela, comune:Bari; nome:Marim, cognome:Miram, comune:Roma, eta:30; nome:Davide, cognome:Edivad, eta:23, comune:Torino";
        Service I = new Service();

        File f = new File("src/config/file.properties");
        System.out.println(I.ReadFileRepString(sAgg,f));





    }
}