package no.hiof.larseknu.oblig4.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import no.hiof.larseknu.oblig4.MainJavaFX;
import no.hiof.larseknu.oblig4.data.DataHandler;
import no.hiof.larseknu.oblig4.model.Film;

import java.time.LocalDate;
import java.util.Optional;

public class FilmController {
    // Alle feltvariablene for komponenter definert i tilhørende .fxml
    @FXML
    private ListView<Film> filmListView;
    @FXML
    private Text tittelText;
    @FXML
    private TextField utgivelsesdatoTextField, spilletidTextField;
    @FXML
    private TextArea beskrivelseTextArea;
    @FXML
    private Button redigerButton;

    // Metode initialize som blir kalt når vi laster inn den tilhørende fxml'en
    // Den blir teknisk sett kjørt etter kontruktøren, og det er garantert at alle komponenter er opprettet
    // i.e. alle knapper, tekstområder etc. slik at vi kan gjøre noe med de
    @FXML
    private void initialize() {
        filmListView.setItems(DataHandler.hentFilmData());

        redigerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Henter ut en referanse til filmen som er valgt, og som skal redigeres
                Film filmSomSkalRedigeres = filmListView.getSelectionModel().getSelectedItem();

                if (filmSomSkalRedigeres != null) {
                    // Viser det nye vinduet, og sender filmen som skal redigeres, får tilbake true/false avhengig av hvordan det gikk
                    boolean filmRedigert = MainJavaFX.getInstance().visRedigerFilmDialog(filmSomSkalRedigeres);

                    if (filmRedigert) {
                        // (liten hack for å få ListViewet til å oppdatere seg med ny tittel)
                        // Setter første elementet til valgt, før den som ble redigert
                        filmListView.getSelectionModel().selectFirst();
                        // Setter filmen som er redigert til å være valgt
                        filmListView.getSelectionModel().select(filmSomSkalRedigeres);
                        oppdaterFilmDetaljer(filmSomSkalRedigeres);
                    }
                }
                // Hvis ikke viser vi en liten alert melding om at film må velges
                else {
                    Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
                    alertDialog.setTitle("Ingen film valgt");
                    alertDialog.setHeaderText("Vennligst velg en film");
                    alertDialog.showAndWait();
                }
            }
        });

        // Legger til lytter på hvert element i ListView'et, så vi får beskjed når noe er endret, eller valgt
        filmListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
            @Override
            public void changed(ObservableValue<? extends Film> observableValue, Film gammelFilm, Film nyFilm) {
                // Oppdaterer den detaljerte visningen av en film
                oppdaterFilmDetaljer(nyFilm);
            }
        });

        // Velger første element i lista, slik at det er valgt når vi starter programmet
        filmListView.getSelectionModel().selectFirst();
    }

    private void oppdaterFilmDetaljer(Film enFilm) {
        // Sjekker om filmen vi får inn, ikke er null
        if (enFilm != null) {
            // Setter filmtittelen til titteltekstfeltet
            tittelText.setText(enFilm.getTittel());
            // Setter beskrivelsen til beskrivelsetekstfeltet
            beskrivelseTextArea.setText(enFilm.getBeskrivelse());
            // Sjekker om filmens utgivelsesdato er MIN
            // Hvis den ikke er det, legger vi utgivelsesdatoen til i tekstfeltet
            // Hvis den er MIN, setter vi tekstfeltet til å være tomt
            utgivelsesdatoTextField.setText(enFilm.getUtgivelsesdato() != LocalDate.MIN ? enFilm.getUtgivelsesdato().toString() : "");

            // Undersøker om spilletid er høyere enn 0
            // Er den det legger vi spilletiden + minutter til tekstfeltet
            // Hvis den er 0 (eller teknisk sett lavere), setter vi tekstfeltet til å være tomt
            spilletidTextField.setText(enFilm.getSpilletid() > 0 ? enFilm.getSpilletid() + " minutter" : "");
        }
    }

    public void nyButtonClicked(ActionEvent actionEvent) {
        // Oppretter og instansierer et nytt filmobjekt
        Film nyFilm = new Film();

        // Viser det nye vinduet, og sender objektet inn for å fylles med data, får tilbake true/false avhengig av hvordan det gikk
        boolean nyFilmLagetVellyket = MainJavaFX.getInstance().visRedigerFilmDialog(nyFilm);

        // Sjekker om den nye filmen ble laget
        if (nyFilmLagetVellyket) {
            // Henter ut lista med filmer, og legger til den nye filmen som ble laget
            DataHandler.hentFilmData().add(nyFilm);
            // Setter at den nye filmen er valgt
            filmListView.getSelectionModel().select(nyFilm);
        }
    }

    @FXML
    public void slettButtonClicked(ActionEvent actionEvent) {
        // Henter ut filmen som er valgt, som er den som skal slettes
        Film enFilm = filmListView.getSelectionModel().getSelectedItem();

        // Sjekker om det faktisk er valgt en film, eller om den er null
        if (enFilm != null) {
            // Viser en dialog om brukeren er helt sikker på at han ønsker å slette filmen
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Slette film");
            alert.setHeaderText(null);
            alert.setContentText("Er du sikker på at du ønsker å slette filmen " + enFilm.getTittel() + "?");

            // Viser boksen og får tilbake hvilken knapp som er trykket på
            Optional<ButtonType> result = alert.showAndWait();
            // Sjekker om OK ble trykket på
            if (result.orElse(ButtonType.OK) == ButtonType.OK){
                // Vi tømmer informasjonsfeltet (det kan være siste filmen vi sletter, slik at vi ikke har noen ny å vise)
                tomFilmInfo();
                // Velger filmen som var før i lista
                filmListView.getSelectionModel().selectPrevious();
                // Henter ut lista med filmer og tar bort den valgte filmen
                DataHandler.hentFilmData().remove(enFilm);
            }
        }
    }

    // Setter alle tekstfeltene til å være tomme
    private void tomFilmInfo() {
        tittelText.setText("");
        beskrivelseTextArea.setText("");
        utgivelsesdatoTextField.setText("");
        spilletidTextField.setText("");
    }
}
