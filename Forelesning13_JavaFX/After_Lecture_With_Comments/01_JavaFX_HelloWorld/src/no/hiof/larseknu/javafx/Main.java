package no.hiof.larseknu.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


// For å si at dette er en JavaFX applikasjon, har vi satt at vi extender(arver) fra den abstrakte klassen Application
public class Main extends Application{

    public static void main(String[] args) {
        // Er en statisk metode som finnes i Application klassen vi arver fra
        // Denne gjør en del initialiseringsjobb, og oppretter og instansierer et objekt av denne klassen (Main)
        // Den kaller så Main sin start(primaryStage), etter den har fått satt opp alt
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Oppretter og instansierer et label objekt som vi skal benytte til å vise noe tekst i UI
        Label etTekstFelt = new Label();
        // Setter teksten til labelen
        etTekstFelt.setText("Hællæ JavaFX");

        // Oppretter og instanserer et button objekt som vi skal vise i UI
        Button enKnapp = new Button();
        // Setter en tekst på knappen
        enKnapp.setText("En fin liten knapp! Klikk meg gjerne!");

        // Oppretter og instanserer et Vbox objekt. Denne plaserer elementer vi legger til vertikalt etter hverandre i UI'et
        // Denne blir "rotnoden" i SceneGraph trestrukturen (trestruktur over alle elementene vi legger til i UI'et)
        // Vi kunne benyttet andre typer JavaFX objekter som kan holde på "barn" hvis vi skulle ønske det (slik som AnchorPane, GridPane og lignende)
        VBox hovedLayout = new VBox();
        // Setter at Vboxen skal prøve å fylle hele bredden av scenen den er med i
        hovedLayout.setFillWidth(true);
        // Henter ut alle barna (som er en liste) til Vbox, og legger til tekstfeltet vår i denne listen
        hovedLayout.getChildren().add(etTekstFelt);
        // Henter ut alle barna (som er en liste) til Vbox, og legger til knappen vår i denne listen. Knappen vil da havne under tekstfeltet som vi akkurat har lagt til.
        hovedLayout.getChildren().add(enKnapp);

        // Oppretter og instansierer scenen vi skal benytte, og setter hovedLayout(rotnoden), samt høyde og bredde
        Scene hovedScenen = new Scene(hovedLayout, 600, 600);

        // Legger scenen vi har laget til primaryStage (vinduet)
        primaryStage.setScene(hovedScenen);
        // Setter tittelen til primaryStage (vinduet)
        primaryStage.setTitle("Min første JavaFX applikasjon");
        // Viser primaryStage (vinduet). Uten denne vil vi ikke få frem noe på skjermen
        primaryStage.show();
    }
}

