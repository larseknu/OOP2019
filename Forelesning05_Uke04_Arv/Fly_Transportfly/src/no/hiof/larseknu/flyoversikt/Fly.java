package no.hiof.larseknu.flyoversikt;

public class Fly {
    private String modell;
    private int seter;
    private int passasjerer;

    public Fly() {
        seter = 150;
        passasjerer = 0;
    }

    public Fly (String modell, int seter) {
        this.modell = modell;
        this.seter = seter;
        passasjerer = 0;
    }

    public Fly (String modell, int seter, int passasjerer) {
        this.modell = modell;
        this.seter = seter;
        this.passasjerer = passasjerer;
    }

    public void leggTilEnPassasjer() {
        if (passasjerer < seter) {
            passasjerer++;
        }
        else
            System.out.println("Ingen ledige seter tilgjengelig");
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
}
