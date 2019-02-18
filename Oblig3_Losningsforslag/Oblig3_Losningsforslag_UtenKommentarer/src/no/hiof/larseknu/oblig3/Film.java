package no.hiof.larseknu.oblig3;

import java.time.LocalDate;

public class Film extends Produksjon {

    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
    }

    @Override
    public String toString() {
        return getTittel() + (getUtgivelsesdato() != LocalDate.MIN ? " (" + getUtgivelsesdato().getYear() + ")" :"");// + (super.getSpilletid() > 0 ? super.getSpilletid() + " minutter" : "");
    }
}
