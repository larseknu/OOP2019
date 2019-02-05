package no.hiof.larseknu.figurarv;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Oppretter og instansierer et rektangelobjekt
        Rektangel rektangelet = new Rektangel(4, 5);

        // Oppretter og instansierer et sirkelobjekt
        Sirkel sirkelen = new Sirkel(3);

        System.out.println(sirkelen.areal() + " " + sirkelen.omkrets());


        // Skriver ut en linje med * for å skille på utskriftene i terminalen
        System.out.println("\n*************Hvilken er størst?************");
        if ( erStorre(rektangelet, sirkelen) ) {
            System.out.println(rektangelet + " er større enn " + sirkelen);
        }
        else {
            System.out.println(sirkelen + " er er større enn " + rektangelet);
        }


    }

    /**
     * Metode for å sammenligne størrelsen til to figurer
     * Kan sammenligne forskjellige figurer som arver fra Figur-klassen på grunn av polymorfi
     */
    public static boolean erStorre(Figur figur1, Figur figur2) {
        return figur1.areal() > figur2.areal();
    }
}
