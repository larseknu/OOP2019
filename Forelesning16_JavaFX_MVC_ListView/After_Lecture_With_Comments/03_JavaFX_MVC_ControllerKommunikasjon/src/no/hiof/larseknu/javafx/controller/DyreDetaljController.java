package no.hiof.larseknu.javafx.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import no.hiof.larseknu.javafx.Main;
import no.hiof.larseknu.javafx.data.DataHandler;
import no.hiof.larseknu.javafx.model.Dyr;

public class DyreDetaljController {
    // Label definert i fxml
    @FXML
    private Label navnTekstLabel;
    // TextField definert i fxml

    @FXML
    private TextField idTextField, fodselsdatoTextField;

    // Index for hvilket dyr som er valgt
    private int valgtDyrIndex = 0;
    // En instansvariabel for å holde på listen med dyr
    private ObservableList<Dyr> dyreListe;

    // Initialize blir kalt når DyreListeController blir opprettet for oss
    // Vi er da sikre på at alle noder i SceneGrafen er klare til bruk (slik som navnTekstLabel, idTextField etc. i dette tilfellet)
    @FXML
    public void initialize() {
        // Henter en referanse til dyrelisten
        dyreListe = DataHandler.hentDyreListe();

        // Sjekker om vi har noe dyr i listen
        if (valgtDyrIndex < dyreListe.size()) {
            // Har vi oppretter vi et dyrobjekt med referanse til dyret
            Dyr etDyr = dyreListe.get(valgtDyrIndex);
            // Sender dyret til fyllUtDyreInfo-metoden
            fyllUtDyreInfo(etDyr);
        }
    }

    // Fyller ut grensesnittet med info om et dyr
    private void fyllUtDyreInfo(Dyr etDyr) {
        // Sjekker om dyret ikke er "null"
        if (etDyr != null) {
            // Er det ikke det, fyller vi inn den forskjellige infoen fra dyrobjektet
            navnTekstLabel.setText(etDyr.getArt() + " - " + etDyr.getNavn());
            idTextField.setText(String.valueOf(etDyr.getID()));
            fodselsdatoTextField.setText(etDyr.getFodselsDato().toString());
        }
    }

    // Metode for å hente og vise neste dyr
    // EventHandleren er "satt" i fxml'en
    @FXML
    public void gaaTilNesteDyr(ActionEvent actionEvent) {
        // Undersøker om vi har noen flere dyr i listen
        if(valgtDyrIndex +1 < dyreListe.size()) {
            // Har vi det, henter vi ut dyret og sender det til fyllUtDyreInfo metoden
            fyllUtDyreInfo(dyreListe.get(valgtDyrIndex +1));
            // Øker indexen til valgtDyrIndex med 1
            valgtDyrIndex++;
        }
    }

    // Metode for å hente og vise forrige dyr
    // EventHandleren er "satt" i fxml'en
    @FXML
    public void gaaTilForrigeDyr(ActionEvent actionEvent) {
        // Undersøker om vi har noen dyr "tilbake" i lista
        if(valgtDyrIndex -1 >= 0) {
            // Har vi det, henter vi ut dyret og sender det til fyllUtDyreInfo metoden
            fyllUtDyreInfo(dyreListe.get(valgtDyrIndex -1));
            // Senker indexen til valgtDyrIndex med 1
            valgtDyrIndex--;
        }
    }

    @FXML
    public void velgDyrFraListe(ActionEvent actionEvent) {
        // Henter instansen av min applikasjon
        Main minApplikasjon = Main.getInstance();

        // Henter ut dyr som vises nå
        Dyr dyrSomVisesNaa = dyreListe.get(valgtDyrIndex);

        // Sier til applikasjonen at vi vil velge et dyr fra en liste, får et valgt dyr tilbake
        // Sender med dyret som initielt skal være valgt i lista
        Dyr valgtDyr = minApplikasjon.velgFraListe(dyrSomVisesNaa);

        // Fyller ut data om valgt dyr
        fyllUtDyreInfo(valgtDyr);

        // Setter indexen "valgtDyrIndex" til indexen i listen for dyret
        this.valgtDyrIndex = dyreListe.indexOf(valgtDyr);
    }
}
