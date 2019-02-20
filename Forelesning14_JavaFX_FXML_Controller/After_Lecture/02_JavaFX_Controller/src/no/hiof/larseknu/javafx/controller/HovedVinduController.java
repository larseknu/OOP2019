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
    @FXML
    private Button velgFargeButton;
    @FXML
    private ColorPicker fargeVelger;
    @FXML
    private Circle sirkel;
    @FXML
    private Rectangle rektangel;

    @FXML
    private void initialize() {

        velgFargeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Paint valgtFarge = fargeVelger.getValue();

                sirkel.setFill(valgtFarge);
            }
        });

    }

    @FXML
    private void fargeleggRektangel(ActionEvent actionEvent) {
        Paint valgtFarge = fargeVelger.getValue();

        rektangel.setFill(valgtFarge);
    }

}
