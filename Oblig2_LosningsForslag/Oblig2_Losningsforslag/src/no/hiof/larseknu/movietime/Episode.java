package no.hiof.larseknu.movietime;

public class Episode {
    // Instansvariabler
    private int episodeNummer, sesongNummer;
    private String tittel;
    private int spilletid;

    /**
     * Konstruktør for Episode
     * @param tittel - tittelen til episoden
     * @param episodeNummer - episodenummeret til episoden (i denne sesongen)
     * @param sesongNummer - sesongnummeret til episoden
     */
    public Episode(String tittel, int episodeNummer, int sesongNummer) {
        // Kaller den andre konstruktøren, sender parameterne videre, men setter spilletid til 0
        this(tittel, episodeNummer, sesongNummer, 0);
    }

    /**
     * Konstruktør for Episode
     * @param tittel - tittelen til episoden
     * @param episodeNummer - episodenummeret til episoden (i denne sesongen)
     * @param sesongNummer - sesongnummeret til episoden
     * @param spilletid - spilletid i minutter
     */
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

    /**
     * Genererer en string for Episode
     * @return String i formen "S01E03 - NavnPåEpisode"
     */
    @Override
    public String toString() {
        // String format legger her bare på 0 foran, slik at vi f.eks. får det på formatet 03 fremfor bare 3
        return "S" + String.format("%02d", sesongNummer) + "E" + String.format("%02d", episodeNummer) + " - " + tittel;
    }
}
