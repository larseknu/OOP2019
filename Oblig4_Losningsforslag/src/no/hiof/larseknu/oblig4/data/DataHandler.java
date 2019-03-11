package no.hiof.larseknu.oblig4.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.hiof.larseknu.oblig4.model.Film;
import no.hiof.larseknu.oblig4.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataHandler {
    private final static ObservableList<Film> filmListe = FXCollections.observableArrayList();

    public static ObservableList<Film> hentFilmData() {
        if (filmListe.isEmpty())
            genererFilmData();
        return filmListe;
    }

    private static void genererFilmData() {
        filmListe.add(new Film("The Avengers",
                "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity." ,
                143,
                LocalDate.of(2012, 4, 27),
                new Person("Josh", "Whedon", LocalDate.of(1964, 6, 23))));
        filmListe.add(new Film("Bird Box",
                "Five years after an ominous unseen presence drives most of society to suicide, a mother and her two children make a desperate bid to reach safety.",
                124,
                LocalDate.of(2018, 12, 21),
                new Person("Susanne", "Bier", LocalDate.of(1960, 4, 15))));
    }
}
