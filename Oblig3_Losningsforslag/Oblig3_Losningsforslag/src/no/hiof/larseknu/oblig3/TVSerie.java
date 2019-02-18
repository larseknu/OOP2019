package no.hiof.larseknu.oblig3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class TVSerie {
    private String tittel, beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList<Episode> episoder;
    private int gjennomSnittligSpilletid, antallSesonger;

    public TVSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        episoder = new ArrayList<>();
        gjennomSnittligSpilletid = 0;
        antallSesonger = 0;
    }

    public void leggTilEpisode(Episode episoden) {
        // Undersøker om episoden sitt sesongNummer er høyere enn antallSesonger pluss 1
        if (episoden.getSesongNummer() <= antallSesonger+1) {
            // Legger til episode til listen
            this.episoder.add(episoden);
            // Oppdaterer gjennomsnittligspilletid
            oppdaterGjennomsnittligSpilletid();

            // Sjekker om episoden sitt sesongNummer er akkurat 1 høyere enn antallSesonger, i så fall, oppdater den
            if (antallSesonger < episoden.getSesongNummer()) {
                antallSesonger = episoden.getSesongNummer();
            }
        }
        else {
            System.out.println("FEIL: Episoden " + episoden + " kan ikke være høyere enn sesong: " + (antallSesonger+1));
        }
    }

    private void oppdaterGjennomsnittligSpilletid() {
        // Lager en variabel for å holde på den totale spilletiden
        int totalSpilleTid = 0;

        // Går gjennom alle episodene til tvserien og legger sammen spilletid til totalSpilletid
        for (Episode episoden : episoder) {
            totalSpilleTid += episoden.getSpilletid();
        }

        // Beregner gjennomsnittligSpilletid, ved å dele den totalespilletiden, på antallet episoder vi har
        gjennomSnittligSpilletid = totalSpilleTid / episoder.size();
    }

    public ArrayList<Episode> hentEpisodeListe() {
        // Vi lager en kopi av listen vi har, slik at den interne listen ikke kan manipuleres direkte utenfor klassen (innkapsling)
        return new ArrayList<>(episoder);
    }

    public ArrayList<Episode> hentEpisoderISesong(int sesongNummer) {
        // Lager og instansierer et ArrayList-objekt som skal holde på alle episodene i sesongen vi har valgt
        ArrayList<Episode> episoderISesong = new ArrayList<>();

        // Går gjennom alle episodene til denne tvserien og sjekker hvilken sesong den tilhører
        for (Episode episoden : episoder) {
            // Sjekker om episoden tilhører sesongen vi ønsker
            if (episoden.getSesongNummer() == sesongNummer)
                // Den gjør det, da legger vi den til i den nye listen vår
                episoderISesong.add(episoden);
        }

        return episoderISesong;
    }

    public ArrayList<Rolle> hentRollebesetning() {
        // Lager en ny rolle som vi skal fylle opp med alle roller som spilles i episodene
        ArrayList<Rolle> rollebesetning = new ArrayList<>();

        // Går gjennom hver enkelt episode i episodelisten
        for (Episode enEpisode : episoder) {
            // Går gjennom hver enkelt rolle som er listet opp i en episode
            for (Rolle enRolle : enEpisode.getRolleListe()) {
                // Undersøker om vi har lagt til akkurat denne rollen i listen før
                if (!rollebesetning.contains(enRolle))
                    // Hvis vi ikke har det, legger vi den til i lista
                    rollebesetning.add(enRolle);
            }
        }

        return rollebesetning;
    }

    // Har løst dette ved hjelp av HashMap fordi dette var en av "bonusoppgavene" har også laget en egen metode som teller antallet for en rolle
    public HashMap<Rolle, Integer> hentRollebesetningMedAntallEpisoderSpilt() {
        // Lager en HashMap som skal holde på en Rolle, og antallet episoder rollen har spilt
        HashMap<Rolle, Integer> rolleBesetning = new HashMap<>();

        // Går gjennom hver enkelt episode i episodelisten
        for (Episode enEpisode : episoder) {
            // Går gjennom hver enkelt rolle som er listet opp i en episode
            for (Rolle enRolle : enEpisode.getRolleListe()) {
                // Undersøker om vi har lagt til denne rollen før
                if (rolleBesetning.containsKey(enRolle)) {
                    // Hvis vi har det, henter vi ut antallet episoder rollen har vært i
                    Integer antallSpilt = rolleBesetning.get(enRolle);
                    // Vi erstatter så antalletspiltverdien med den gamle verdien + 1
                    rolleBesetning.replace(enRolle, ++antallSpilt);
                }
                else {
                    // Hvis vi ikke har den fra før, legg den til og sett antallet episoder spilt til 1
                    rolleBesetning.put(enRolle, 1);
                }
            }
        }

        return rolleBesetning;
    }

    public int hentAntalletEpisoderEnRolleHarSpilt(Rolle enRolle) {
        int antallGangerSpilt = 0;

        // Går gjennom hver enkelt episode i episodelisten
        for (Episode enEpisode : episoder) {
            // Sjekker om rollen finnes i rollelisten for denne episoden
            if (enEpisode.getRolleListe().contains(enRolle)) {
                // Hvis den gjør det plusser vi på antallGangerSpilt med 1
                antallGangerSpilt++;
            }
        }

        return antallGangerSpilt;
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

    public int getGjennomSnittligSpilletid() {
        return gjennomSnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    @Override
    public String toString() {
        return tittel + " - " + utgivelsesdato.getYear();
    }
}
