package no.hiof.larseknu.oblig3;

import java.time.LocalDate;

// En Episode "er en" produksjon, så derfor har vi satt at den extender Produksjon
// Vi får dermed med alle egenskapene fra Produksjon "gratis"
public class Episode extends Produksjon {
    private int episodeNummer, sesongNummer;

    public Episode(String tittel, int episodeNummer, int sesongNummer) {
        this(tittel, "", episodeNummer, sesongNummer, 0, LocalDate.MIN, new Person("Unknown", "Unknown"));
    }

    public Episode(String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelsesdato, Person regissor) {
        // Kaller superkontruktøren (som tilhører Produksjon), vi "sender" da tittel, beskrivelse, spilletid, utgivelsesdato og regisor videre
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
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
