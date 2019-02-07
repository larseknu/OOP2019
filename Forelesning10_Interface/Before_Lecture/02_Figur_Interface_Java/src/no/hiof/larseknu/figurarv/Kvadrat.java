package no.hiof.larseknu.figurarv;

/**
 * Klasse som representerer en rektangel av typen Kvadrat
 */
public class Kvadrat extends Rektangel {
    private double side;

    /**
     * Kunstruktør som tar en side av kvadratet som parameter
     */
    public Kvadrat(double side, String farge) {
        // Kaller konstruktøren til superklassen (Rektangel)
        super(side, side, farge);

        this.side = side;
    }

    /**
     * Metode for å tegne en kvadrat
     * Overrider denne fra rektangel
     */
    @Override
    public void tegn() {
        System.out.println(" ---");
        System.out.println("|   |");
        System.out.println(" ---");
    }

    /**
     * Metode for å skrive ut det vi mener er mest relevant om et kvadrat objekt
     */
    @Override
    public String toString() {
        return "Kvadrat med side " + side;
    }
}
