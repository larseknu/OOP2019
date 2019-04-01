package no.hiof.larseknu.databasetest;

import java.time.LocalDate;

public class Dyr {
    private int id;
    private String navn, art;
    private LocalDate fodselsDato;

    public Dyr(int id, String navn, String art, LocalDate fodselsDato) {
        this.id = id;
        this.navn = navn;
        this.art = art;
        this.fodselsDato = fodselsDato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public LocalDate getFodselsDato() {
        return fodselsDato;
    }

    public void setFodselsDato(LocalDate fodselsDato) {
        this.fodselsDato = fodselsDato;
    }

    @Override
    public String toString() {
        return "Dyr{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                ", art='" + art + '\'' +
                ", fodselsDato=" + fodselsDato +
                '}';
    }
}
