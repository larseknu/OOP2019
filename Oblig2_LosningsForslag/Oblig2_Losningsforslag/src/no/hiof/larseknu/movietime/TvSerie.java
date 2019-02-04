package no.hiof.larseknu.movietime;

import java.time.LocalDate;
import java.util.ArrayList;

public class TvSerie {
    // Instansvariabler
    private String tittel, beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList<Episode> episodeListe = new ArrayList<>();
    private int gjennomSnittligSpilletid, antallSesonger;

    /**
     * Konstruktør for TvSerie
     * @param tittel - Tittelen til tvserien
     * @param beskrivelse - beskrivelse av tvserien
     * @param utgivelsesdato - datoen tvserien ble utgitt/startet
     */
    public TvSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
    }

    /**
     * Legger til en episode i listen over episoder tilhørende denne TvSerien.
     * Vil bare legge til episoder som er innenfor registrerte sesonger, eller 1 høyere
     * @param episoden Episoden vi skal legge til i TvSerien
     */
    public void leggTilEpisode(Episode episoden) {
        // Undersøker om episoden sitt sesongNummer er mindre, lik, eller akkurat én høyere enn antallet sesonger
        if (episoden.getSesongNummer() <= antallSesonger+1) {
            // Legger til episoden i listen
            episodeListe.add(episoden);
            // Oppdaterer gjennomsnittlig spilletid
            oppdaterGjennomsnittligSpilletid();

            // Sjekker om episoden sitt sesongNummer er akkurat 1 høyere enn antallSesonger, i så fall, oppdater den
            if (antallSesonger < episoden.getSesongNummer()) {
                antallSesonger = episoden.getSesongNummer();
            }
        }
        else {
            System.out.println("FEIL: Episoden \"" + episoden + "\" kan ikke være høyere enn sesong: " + (antallSesonger+1));
        }
    }

    /**
     * Henter ut en liste med episodene for en sesong
     * @param sesongNummer Sesongen man ønsker episoder fra
     * @return Liste med episodene i valgt sesong
     */
    public ArrayList<Episode> hentEpisoderISesong(int sesongNummer) {
        // Lager og instansierer et ArrayList-objekt som skal holde på alle episodene i sesongen vi har valgt
        ArrayList<Episode> episoderISesong = new ArrayList<>();

        // Går gjennom alle episodene til denne tvserien og sjekker hvilken sesong den tilhører
        for (Episode episode : episodeListe) {
            // Sjekker om episoden tilhører sesongen vi ønsker
            if (episode.getSesongNummer() == sesongNummer) {
                // Den gjør det, da legger vi den til i den nye listen vår
                episoderISesong.add(episode);
            }
        }

        // Returnerer listen med alle episoder i sesongen som ble valgt
        return episoderISesong;
    }

    /**
     * Oppdaterer gjennomsnittlig spilletid for alle episodene i TvSerien
     */
    private void oppdaterGjennomsnittligSpilletid() {
        // Lager en variabel for å holde på den totale spilletiden
        int totalSpilletid = 0;

        // Går gjennom alle episodene til tvserien og legger sammen spilletid til totalSpilletid
        for (Episode episode : episodeListe) {
            totalSpilletid += episode.getSpilletid();
        }

        // Beregner gjennomsnittligSpilletid, ved å dele den totalespilletiden, på antallet episoder vi har
        gjennomSnittligSpilletid = totalSpilletid / episodeListe.size();
    }
    
    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    /**
     * Henter en liste med alle episodene for TvSerien
     * @return Liste med alle episodene
     */
    public ArrayList<Episode> getEpisodeListe() {
        // Vi lager en kopi av listen vi har, slik at den interne listen ikke kan manipuleres direkte utenfor klassen (innkapsling)
        return new ArrayList<>(episodeListe);
    }

    public int getGjennomSnittligSpilletid() {
        return gjennomSnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    /**
     * Genererer en string for TvSerie
     * @return String i formen "TvSerieTittel - 2017"
     */
    @Override
    public String toString() {
        return tittel + " - " + utgivelsesdato.getYear();
    }
}