package no.hiof.larseknu.figurarv;

/**
 * Klasse som representerer en figur av typen Rektangel
 */

// Hvis vi setter denne til final, vil ikke Kvadrat kunne arve fra Rektangel
// public final class Rektangel extends Figur

public class Rektangel extends Figur {
    // Instansvariabler
    private double side1;
    private double side2;

    /**
     * Konstruktør som tar to sider av rektangelet som parametere
     */
    public Rektangel(double side1, double side2, String farge) {
        super(farge);
        this.side1 = side1;
        this.side2 = side2;
    }

    /**
     * Metode for å regne ut areal
     * Overrider denne fra figur og lager vår egen implementasjon som passer for rektangel
     */
    @Override
    public final double areal() {
        return side1 * side2;
    }

    /**
     * Metode for å regne ut omkrets
     * Overrider denne fra figur og lager vår egen implementasjon som passer for rektangel
     */
    @Override
    public double omkrets() {
        return (side1 + side2) * 2;
    }

    /**
     * Metode for å tegne en rektangel
     * Overrider denne fra interfacet "Tegnbar"
     */
    @Override
    public void tegn() {
        System.out.println(" --------");
        System.out.println("|        |");
        System.out.println("|        |");
        System.out.println(" --------");
    }

    /**
     * Metode for å skrive ut det vi mener er mest relevant om et rektangel objekt
     * Overrider denne fra Object-klassen (som alle klasser arver fra)
     */
    @Override
    public String toString() {
        return getFarge() + " Rektangel med sidene: " + side1 + ", " + side2;
    }

}
