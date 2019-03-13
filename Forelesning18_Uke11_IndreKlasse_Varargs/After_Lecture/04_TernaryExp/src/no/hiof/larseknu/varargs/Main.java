package no.hiof.larseknu.varargs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Film> filmer = new ArrayList<>();
        filmer.add(new Film("Iron Man", LocalDate.of(2009, 1, 1)));
        filmer.add(new Film("Iron Man 2", LocalDate.of(2011, 1, 1)));
        filmer.add(new Film("Iron Man 3", LocalDate.of(2012, 1, 1)));
        filmer.add(new Film("Iron Man 4"));

        // Går gjennom alle filmene
        for (Film enFilm : filmer) {
            // Undersøker om datoen er lik LocalDate.MIN, skriver ut datoen hvis den ikke er det.
            if (enFilm.getDato() == LocalDate.MIN)
                System.out.println("Ingen dato");
            else
                System.out.println(enFilm.getDato());

            // "Hurtig-if" av if-spørringen rett over. Gjør akkurat det samme.
            // spørring ? true : false
            System.out.println((enFilm.getDato() == LocalDate.MIN ? "Ingen dato" : enFilm.getDato()));
        }

    }
}

