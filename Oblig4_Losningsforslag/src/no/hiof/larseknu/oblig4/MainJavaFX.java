package no.hiof.larseknu.oblig4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.hiof.larseknu.oblig4.controller.RedigerFilmController;
import no.hiof.larseknu.oblig4.model.Film;

import java.io.IOException;

public class MainJavaFX extends Application {
    private static MainJavaFX minApplikasjon;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        // Setter den statiske minApplikasjon objektet til vår egen instans, slik at den blir tilgjengelig fra alle andre klasser
        minApplikasjon = this;

        try{
            this.primaryStage = primaryStage;

            primaryStage.setTitle("MovieTime");

            FXMLLoader fxmlLoader = new FXMLLoader();

            fxmlLoader.setLocation(getClass().getResource("view/Filmer.fxml"));

            Parent filmOversiktLayout = fxmlLoader.load();

            Scene hovedScene = new Scene(filmOversiktLayout, 1000, 500);

            primaryStage.setScene(hovedScene);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean visRedigerFilmDialog(Film filmSomSkalRedigeres) {
        try {
            // Oppretter og instansierer fxmlLoader
            FXMLLoader fxmlLoader = new FXMLLoader();

            // Setter hvilken FXML fil vi skal laste inn
            fxmlLoader.setLocation(getClass().getResource("view/RedigerFilmDialog.fxml"));
            // Laster inn FXML innhold og legger det i et parent objekt
            Parent dialogLayout = fxmlLoader.load();

            // Oppretter og instansierer vinduet
            Stage dialogStage = new Stage();
            // Setter tittelen
            dialogStage.setTitle("Rediger film");
            // Setter modality til WINDOW_MODAL, dette gjør at vinduet må lukkes før man kan gjøre noe mer i "hovedvinduet"
            dialogStage.initModality(Modality.WINDOW_MODAL);
            // Setter eier til å være hovedvinduet ("hovedstagen")
            dialogStage.initOwner(primaryStage);

            // Lager en ny scene og legger til layoutet fra fxml-fila
            Scene dialogScene = new Scene(dialogLayout);
            // Legger scenen til vinduet
            dialogStage.setScene(dialogScene);

            // Henter ut kontrolleren som er knyttet til fxml'en
            RedigerFilmController redigerController = fxmlLoader.getController();
            // Setter hvilken film som skal redigeres
            redigerController.setFilmSomSkalRedigeres(filmSomSkalRedigeres);

            // Viser dialogvinduet, og venter med å gå videre til det er lukket
            dialogStage.showAndWait();

            // Dialogvinduet er blitt lukket, og vi undersøker hvordan vi ble avsluttet (om OK ble valgt, eller om vi avsluttet på annnen måte)
            return redigerController.erOkValgt();
        }
        catch (IOException | IllegalStateException exception) {
            visAlert(exception.getMessage());
            exception.printStackTrace();
            return false;
        }
    }

    private void visAlert(String melding) {
        Alert newAlert = new Alert(Alert.AlertType.ERROR);
        newAlert.setTitle("Feil");
        newAlert.setHeaderText(null);
        newAlert.setContentText("Noe gikk feil! " + melding);

        newAlert.showAndWait();
    }

    public static MainJavaFX getInstance() {
        return minApplikasjon;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
