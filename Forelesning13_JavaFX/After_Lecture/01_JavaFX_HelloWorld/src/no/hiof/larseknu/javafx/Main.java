package no.hiof.larseknu.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application{

    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label etTekstFelt = new Label();
        etTekstFelt.setText("Hællæ JavaFX");

        Button enKnapp = new Button();
        enKnapp.setText("En fin liten knapp! Klikk meg gjerne!");

        VBox hovedLayout = new VBox();
        hovedLayout.setFillWidth(true);
        hovedLayout.getChildren().add(etTekstFelt);
        hovedLayout.getChildren().add(enKnapp);

        Scene hovedScenen = new Scene(hovedLayout, 600, 600);

        primaryStage.setScene(hovedScenen);
        primaryStage.setTitle("Min første JavaFX applikasjon");
        primaryStage.show();
    }
}

