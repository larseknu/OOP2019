package no.hiof.larseknu.enumeration;

// Vi lagrer også korteneverdiene i enum verdier
// Her er de også tillagt en spesifikk tallverdi
// Man kan ikke opprette nye kortverdier selv om vi har en konstruktør, vi er "låst" til de som defineres her
public enum Kortverdi {
    TO(2), TRE(3), FIRE(4), FEM(5), SEKS(6), SYV(7), ÅTTE(8), NI(9), TI(10), KNEKT(11), DAME(12), KONGE(13), ESS(14);

    // Tihørende variabler bør være final
    private final int tallverdi;

    Kortverdi(int tallverdi) {
        this.tallverdi = tallverdi;
    }

    public int getTallverdi() {
        return tallverdi;
    }

    @Override
    public String toString() {
        return name() + " " + tallverdi;
    }
}
