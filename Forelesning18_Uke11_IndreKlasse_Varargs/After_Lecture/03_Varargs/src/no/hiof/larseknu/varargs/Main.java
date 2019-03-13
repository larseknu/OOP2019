package no.hiof.larseknu.varargs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Kaller summer-metode med 2 argumenter
        System.out.println(summer(5, 6));
        // Kaller summer-metode med 3 argumenter
        System.out.println(summer(5, 6, 6));
        // Kaller summer-metode med ukjent antall int-verdier (når vi kommer over 3)
        System.out.println(summer(5, 6, 6, 6));
        // Kaller doMath-matode som først tar en string, så et ukjent antall int-verdier
        System.out.println(doMath("-", 5, 6, 6, 6));


        // Sjekker om et tilfeldig tall vi generer er over eller under ti ved hjelp av en "hurtig-if)
        String tall = (10 < new Random().nextInt() ? "over ti" : "under ti");

        // Kaller string-format med forskjellige typer argumenter
        // Argumentene etter den første stringen blir lagt inn der vi har satt specifiers (%s, %d) etc.
        System.out.println(String.format("Dette er en %s med mange argumenter %tY + %d, %s",
                "string", LocalDate.of(2016, 2, 2), 2, tall));

        // En litt enklere versjon
        // Argumentene etter den første stringen blir lagt inn der vi har satt specifiers (%s, %d) etc.
        System.out.println(String.format("Dette er en %s som tar varargs %d, %d", "string", 42, 9001));
    }

    // Summer-metode som tar to int verdier
    public static int summer(int a, int b) {
        return summer(a, b, 0);
    }

    // Summer-metode som tar tre int verdier
    public static int summer(int a, int b, int c) {
        return a + b + c;
    }

    // Summer-metode som tar et ukjent antall int-verdier
    public static int summer(int... tall) {
        int sum = 0;

        for (int etTall : tall) {
            sum += etTall;
        }

        return sum;
    }

    // doMath metode som først tar matteOperasjon som vil si + - etc., for så et ukjent antall int-verdier
    public static int doMath(String matteOperasjon, int... tall) {
        // Sjekker hva vi skal gjøre, summere eller substrahere
        switch (matteOperasjon) {
            case "+":
                // bruker summer-metoden vi allerede har
                return summer(tall);
            case "-":
                int sum = 0;
                for (int etTall : tall)
                    sum -= etTall;
                return sum;
        }

        return 0;
    }
}

