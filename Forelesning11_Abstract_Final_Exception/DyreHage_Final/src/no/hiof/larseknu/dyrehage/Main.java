package no.hiof.larseknu.dyrehage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Dyrepark kristiansandDyrepark = new Dyrepark("Kristiansand Dyrepark");

        HonningGrevling honningGrevlingenJon = new HonningGrevling("Jon", LocalDate.of(2013, 3, 2));
        Sjimpanse sjimpansenArne = new Sjimpanse("Arne", 60);

        kristiansandDyrepark.leggTilEttDyrIDyreparken(honningGrevlingenJon);
        kristiansandDyrepark.leggTilEttDyrIDyreparken(sjimpansenArne);

        honningGrevlingenJon.drepteEnSlangeTil();
        sjimpansenArne.setIq(50);

        System.out.println(sjimpansenArne.getId());
    }


}
