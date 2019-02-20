package no.hiof.larseknu.javafx.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HovedVinduController  {

    // Knapp definert i fxml
    @FXML
    private Button velgFargeButton;

    // ColorPicker definert i fxml
    @FXML
    private ColorPicker fargeVelger;

    // Elipse definert i fxml
    @FXML
    private Circle sirkel;

    // Rektangel definert i fxml
    @FXML
    private Rectangle rektangel;

    // Initialiseringsmetode som blir kjørt når det tilhørende viewet (Hovedvindu.fxml) blir lastet inn
    @FXML
    private void initialize() {
        // Legger på en EventHandler til knappen, slik at vi får beskjed når den blir trykket
        velgFargeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Når den blir trykket på henter vi ut fargen fra ColorPickeren
                Paint valgtFarge = fargeVelger.getValue();
                // Setter fargen Elipsen skal fylles med
                sirkel.setFill(valgtFarge);
            }
        });

    }

    // EventHandler definert i fxml, denne metoden blir kalt når en knapp blir trykket på
    @FXML
    private void fargeleggRektangel(ActionEvent actionEvent) {
        // Når den blir trykket på henter vi ut fargen fra ColorPickeren
        Paint valgtFarge = fargeVelger.getValue();
        // Setter fargen Rektangelet skal fylles med
        rektangel.setFill(valgtFarge);
    }

}
