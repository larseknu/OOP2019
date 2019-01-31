package no.hiof.larseknu.figurarv;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Oppretter og instansierer et rektangelobjekt
        Rektangel rektangelet = new Rektangel(4, 5);

        // Oppretter og instansierer et sirkelobjekt
        Sirkel sirkelen = new Sirkel(3);


        // Skriver ut en linje med * for å skille på utskriftene i terminalen
        System.out.println("\n*************Hvilken er størst?************");
        // Bruker statisk metode fra klassen Figur, siden den er statisk trenger vi ikke en instans av klassen først
        if (Figur.erStorre(rektangelet, sirkelen)) {
            System.out.println(rektangelet + " er større enn " + sirkelen);
        }
        else {
            System.out.println(sirkelen + " er større enn " + rektangelet);
        }

        // Oppretter og instansierer ett figurobjekt
        Figur figurObjekt = new Figur();

        // Bruker den ikke-statiske metoden for å sammenligne to figurer, vi må da ha en instans av figurklassen for å gjøre dette
        if (figurObjekt.erStorreMetodeSomIkkeErStatisk(rektangelet, sirkelen)) {
            System.out.println(rektangelet + " er større enn " + sirkelen);
        }
        else {
            System.out.println(sirkelen + " er større enn " + rektangelet);
        }
    }
}
