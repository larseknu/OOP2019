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
    }

}
