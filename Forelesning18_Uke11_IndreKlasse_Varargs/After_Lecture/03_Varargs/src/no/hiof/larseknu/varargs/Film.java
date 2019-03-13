package no.hiof.larseknu.varargs;

import java.time.LocalDate;

public class Film {
    private String navn;
    private LocalDate dato;

    public Film(String navn) {
        this(navn, LocalDate.MIN);
    }

    public Film(String navn, LocalDate dato) {
        this.navn = navn;
        this.dato = dato;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }
}
