package no.hiof.larseknu.dyrehage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Dyr {
    private String navn;
    private final int id;
    private LocalDate fodselsdag;
    private static int dyreTeller;

    public Dyr(String navn) {
        this(navn, LocalDate.EPOCH);
    }

    public Dyr(String navn, LocalDate fodselsdag) {
        this.navn = navn;
        this.id = dyreTeller++;
        this.fodselsdag = fodselsdag;
    }

    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDate getFodselsdag() {
        return fodselsdag;
    }

    public void setFodselsdag(LocalDate fodselsdag) {
        this.fodselsdag = fodselsdag;
    }


}
