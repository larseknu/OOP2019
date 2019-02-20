package no.hiof.larseknu.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// For å si at dette er en JavaFX applikasjon, har vi satt at vi extender(arver) fra den abstrakte klassen Application
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Oppretter og instansierer et objekt av klassen FXMLLoader. Som vi benytter til å laste inn UI fra en .fxml fil.
        FXMLLoader fxmlInnlaster = new FXMLLoader();
        // Setter lokasjonen vi skal laste inn .fxml filen fra (hvilken fil vi skal hente fra)
        // getClass().getResource() tar utgangspunkt at vi begynner å lete i strukturen der Main.java er laget
        // Dette vil si at vi begynner å lete i mappen/pakken "no.hiof.larseknu.javafxml"
        // Siden vi derfra ønsker å gå inn i mappen/pakken "view" og leter etter "Hovedvindu.fxml" holder det å skriv "view/Hovedvindu.fxml"
        fxmlInnlaster.setLocation(getClass().getResource("view/Hovedvindu.fxml"));
        // Laster inn hovedLayoutet/rotnoden fra Hovedvindu.fxml
        // Hadde vi ønsket å få tilgang til funksjonalitet som ligger i denne, og vi vet hvilken type den er, kunne vi typecastet den
        // F.eks. hvis det var en AnchorPane definert som rotnoden i Hovedvindu.fxml. Kunne vi skrevet:
        // AnchorPane hovedLayout = (AnchorPane) fxmlInnlaster.load();
        // Men enn så lenge holder det å få Parent, som er en av superklassene til nodene vi kan benytte
        Parent hovedLayout = fxmlInnlaster.load();

        // Oppretter og instansierer scenen vi skal benytte, og setter hovedLayout(rotnoden), samt høyde og bredde
        Scene hovedScene = new Scene(hovedLayout, 400, 300);


        // Legger scenen vi har laget til primaryStage (vinduet)
        primaryStage.setScene(hovedScene);
        // Setter tittelen til primaryStage (vinduet)
        primaryStage.setTitle("Applikasjon med FXML grensesnitt");
        // Viser primaryStage (vinduet). Uten denne vil vi ikke få frem noe på skjermen
        primaryStage.show();
    }

    public static void main(String[] args) {
        // launch er en statisk metode som finnes i Application klassen vi arver fra
        // Denne gjør en del initialiseringsjobb, og oppretter og instansierer et objekt av denne klassen (Main)
        // Den kaller så Main sin start(primaryStage), etter den har fått satt opp alt
        // Application.launch(args); // vil gjøre akkurat det samme/er samme metode
        launch(args);
    }
}
