package no.hiof.larseknu.indrecelle.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Paint;
import javafx.util.Callback;
import no.hiof.larseknu.indrecelle.data.DataHandler;
import no.hiof.larseknu.indrecelle.model.Dyr;

import javax.xml.crypto.Data;

public class DyreListeController {
    @FXML
    private ListView<Dyr> dyreListView;
    @FXML
    private ListView<Dyr> utrydningsListView;

    @FXML
    private void initialize() {
        ObservableList<Dyr> dyreListe = DataHandler.hentDyreListe();

        // Fyller opp listview med listen av dyr
        dyreListView.setItems(dyreListe);

        // Fyller opp listview med listen av dyr
        utrydningsListView.setItems(dyreListe);

        // Setter at vi skal sette vår egen CellFactory
        // Vi får da mulighet til å manipulere hva slags ListCelle som skal returneres/benyttes i ListView'et
        utrydningsListView.setCellFactory(new Callback<ListView<Dyr>, ListCell<Dyr>>() {
            @Override
            public ListCell<Dyr> call(ListView<Dyr> dyrListView) {
                return new UtrydningsListCell();
            }
        });
    }

    // Indre klasse som ekstender ListCell
    // Vi har her ikke behov for å ha tilgang til noe fra den ytre klassen og setter den derfor til static
    private static class UtrydningsListCell extends ListCell<Dyr> {
        @Override
        protected void updateItem(Dyr etDyr, boolean empty) {
            super.updateItem(etDyr, empty);

            // Sjekker om dataen vi skal vise er tomt eller null
            if (empty || etDyr == null) {
                // Setter teksten til å være null (ingenting skal vises i denne cellen)
                setText(null);
            }
            else {
                // Sjekker om dyret er utrydningstruet
                if (etDyr.isUtryddningsTruet())
                    // Setter i så fall fargen til rød
                    setTextFill(Paint.valueOf("Red"));

                // Spesifiserer hvilken tekst fra modellen som vises i cellen
                setText(etDyr.getArt());
            }
        }
    }
}
