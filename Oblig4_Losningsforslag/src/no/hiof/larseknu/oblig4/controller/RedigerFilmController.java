package no.hiof.larseknu.oblig4.controller;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import no.hiof.larseknu.oblig4.model.Film;

import java.time.LocalDate;

public class RedigerFilmController {
    // Alle feltvariablene for komponenter definert i tilhørende .fxml
    @FXML
    private TextField tittelTextField, spilletidTextField;
    @FXML
    private TextArea beskrivelseTextArea;
    @FXML
    private Label feilmeldingLabel;
    @FXML
    private DatePicker utgivelsesdatoDatePicker;
    @FXML
    private Button okButton;

    // Feltvariabler som tilhører RedigerFilmController, som ikke finnes i FXML fil
    private Stage dialogStage;
    // Filmen vi skal redigere
    private Film filmSomRedigeres;
    private boolean okClicked = false;

    // Metode initialize som blir kalt etter at den tilhørende fxml'en er lastet inn
    @FXML
    private void initialize() {
        // Setter at okButton skal være "hovedknappen", dette gjør at den blir "kalt" når vi trykker ENTER
        okButton.setDefaultButton(true);
    }

    public void setFilmSomSkalRedigeres(Film filmSomRedigeres) {
        // Setter hvilken film som skal redigeres
        this.filmSomRedigeres = filmSomRedigeres;

        // Sjekker om film har en verdi, eller er null,
        // har den en verdi skal den redigeres og vi fyller inn data fra den
        if (filmSomRedigeres != null) {
            tittelTextField.setText(filmSomRedigeres.getTittel());
            beskrivelseTextArea.setText(filmSomRedigeres.getBeskrivelse());
            if (!filmSomRedigeres.getUtgivelsesdato().equals(LocalDate.MIN))
                utgivelsesdatoDatePicker.setValue(filmSomRedigeres.getUtgivelsesdato());
            spilletidTextField.setText(String.valueOf(filmSomRedigeres.getSpilletid()));
        }
    }

    @FXML
    private void okValgt() {
        // Sjekker om inputfeltene er gyldige
        if (sjekkOmInputErGyldig()) {
            // Hvis de er det, fyller vi opp filmobjektet vårt med den nye dataen fra feltene
            filmSomRedigeres.setTittel(tittelTextField.getText());
            filmSomRedigeres.setBeskrivelse(beskrivelseTextArea.getText());
            if (utgivelsesdatoDatePicker.getValue() != null)
                filmSomRedigeres.setUtgivelsesdato(utgivelsesdatoDatePicker.getValue());
            filmSomRedigeres.setSpilletid(Integer.parseInt(spilletidTextField.getText()));

            // Setter at vi avsluttet ved å trykke OK
            okClicked = true;

            // Henter ut en referanse til Stage (vinduet) ved hjelp av en av komponentene vi har i grensesnittet
            dialogStage = (Stage)okButton.getScene().getWindow();
            // Lukker vinduet
            dialogStage.close();
        }
    }

    @FXML
    private void avbrytValgt() {
        // Henter ut en referanse til Stage (vinduet) ved hjelp av en av komponentene vi har i grensesnittet
        dialogStage = (Stage)okButton.getScene().getWindow();
        // Lukker vinduet uten å gjøre noe mer (okClicked er fortsatt false)
        dialogStage.close();
    }


    public boolean erOkValgt() {
        // Mulighet til å hente ut om vi avsluttet ved hjelp av OK eller ikke
        return okClicked;
    }

    private boolean sjekkOmInputErGyldig() {
        // Lager en string vi fyller opp med feilmeldinger for visning til brukeren
        String feilmelding = "";

        // Sjekker om det er noe innhold i titteltekstfeltet (en film MÅ ha en tittel)
        if (tittelTextField.getText() == null || tittelTextField.getText().length() == 0) {
            // Hvis det ikke var satt noen tittel, legg til feilmelding
            feilmelding += "Tittel må settes!\n";
        }
        // Prøver å parse spilletid fra String til int
        try {
            Integer.parseInt(spilletidTextField.getText());
        }
        catch (NumberFormatException exception) {
            // Hvis det var en ugyldig string legg til feilmelding
            feilmelding += "Spilletid er ikke et gyldig tall!\n";
        }

        // Sjekker om vi har noen feilmelding eller ikke
        if (feilmelding.length() == 0) {
            // Returner true, som i at vi ikke har noen feilmeldinger og all input er gyldig
            return true;
        }
        else {
            // Skriv info til feilmeldingslabel som blir vist til brukeren
            feilmeldingLabel.setText("Vennligs rett følgende feil:\n" + feilmelding);
            // Returner false, som sier at input ikke er gyldig
            return false;
        }
    }

}

