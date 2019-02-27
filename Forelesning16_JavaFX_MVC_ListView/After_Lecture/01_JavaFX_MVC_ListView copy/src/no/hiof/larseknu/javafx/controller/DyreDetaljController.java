package no.hiof.larseknu.javafx.controller;

import javafx.collections.ListChangeListener;
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

    private int valgtDyr = 0;
    private ObservableList<Dyr> dyreListe;

    @FXML
    public void initialize() {
        dyreListe = DataHandler.hentDyreListe();

        if (valgtDyr < dyreListe.size()) {
            Dyr etDyr = dyreListe.get(valgtDyr);
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
        if(valgtDyr+1 < dyreListe.size()) {
            fyllUtDyreInfo(dyreListe.get(valgtDyr+1));
            valgtDyr++;
        }
    }

    @FXML
    public void gaaTilForrigeDyr(ActionEvent actionEvent) {
        if(valgtDyr-1 >= 0) {
            fyllUtDyreInfo(dyreListe.get(valgtDyr-1));
            valgtDyr--;
        }
    }

    @FXML
    public void gaaTilListeVisning(ActionEvent actionEvent) {
        Main minApplikasjon = Main.getInstance();

        minApplikasjon.gaaTilListeVisning();
    }
}
