package no.hiof.larseknu.movietime;

public class Episode {
    private int episodeNummer, sesongNummer;
    private String tittel;
    private int spilletid;

    public Episode(String tittel, int episodeNummer, int sesongNummer) {
        this(tittel, episodeNummer, sesongNummer, 0);
    }

    public Episode(String tittel, int episodeNummer, int sesongNummer, int spilletid) {
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
        this.tittel = tittel;
        this.spilletid = spilletid;
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

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }

    @Override
    public String toString() {
        return "S" + String.format("%02d", sesongNummer) + "E" + String.format("%02d", episodeNummer) + " - " + tittel;
    }
}
