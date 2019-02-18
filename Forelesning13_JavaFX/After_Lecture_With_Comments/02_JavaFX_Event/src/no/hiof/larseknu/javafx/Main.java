package no.hiof.larseknu.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


// For å si at dette er en JavaFX applikasjon, har vi satt at vi extender(arver) fra den abstrakte klassen Application
public class Main extends Application{
    // int som vi bruker til å telle antallet ganger vi har trykket på en knapp
    private int teller = 0;

    public static void main(String[] args) {
        // launch er en statisk metode som finnes i Application klassen vi arver fra
        // Denne gjør en del initialiseringsjobb, og oppretter og instansierer et objekt av denne klassen (Main)
        // Den kaller så Main sin start(primaryStage), etter den har fått satt opp alt
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Oppretter og instansierer et label objekt som vi skal benytte til å vise noe tekst i UI
        Label etTekstFelt = new Label();
        // Setter fonten vi skal benytte i tekstfeltet. Finnes ikke fonten i systemet blir default benyttet. Setter også fontstørrelse 24
        etTekstFelt.setFont(Font.font("Calibri", 24));
        // Setter teksten til labelen
        etTekstFelt.setText("Hællæ JavaFX");

        // Oppretter og instanserer et button objekt som vi skal vise i UI
        Button enKnapp = new Button();
        // Setter en tekst på knappen
        enKnapp.setText("En fin liten knapp! Klikk meg gjerne!");

        // Legger til en EventHandler til knappen. Vi får da "beskjed" når knappen blir trykket på
        // EventHandler er et interface vi her i praksis implementerer og instansierer samtidig (lager en anonym klasse)
        // Vi skal bare skal gjøre dette ett sted, er det OK å gjøre det på denne måten.
        enKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Når knappen blir trykket på øker telleren med 1
                teller++;

                // Vi sjekker om telleren er kommet til 10 (knappen er trykket 10 ganger)
                if (teller == 10) {
                    // Har den de kaller vi visAlert() metoden som viser en Alert-dialogboks
                    visAlert();
                    // Setter telleren tilbake til 0
                    teller = 0;
                }

                // Oppdaterer tekstfeltet med en ny tekst
                etTekstFelt.setText("Knapp klikket " + teller + " ganger");
            }
        });
        // Legger til en EventHandler<MouseEvent> til knappen. Vi får da "beskjed" når musen blir tatt over knappen
        // EventHandler er et interface vi her i praksis implementerer og instansierer samtidig (lager en anonym klasse)
        // Vi skal bare skal gjøre dette ett sted, er det OK å gjøre det på denne måten.
        enKnapp.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Vi skriver ut en liten tekst til konsollen (ikke så vanlig i UI applikasjoner, vi gjør dette bare for testingens del
                System.out.println("Mus over knapp!");
                // Setter en ny font på knappen. Finnes ikke fonten i systemet blir default benyttet. Setter også fontstørrelse 24
                enKnapp.setFont(new Font("Comic Sans MS", 24));
            }
        });
        // Legger til en EventHandler<MouseEvent> til knappen. Vi får da "beskjed" når musen blir tatt bort fra knappen
        // EventHandler er et interface vi her i praksis implementerer og instansierer samtidig (lager en anonym klasse)
        // Vi skal bare skal gjøre dette ett sted, er det OK å gjøre det på denne måten.
        enKnapp.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Setter en ny font på knappen. Finnes ikke fonten i systemet blir default benyttet. Setter også fontstørrelse 24
                System.out.println("Mus bort fra knapp!");
                enKnapp.setFont(new Font("Calibri", 14));
            }
        });

        // Oppretter og instanserer et Vbox objekt. Denne plaserer elementer vi legger til vertikalt etter hverandre i UI'et
        // Denne blir "rotnoden" i SceneGraph trestrukturen (trestruktur over alle elementene vi legger til i UI'et)
        // Vi kunne benyttet andre typer JavaFX objekter som kan holde på "barn" hvis vi skulle ønske det (slik som AnchorPane, GridPane og lignende)
        VBox hovedLayout = new VBox();
        // Stter at Vboxen skal prøve å fylle hele bredden av scenen den er med i
        hovedLayout.setFillWidth(true);
        // Henter ut alle barna (som er en liste) til Vbox, og legger til tekstfeltet vår i denne listen
        hovedLayout.getChildren().add(etTekstFelt);
        // Henter ut alle barna (som er en liste) til Vbox, og legger til knappen vår i denne listen. Knappen vil da havne under tekstfeltet som vi akkurat har lagt til.
        hovedLayout.getChildren().add(enKnapp);
        // Setter at de elementene vi legger til i Vbox'en skal være sentrert, både horisontalt og vertikalt
        hovedLayout.setAlignment(Pos.CENTER);

        // Oppretter og instansierer scenen vi skal benytte, og setter hovedLayout(rotnoden), samt høyde og bredde
        Scene hovedScenen = new Scene(hovedLayout, 300, 300);

        // Legger scenen vi har laget til primaryStage (vinduet)
        primaryStage.setScene(hovedScenen);
        // Setter tittelen til primaryStage (vinduet)
        primaryStage.setTitle("Min første JavaFX applikasjon");
        // Viser primaryStage (vinduet). Uten denne vil vi ikke få frem noe på skjermen
        primaryStage.show();
    }

    private void visAlert() {
        // Oppretter og instansierer et Alert objekt, og setter typen til Informasjon (vi får da en OK knapp, samt et ikon med "i" i boksen
        Alert minAlert = new Alert(Alert.AlertType.INFORMATION);
        // Setter tittelen til alertboksen
        minAlert.setTitle("Du vant!");
        // Setter denne til null for å gjøre alertboksen litt ryddigere, hadde vi hatt behov for en header kunne vi satt en tekst her
        minAlert.setHeaderText(null);
        // Setter innholdet i alertboksen, altså teksten som skal vises
        minAlert.setContentText("Gratulerer! Du klarte å trykke " + teller + " ganger.");

        // Setter at alertboksen skal vises, og at vi venter med å kjøre videre i programmet til det er trykket OK eller den er lukket
        minAlert.showAndWait();
    }
}

