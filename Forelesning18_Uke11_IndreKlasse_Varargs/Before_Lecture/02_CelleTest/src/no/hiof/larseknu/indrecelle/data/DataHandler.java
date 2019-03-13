package no.hiof.larseknu.indrecelle.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.hiof.larseknu.indrecelle.model.Dyr;

public class DataHandler {
    private static ObservableList<Dyr> dyreListe = FXCollections.observableArrayList();

    public static ObservableList<Dyr> hentDyreListe() {
        if (dyreListe.isEmpty())
            genererDyr();

        return dyreListe;
    }

    private static void genererDyr() {
        dyreListe.add(new Dyr("Nils", "HonningGrevling", false));
        dyreListe.add(new Dyr("Shere Kahn", "Hvit Tiger", true));
        dyreListe.add(new Dyr("Sjimpanse", "Julius", false));
        dyreListe.add(new Dyr("Nemo", "Klovnefisk", true));
        dyreListe.add(new Dyr("Rino", "Svart Nesehorn", true));
    }

}
