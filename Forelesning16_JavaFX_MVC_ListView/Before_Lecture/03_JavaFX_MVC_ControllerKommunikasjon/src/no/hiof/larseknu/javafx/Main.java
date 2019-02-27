package no.hiof.larseknu.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main extends Application {
    private Stage primaryStage;
    private static Main minApplikasjon;

    public Main() {
        minApplikasjon = this;
    }

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;

        gaaTilHovedVisning();
    }

    public void gaaTilHovedVisning() {
        try {
            FXMLLoader fxmlInnlaster = new FXMLLoader();
            fxmlInnlaster.setLocation(getClass().getResource("view/DyreDetalj.fxml"));
            Parent hovedLayout = fxmlInnlaster.load();

            Scene hovedScene = new Scene(hovedLayout, 400, 200);

            primaryStage.setScene(hovedScene);
            primaryStage.setTitle("Dyrene i Dyreparken");
            primaryStage.show();
        }
        catch (IOException ioe) {
            visAlertFeilmelding("I/O feil: ", ioe.getMessage());
        }
        catch (IllegalStateException ise) {
            visAlertFeilmelding("Feil 41\nFant ikke grensesnittdefinisjon", ise.getMessage());
        }
    }

    public void gaaTilListeVisning() {
        try {
            FXMLLoader fxmlInnlaster = new FXMLLoader();
            fxmlInnlaster.setLocation(getClass().getResource("view/DyreListe.fxml"));
            Parent hovedLayout = fxmlInnlaster.load();

            Scene hovedScene = new Scene(hovedLayout);

            primaryStage.setScene(hovedScene);
            primaryStage.setTitle("DyreListe");
            primaryStage.show();
        }
        catch (IOException ioe) {
            visAlertFeilmelding("I/O feil ", ioe.getMessage());
        }
        catch (IllegalStateException ise) {
            visAlertFeilmelding("Feil 41\nFant ikke grensesnittdefinisjon", ise.getMessage());
        }
    }

    private void visAlertFeilmelding(String overskrift, String melding) {
        Alert exceptionAlert = new Alert(Alert.AlertType.ERROR);
        exceptionAlert.setTitle("Feil");
        exceptionAlert.setHeaderText(overskrift);
        exceptionAlert.setContentText(melding);

        exceptionAlert.showAndWait();
    }

    public static Main getInstance() {
        return minApplikasjon;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
