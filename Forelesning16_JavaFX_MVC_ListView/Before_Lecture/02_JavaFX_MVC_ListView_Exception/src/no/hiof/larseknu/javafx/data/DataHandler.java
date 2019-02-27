package no.hiof.larseknu.javafx.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.hiof.larseknu.javafx.model.Dyr;

import java.time.LocalDate;

public class DataHandler {
    private final static ObservableList<Dyr> dyreListe = FXCollections.observableArrayList();

    public static ObservableList<Dyr> hentDyreListe() {
        if (dyreListe.isEmpty())
            genererFilmData();
        return dyreListe;
    }

    private static void genererFilmData() {
        dyreListe.add(new Dyr("Nils", "HonningGrevling", LocalDate.of(2015, 5, 5)));
        dyreListe.add(new Dyr("Trine", "Panda",  LocalDate.of(1995, 2 ,1)));
        dyreListe.add(new Dyr("Guro", "Panda",  LocalDate.of(1995, 2 ,1)));
        dyreListe.add(new Dyr("Petter", "Panda",  LocalDate.of(1995, 2 ,1)));
        dyreListe.add(new Dyr("Gunnar", "Panda",  LocalDate.of(1995, 2 ,1)));
        dyreListe.add(new Dyr("Tom Heine", "Dovendyr",  LocalDate.of(1995, 2 ,1)));
    }
}