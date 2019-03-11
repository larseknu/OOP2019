package no.hiof.larseknu.oblig4.model;

import java.time.LocalDate;

public class Episode extends Produksjon implements Comparable<Episode> {
    private int episodeNummer, sesongNummer;

    public Episode(String tittel, int episodeNummer, int sesongNummer) {
        this(tittel, "", episodeNummer, sesongNummer, 0, LocalDate.MIN, new Person("Unknown", "Unknown"));
    }

    public Episode(String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelsesdato, Person regissor) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }

    @Override
    public int compareTo(Episode sammenlingingsEpisode) {
        if (this.sesongNummer == sammenlingingsEpisode.getSesongNummer()) {
            return this.episodeNummer - sammenlingingsEpisode.getEpisodeNummer();
        }
        else {
            return this.sesongNummer - sammenlingingsEpisode.getSesongNummer();
        }
    }

    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public void setEpisodeNummer(int episodeNummer) {
        this.episodeNummer = episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }

    public void setSesongNummer(int sesongNummer) {
        this.sesongNummer = sesongNummer;
    }

    @Override
    public String toString() {
        return "E" + String.format("%02d", episodeNummer) + "S" + String.format("%02d", sesongNummer) + " - " + super.getTittel() + " - " + super.getSpilletid() + "min";
    }
}
