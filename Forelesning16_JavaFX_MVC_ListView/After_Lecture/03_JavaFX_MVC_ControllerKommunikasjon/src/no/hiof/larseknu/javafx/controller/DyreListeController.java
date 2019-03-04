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
    @FXML
    private ListView<Dyr> dyreListe;

    private Dyr valgtDyr;

    @FXML
    public void initialize() {
        dyreListe.setItems(DataHandler.hentDyreListe());

        dyreListe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Dyr>() {
            @Override
            public void changed(ObservableValue<? extends Dyr> observableValue, Dyr gammeltDyr, Dyr nyttDyr) {
                System.out.println(nyttDyr);

                if (nyttDyr.getArt().equals("Dovendyr")) {
                    nyttDyr.setArt("Våkendyr");
                }

                valgtDyr = nyttDyr;
            }
        });
    }

    @FXML
    public void settValgtDyrOgAvslutt(ActionEvent actionEvent) {
        valgtDyr = dyreListe.getSelectionModel().getSelectedItem();

        Stage stage = (Stage)dyreListe.getScene().getWindow();

        stage.close();
    }

    public Dyr getValgtDyr() {
        return valgtDyr;
    }

    public void setInitieltValgtDyr(Dyr dyrSomVisesNaa) {
        dyreListe.getSelectionModel().select(dyrSomVisesNaa);
    }
}
