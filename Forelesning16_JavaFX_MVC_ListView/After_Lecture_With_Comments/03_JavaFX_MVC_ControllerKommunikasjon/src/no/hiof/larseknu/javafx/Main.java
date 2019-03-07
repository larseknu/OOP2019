package no.hiof.larseknu.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.hiof.larseknu.javafx.controller.DyreListeController;
import no.hiof.larseknu.javafx.model.Dyr;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main extends Application {
    // Hovedvinduet i applikasjonen vår
    private Stage primaryStage;
    // En statisk klassevariabel til instansen av klassen vår
    private static Main minApplikasjon;

    // Standardkonstruktør
    public Main() {
        // Setter den statiske variabelen til å peke på objektet som blir laget av Main (denne applikasjonen)
        minApplikasjon = this;
    }

    @Override
    public void start(Stage primaryStage){
        // Setter instansvariabelen til vinduet (stagen) som er laget
        this.primaryStage = primaryStage;

        // Sier at vi skal starte hovedvisningen
        gaaTilHovedVisning();
    }

    public void gaaTilHovedVisning() {
        try {
            // Oppretter og instansierer et objekt av klassen FXMLLoader. Som vi benytter til å laste inn UI fra en .fxml fil.
            FXMLLoader fxmlInnlaster = new FXMLLoader();
            // Setter lokasjonen vi skal laste inn .fxml filen fra (hvilken fil vi skal hente fra)
            fxmlInnlaster.setLocation(getClass().getResource("view/DyreDetalj.fxml"));
            // Laster inn hovedLayoutet/rotnoden fra Hovedlayout.fxml
            Parent hovedLayout = fxmlInnlaster.load();

            // Oppretter og instansierer scenen vi skal benytte, og setter hovedLayout(rotnoden), samt høyde og bredde
            Scene hovedScene = new Scene(hovedLayout, 400, 200);

            // Legger scenen vi har laget til primaryStage (vinduet)
            primaryStage.setScene(hovedScene);
            // Lager en tittel
            primaryStage.setTitle("Dyrene i Dyreparken");
            // Viser primaryStage (vinduet). Uten denne vil vi ikke få frem noe på skjermen
            primaryStage.show();
        }
        catch (IOException ioe) {
            // Viser en alertboks med feilmeldingen vår
            visAlertFeilmelding("I/O feil ", ioe.getMessage());
        }
        catch (IllegalStateException ise) {
            // Viser en alertboks med feilmeldingen vår
            visAlertFeilmelding("Feil 41\nFant ikke grensesnittdefinisjon", ise.getMessage());
        }
    }

    public Dyr velgFraListe(Dyr dyrSomVisesNaa) {
        try {
            // Oppretter og instansierer et objekt av klassen FXMLLoader. Som vi benytter til å laste inn UI fra en .fxml fil.
            FXMLLoader fxmlInnlaster = new FXMLLoader();

            // Setter lokasjonen vi skal laste inn .fxml filen fra (hvilken fil vi skal hente fra)
            fxmlInnlaster.setLocation(getClass().getResource("view/Dyreliste.fxml"));
            // Laster inn hovedLayoutet/rotnoden fra Dyreliste.fxml
            Parent hovedLayout = fxmlInnlaster.load();

            // Henter en referanse til controlleren, slik av vi kan hente valgt dyr senere
            DyreListeController dyreListeController = fxmlInnlaster.getController();

            // Setter dyret som skal være valgt når vi åpner lista
            dyreListeController.setInitieltValgtDyr(dyrSomVisesNaa);

            // Oppretter og instansierer scenen vi skal benytte, og setter hovedLayout(rotnoden), samt høyde og bredde
            Scene hovedScene = new Scene(hovedLayout, 400, 200);

            // Lager en ny stage (vindu)
            Stage nyListeStage = new Stage();

            // Setter at dette vinduet skal være en modul i applikasjonen
            nyListeStage.initModality(Modality.APPLICATION_MODAL);
            // Setter hovedscenen som eier av dette vinduet
            nyListeStage.initOwner(primaryStage);

            nyListeStage.setScene(hovedScene);
            nyListeStage.setTitle("DyreListe");
            // Starter vinduet og venter til det er lukket med å gå videre
            nyListeStage.showAndWait();

            // Henter og returnerer dyret som er valgt i controlleren
            return dyreListeController.getValgtDyr();
        }
        catch (IOException ioe) {
            visAlertFeilmelding("I/O feil ", ioe.getMessage());
            return null;
        }
        catch (IllegalStateException ise) {
            visAlertFeilmelding("Feil 41\nFant ikke grensesnittdefinisjon", ise.getMessage());
            return null;
        }
    }

    private void visAlertFeilmelding(String overskrift, String melding) {
        // Lager en alertboks, av typen "ERROR"
        Alert exceptionAlert = new Alert(Alert.AlertType.ERROR);
        exceptionAlert.setTitle("Feil");
        exceptionAlert.setHeaderText(overskrift);
        exceptionAlert.setContentText(melding);

        // Viser alertboksen, og venter med å gå videre til brukeren har trykket på OK/lukket den
        exceptionAlert.showAndWait();
    }

    // Statisk metode for å hente instansen av applikasjonen vår (Main)
    public static Main getInstance() {
        return minApplikasjon;
    }

    public static void main(String[] args) {
        // Vi må starte denne applikasjonen som en JavaFX applikasjon, og kaller derfor "launch"
        // Denne gjør en del i "bakgrunnen", blant annet
        // initaliserer den et objekt av denne klassen (Main applikasjon = new Main();)
        // Samt kaller metoden applikasjon.start();
        Application.launch(args);
    }
}









