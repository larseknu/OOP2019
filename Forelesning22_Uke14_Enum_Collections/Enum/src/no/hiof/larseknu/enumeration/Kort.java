package no.hiof.larseknu.enumeration;

public class Kort {
    // Vi lager enum for korttypene
    public enum Korttype { HJERTER, RUTER, KLØVER, SPAR }

    private Korttype korttype;
    private Kortverdi verdi;

    public Kort(Korttype korttype, Kortverdi verdi) {
        this.korttype = korttype;
        this.verdi = verdi;
    }

    public Korttype getKorttype() {
        return korttype;
    }

    public void setKorttype(Korttype korttype) {
        this.korttype = korttype;
    }

    public Kortverdi getVerdi() {
        return verdi;
    }

    public void setVerdi(Kortverdi verdi) {
        this.verdi = verdi;
    }

    @Override
    public String toString() {
        return korttype + " - " + verdi;
    }
}
