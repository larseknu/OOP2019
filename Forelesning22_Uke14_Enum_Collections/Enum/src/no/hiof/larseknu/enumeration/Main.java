package no.hiof.larseknu.enumeration;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Lager en ny arrayliste for å holde på en kortstokk
        ArrayList<Kort> kortstokk = new ArrayList<>();

        // Går gjennom alle enum'ene våre at typen Korttype
        for (Kort.Korttype korttype : Kort.Korttype.values()) {
            // Går gjennom alle enum'ene våre at typen Kortverdi
            for (Kortverdi kortverdi : Kortverdi.values()) {
                // Lager ett nytt kort og legger det i kortstokken
                kortstokk.add(new Kort(korttype, kortverdi));
            }
        }

        System.out.println("Kortstokk med " + kortstokk.size() + " kort:");
        // Skriver ut alle kortene i kortstokken
        for (Kort etKort : kortstokk) {
            System.out.println(etKort);
        }

        // Trekker et tilfeldig kort fra kortstokken
        Kort valgtKort = kortstokk.get((int) (Math.random() * kortstokk.size()));


        System.out.println("\nDu trakk: " + valgtKort);

        // Skriver ut en setning basert på typen kort vi trakk
        switch (valgtKort.getKorttype()) {
            case SPAR:
                System.out.println("Spar er den beste korttypen");
                break;
            case KLØVER:
                System.out.println("Flaks, det ble kløver");
                break;
            case RUTER:
                System.out.println("Ruter er den kjipeste korttypen");
                break;
            case HJERTER:
                System.out.println("Hjerter gir ekte kjærlighet");
                break;
        }
    }
}
