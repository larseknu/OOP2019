package no.hiof.larseknu.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
        catch (IOException ioexc) {
            // Skriver ut feilmelding til konsollen
            System.out.println(ioexc.getMessage());
        }
    }

    public void gaaTilListeVisning() {
        try {
            // Oppretter og instansierer et objekt av klassen FXMLLoader. Som vi benytter til å laste inn UI fra en .fxml fil.
            FXMLLoader fxmlInnlaster = new FXMLLoader();
            // Setter lokasjonen vi skal laste inn .fxml filen fra (hvilken fil vi skal hente fra)
            fxmlInnlaster.setLocation(getClass().getResource("view/Dyreliste.fxml"));
            // Laster inn hovedLayoutet/rotnoden fra Dyreliste.fxml
            Parent hovedLayout = fxmlInnlaster.load();

            // Oppretter og instansierer scenen vi skal benytte, og setter hovedLayout(rotnoden), samt høyde og bredde
            Scene hovedScene = new Scene(hovedLayout, 400, 200);

            primaryStage.setScene(hovedScene);
            primaryStage.setTitle("Dyreliste");
        }
        catch (IOException ioexc) {
            // Skriver ut feilmelding til konsollen
            System.out.println(ioexc.getMessage());
        }
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
