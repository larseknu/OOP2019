package no.hiof.larseknu.dyrehage;

import java.time.LocalDate;

public class Sjimpanse extends Dyr {
    private int iq;

    public Sjimpanse(String navn, int iq) {
        super(navn);
        this.iq = iq;
    }

    public Sjimpanse(String navn, LocalDate fodselsdag, int iq) {
        super(navn, fodselsdag);
        this.iq = iq;
    }

    @Override
    public int getId() {
        return 8787;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
