package no.hiof.larseknu.listetest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> dyreNavnArrayList = new ArrayList<>();
        dyreNavnArrayList.add("HonningGrevling(Nils)");
        dyreNavnArrayList.add("Panda(Trine)");
        dyreNavnArrayList.add("Sjimpanse(Arne)");
        dyreNavnArrayList.add("Katt(Misti)");
        dyreNavnArrayList.add("Hund(Dent)");

        System.out.println(dyreNavnArrayList);

        List<String> dyreNavnLinkedList = new LinkedList<String>();
        dyreNavnLinkedList.add("HonningGrevling(Nils)");
        dyreNavnLinkedList.add("Panda(Trine)");
        dyreNavnLinkedList.add("Sjimpanse(Arne)");
        dyreNavnLinkedList.add("Katt(Misti)");
        dyreNavnLinkedList.add("Hund(Dent)");

        System.out.println(dyreNavnLinkedList);



    }

    private static void leggTilTallIListeOgTaTiden(List<Integer> listeViSkalLeggeTilTallI, int antallTallViSkalLeggeTil, boolean leggeTilISluttenAvListen) {
        int posisjonViSkalLeggeTilElementerI = 0;

        if (listeViSkalLeggeTilTallI.size() > 0 )
            posisjonViSkalLeggeTilElementerI = listeViSkalLeggeTilTallI.size() / 2;

        // tar starttidspunktet
        long startTid = System.currentTimeMillis();

        // lager løkke som ittererer antallTallViSkalLeggTil ganger
        for(int i = 1; i <= antallTallViSkalLeggeTil; i++) {
            // legger til i i listen
            if (leggeTilISluttenAvListen)
                listeViSkalLeggeTilTallI.add(i);
            else
                listeViSkalLeggeTilTallI.add(posisjonViSkalLeggeTilElementerI, i);
        }

        long sluttTid = System.currentTimeMillis();

        // Skriver ut tiden vi brukte
        System.out.println("Tiden det tok å legge til " + antallTallViSkalLeggeTil + " elementer i " +
                    (leggeTilISluttenAvListen? "slutten": (posisjonViSkalLeggeTilElementerI==0?"begynnelsen":"midten")) +
                    " av en "+ listeViSkalLeggeTilTallI.getClass().getSimpleName() +
                    ": " + (sluttTid - startTid) + " ms");
    }
}
