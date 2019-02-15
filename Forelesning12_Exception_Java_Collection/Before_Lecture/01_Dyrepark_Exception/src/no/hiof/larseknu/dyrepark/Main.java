package no.hiof.larseknu.dyrepark;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Dyrepark kristiansandDyrepark = new Dyrepark("Kristiansand Dyrepark");

        HonningGrevling honningGrevlingenNils = new HonningGrevling("Nils", LocalDate.of(2013, 3, 2));
        Sjimpanse sjimpansenArne = new Sjimpanse("Arne", LocalDate.of(2017, 3, 17), 60);
        Panda pandaenTrine = new Panda("Trine", LocalDate.of(2014, 4, 13), "Hvit");

        kristiansandDyrepark.leggTilEttDyrIDyreparken(sjimpansenArne);
        kristiansandDyrepark.leggTilEttDyrIDyreparken(pandaenTrine);
        kristiansandDyrepark.leggTilEttDyrIDyreparken(honningGrevlingenNils);


    }

    private static void printUtDyrIListe(ArrayList<Dyr> dyreListe) {
        for (Dyr etDyr : dyreListe) {
            System.out.println(etDyr + " - " + etDyr.getFodselsDato());
        }
    }
}
