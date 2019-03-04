package no.hiof.larseknu.javafx.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import no.hiof.larseknu.javafx.Main;
import no.hiof.larseknu.javafx.data.DataHandler;
import no.hiof.larseknu.javafx.model.Dyr;

public class DyreDetaljController {

    @FXML
    private Label navnTekstLabel;
    @FXML
    private TextField idTextField, fodselsdatoTextField;

    private int valgtDyrIndex = 0;
    private ObservableList<Dyr> dyreListe;

    @FXML
    public void initialize() {
        dyreListe = DataHandler.hentDyreListe();

        if (valgtDyrIndex < dyreListe.size()) {
            Dyr etDyr = dyreListe.get(valgtDyrIndex);
            fyllUtDyreInfo(etDyr);
        }
    }

    private void fyllUtDyreInfo(Dyr etDyr) {
        if (etDyr != null) {
            navnTekstLabel.setText(etDyr.getArt() + " - " + etDyr.getNavn());
            idTextField.setText(String.valueOf(etDyr.getID()));
            fodselsdatoTextField.setText(etDyr.getFodselsDato().toString());
        }
    }

    @FXML
    public void gaaTilNesteDyr(ActionEvent actionEvent) {
        if(valgtDyrIndex +1 < dyreListe.size()) {
            fyllUtDyreInfo(dyreListe.get(valgtDyrIndex +1));
            valgtDyrIndex++;
        }
    }

    @FXML
    public void gaaTilForrigeDyr(ActionEvent actionEvent) {
        if(valgtDyrIndex -1 >= 0) {
            fyllUtDyreInfo(dyreListe.get(valgtDyrIndex -1));
            valgtDyrIndex--;
        }
    }

    @FXML
    public void gaaTilListeVisning(ActionEvent actionEvent) {
        Main minApplikasjon = Main.getInstance();

        Dyr dyrSomVisesNaa = dyreListe.get(valgtDyrIndex);

        Dyr valgtDyr = minApplikasjon.velgFraListe(dyrSomVisesNaa);

        fyllUtDyreInfo(valgtDyr);

        this.valgtDyrIndex = dyreListe.indexOf(valgtDyr);
    }
}
