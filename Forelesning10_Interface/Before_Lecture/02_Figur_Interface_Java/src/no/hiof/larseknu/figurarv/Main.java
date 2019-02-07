package no.hiof.larseknu.figurarv;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Rektangel rektangelet = new Rektangel(4, 5, "Grønn");

        Sirkel sirkelen = new Sirkel(3, "Rød");

        Kvadrat kvadrat = new Kvadrat(10, "Blå");


        System.out.println(rektangelet + " Areal: " + rektangelet.areal() + " Omkrets: " + rektangelet.omkrets());
        // String.format() gjør det her mulig å runde av double-verdien til å kun vise 2 desimaler
        System.out.println(sirkelen + " Areal: " + String.format("%.2f", sirkelen.areal()) + " Omkrets: " + String.format("%.2f", sirkelen.omkrets()));


        // "Tegner" de forskjellige figurene
        rektangelet.tegn();
        sirkelen.tegn();
        kvadrat.tegn();
    }
}
