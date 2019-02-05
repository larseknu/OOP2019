package no.hiof.larseknu.figurarv;

/**
 * Abstract Klasse som representerer en generisk figur
 * Kan ikke opprettes egne objekter av Figur-klassen (siden den er abstract)
 */
public abstract class Figur implements Tegnbar {
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
