package no.hiof.larseknu.javafx.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import no.hiof.larseknu.javafx.Main;
import no.hiof.larseknu.javafx.data.DataHandler;
import no.hiof.larseknu.javafx.model.Dyr;

import java.net.URL;
import java.util.ResourceBundle;

public class DyreListeController{
    // ListView definert i fxml
    @FXML
    private ListView<Dyr> dyreListe;
    // Lokal instansvariabel til å holde på valgt dyr
    private Dyr valgtDyr;

    // Initialize blir kalt når DyreListeController blir opprettet for oss
    // Vi er da sikre på at alle noder i SceneGrafen er klare til bruk (slik som dyreListe i dette tilfellet)
    @FXML
    public void initialize() {
        // Henter og setter listen med dyr til i ListeView'et
        dyreListe.setItems(DataHandler.hentDyreListe());

        // Setter opp at vi vil ha beskjed hver gang et dyr endres/blir valgt
        dyreListe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Dyr>() {
            @Override
            public void changed(ObservableValue<? extends Dyr> observableValue, Dyr gammeltDyr, Dyr nyttDyr) {
                // Printer ut dyret som er valgt
                System.out.println(nyttDyr);

                // Sjekker om dyret er et dovendyr
                if (nyttDyr.getArt().equals("Dovendyr"))
                    // Er det det, endrer vi det til et våkendyr, endringen blir vist i grensesnittet med en gang
                    nyttDyr.setArt("Våkendyr");
            }
        });

        // Setter det første dyret i listen til å være valgt
        dyreListe.getSelectionModel().select(0);
    }

    @FXML
    public void settValgtDyrOgAvslutt(ActionEvent actionEvent) {
        // Setter dyret som er valgt fra det som er valgt i listen
        valgtDyr = dyreListe.getSelectionModel().getSelectedItem();

        // Henter ut en referanse til Stage (vinduet) som vi er en del av
        Stage stage = (Stage)dyreListe.getScene().getWindow();

        // Lukker vinduet
        stage.close();
    }

    // Get metode for å hente valgt dyr
    public Dyr getValgtDyr() {
        return valgtDyr;
    }

    // Metode for å sette et dyr i lista som valgt
    public void setInitieltValgtDyr(Dyr initieltValgtDyr) {
        // Setter dyret som er valgt fra det som er valgt i listen
        dyreListe.getSelectionModel().select(initieltValgtDyr);

    }
}
