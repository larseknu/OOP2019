package no.hiof.larseknu.flyoversikt;
/**
 * Representerer et fly
 */
public class Fly {
    // Instansvariabler
    private String modell;
    private int seter;
    private int passasjerer;
    // Klassevariabel
    private static int totaltAntallPassasjerer;

    /**
     * Tom kontruktør
     */
    public Fly() {
    }

    /**
     * Konstruktør for klassen Fly
     * Gir mulighet til å sette modell og antall seter
     * Antall passasjerer blir satt til 0
     */
    public Fly (String modell, int seter) {
        this.modell = modell;
        this.seter = seter;
        this.passasjerer = 0;
    }

    /**
     * Konstruktør for klassen Fly
     * Gir mulighet til å sette modell, antall seter og antall passasjerer
     */
    public Fly (String modell, int seter, int passasjerer) {
        this.modell = modell;
        this.seter = seter;
        this.passasjerer = passasjerer;
        totaltAntallPassasjerer += passasjerer;
    }

    /**
     * Metode for å legge til en passasjer hvis det er et sete ledig.
     * Er flyet fullt skrives en melding ut til terminalen.
     */
    public void leggTilEnPassasjer() {
        // Sjekker om antallet passasjerer er mindre enn antallet seter
        if (passasjerer < seter) {
            // Hvis det er mindre, legg til en passasjer
            passasjerer++;
            // Øker klassevariabelen totaltAntallPassasjerer som tilhører selve klassen med 1
            totaltAntallPassasjerer++;
        }
        else
            // Hvis det ikke er ledige seter, skriv ut melding
            System.out.println("Ingen ledige seter tilgjengelig");
    }

    /**
     * Statisk metode for å hente det totale antallet passasjerer
     * Vi trenger altså ikke en instans av klassen (ett spesifikt fly) for å kunne hente denne
     */
    public static int getTotaltAntallPassasjerer() {
        return totaltAntallPassasjerer;
    }

    public String getModell() {
        return modell;
    }

    public int getPassasjerer() {
        return passasjerer;
    }

    public int getSeter() {
        return seter;
    }

    @Override
    public String toString() {
        return "Flyet " + modell + " har " + seter + " seter og " + passasjerer + " passasjerer.";
    }
}