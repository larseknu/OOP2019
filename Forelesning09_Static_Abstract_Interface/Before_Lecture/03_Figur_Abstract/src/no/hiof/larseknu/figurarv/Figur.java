package no.hiof.larseknu.figurarv;

/**
 * Klasse som representerer en generisk figur
 */
public class Figur {

    /**
     * Metode for å regne ut areal,
     * legger opp til at denne Overrides av de klassene som extender figur
     */
    public double areal() {
        return 0;
    }

    /**
     * Metode for å regne ut omkrets,
     * legger opp til at denne Overrides av de klassene som extender figur
     */
    public double omkrets() {
        return 0;
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

}
