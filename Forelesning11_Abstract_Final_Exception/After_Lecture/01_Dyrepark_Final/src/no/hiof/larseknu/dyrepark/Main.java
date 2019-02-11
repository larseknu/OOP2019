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

        for (int i = 0; i < 6; i++)
            honningGrevlingenNils.drepteEnSlangeTil();

        sjimpansenArne.setIq(50);

        pandaenTrine.setKungFuBelteFarge("Gult");

        System.out.println(sjimpansenArne.getId());

        kristiansandDyrepark.skrivAlleBursdagerForMaanedTilFil(3, "bursdager_mars.txt");


        ArrayList<Dyr> dyrIParken = kristiansandDyrepark.getDyrIDyreparken();
        // Innlagt rekkefølge:
        System.out.println("***********Dyr i innlagt rekkefølge************");
        for (Dyr etDyr : dyrIParken) {
            System.out.println(etDyr);
        }

        // Sorterer listen, bruker compareTo i Dyr, fordi vi implementerer interfacet Comparable
        Collections.sort(dyrIParken);

        // Standard sortering
        System.out.println("*************Standardsortering***************");
        for (Dyr etDyr : dyrIParken) {
            System.out.println(etDyr);
        }


        // Sorterer med vår egen klasse som implementerer Comparator for sortering
        Collections.sort(dyrIParken, new SortereDyrPaaFodselsdato());
        // Lager egen anonym indre klasse av Comparator, for å kunne lage en egen sortering på fodselsdato
        Collections.sort(dyrIParken, new Comparator<Dyr>() {
            @Override
            public int compare(Dyr dyr1, Dyr dyr2) {
                return dyr1.getFodselsDato().compareTo(dyr2.getFodselsDato());
            }
        });


        System.out.println("*************Sortert på fødselsdato***************");
        for (Dyr etDyr : dyrIParken) {
            System.out.println(etDyr + " - " + etDyr.getFodselsDato());
        }
    }
}
