package no.hiof.larseknu.indrecelle.model;

public class Dyr {
    private String navn, art;
    private boolean utryddningsTruet;

    public Dyr(String navn, String art, boolean utryddningsTruet) {
        this.navn = navn;
        this.art = art;
        this.utryddningsTruet = utryddningsTruet;
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

    public boolean isUtryddningsTruet() {
        return utryddningsTruet;
    }

    public void setUtryddningsTruet(boolean utryddningsTruet) {
        this.utryddningsTruet = utryddningsTruet;
    }

    @Override
    public String toString() {
        return navn + " - " + art;
    }
}
