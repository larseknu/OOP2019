package no.hiof.larseknu.figurarv;

/**
 * Abstract Klasse som representerer en generisk figur
 * Kan ikke opprettes egne objekter av Figur-klassen (siden den er abstract)
 */
public abstract class Figur implements Tegnbar, Comparable<Figur> {
    private String farge;

    public Figur(String farge) {
        this.farge = farge;
    }

    /**
     * Metode for å regne ut areal,
     * Abstract, så den må Overrides av de klassene som extender Figur
     */
    public abstract double areal();

    /**
     * Metode for å regne ut omkrets,
     * Abstract, så den må Overrides av de klassene som extender Figur
     */
    public abstract double omkrets();

    @Override
    public int compareTo(Figur sammenLigningsFigur) {
        /*
        // Sjekker hvilken figur som er størt ved hjelp av rekke if-else spørringer
        if (this.areal() > sammenLigningsFigur.areal())
            return 1;
        else if (this.areal() < sammenLigningsFigur.areal())
            return -1;
        else {
            if (this.omkrets() > sammenLigningsFigur.omkrets())
                return 1;
            else if (this.omkrets() < sammenLigningsFigur.omkrets())
                return -1;
            else return 0;
        }*/

        // Finner ut hvilket areal som er størst
        // Positiv verdi - denne(this) figuren er størst
        // Negativ verdi - sammenLigningsFigur er størst
        // 0 - de er like store
        int returVerdi = (int) (this.areal() - sammenLigningsFigur.areal());

        // Hvis returVerdi er 0, har de like stort areal, sammenligner derfor omkrets
        if (returVerdi == 0)
            // Finner ut hvilken omkrets som er størst (eller om de er like)
            returVerdi = (int) (this.omkrets() - sammenLigningsFigur.omkrets());

        return returVerdi;
    }

    /**
     * Metode for å sammenligne to figurer
     * Vi kan kalle den direkte med klassen, uten å instansiere ett objekt først, fordi den er statisk
     */
    public static boolean erStorre(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }

    /**
     * Metode for å sammenligne to figurer
     * Denne er ikke statisk, så vi må ha en instans av Figur-klassen for å kunne kalle den
     */
    public boolean erStorreMetodeSomIkkeErStatisk(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }
}
