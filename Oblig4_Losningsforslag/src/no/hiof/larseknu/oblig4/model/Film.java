package no.hiof.larseknu.oblig4.model;

import java.time.LocalDate;

public class Film extends Produksjon implements Comparable<Film> {

    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
    }

    public Film() {
        super();
    }

    @Override
    public int compareTo(Film sammenligningsFilm) {
        return getTittel().compareTo(sammenligningsFilm.getTittel());
    }

    @Override
    public String toString() {
        return getTittel() + (getUtgivelsesdato() != LocalDate.MIN ? " (" + getUtgivelsesdato().getYear() + ")" :"");// + (super.getSpilletid() > 0 ? super.getSpilletid() + " minutter" : "");

    }
}
