package no.hiof.larseknu.oblig4.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TVSerie implements Comparable<TVSerie> {
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
        if (episoden.getSesongNummer() <= antallSesonger+1) {
            this.episoder.add(episoden);
            oppdaterGjennomsnittligSpilletid();

            if (antallSesonger < episoden.getSesongNummer()) {
                antallSesonger = episoden.getSesongNummer();
            }
        }
        else {
            System.out.println("FEIL: Episoden " + episoden + " kan ikke være høyere enn sesong: " + (antallSesonger+1));
        }
    }

    private void oppdaterGjennomsnittligSpilletid() {
        int totalSpilleTid = 0;

        for (Episode episoden : episoder) {
            totalSpilleTid += episoden.getSpilletid();
        }

        gjennomSnittligSpilletid = totalSpilleTid / episoder.size();
    }

    public ArrayList<Episode> hentEpisoderISesong(int sesongNummer) {
        ArrayList<Episode> episoderISesong = new ArrayList<>();

        for (Episode episoden : episoder) {
            if (episoden.getSesongNummer() == sesongNummer)
                episoderISesong.add(episoden);
        }

        return episoderISesong;
    }

    public ArrayList<Rolle> hentRollebesetning() {
        ArrayList<Rolle> rollebesetning = new ArrayList<>();

        for (Episode enEpisode : episoder) {
            for (Rolle enRolle : enEpisode.getRolleListe()) {
                if (!rollebesetning.contains(enRolle))
                    rollebesetning.add(enRolle);
            }
        }

        return rollebesetning;
    }

    public HashMap<Rolle, Integer> hentRollebesetningMedAntallEpisoderSpilt() {
        HashMap<Rolle, Integer> rolleBesetning = new HashMap<>();

        for (Episode enEpisode : episoder) {
            for (Rolle enRolle : enEpisode.getRolleListe()) {
                if (rolleBesetning.containsKey(enRolle)) {
                    Integer antallSpilt = rolleBesetning.get(enRolle);
                    rolleBesetning.replace(enRolle, ++antallSpilt);
                }
                else {
                    rolleBesetning.put(enRolle, 1);
                }
            }
        }

        return rolleBesetning;
    }

    public int hentAntalletEpisoderEnRolleHarSpilt(Rolle enRolle) {
        int antallGangerSpilt = 0;

        for (Episode enEpisode : episoder) {
            if (enEpisode.getRolleListe().contains(enRolle)) {
                antallGangerSpilt++;
            }
        }

        return antallGangerSpilt;
    }

    @Override
    public int compareTo(TVSerie sammenligningsTvSerie) {
        return getTittel().compareTo(sammenligningsTvSerie.getTittel());
    }

    public ArrayList<Episode> getEpisoder() {
        ArrayList<Episode> kopiAvEpisoder = new ArrayList<>(episoder);
        Collections.sort(kopiAvEpisoder);
        return kopiAvEpisoder;
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
