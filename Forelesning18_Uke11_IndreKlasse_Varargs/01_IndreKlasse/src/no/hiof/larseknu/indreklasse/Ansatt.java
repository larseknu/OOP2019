package no.hiof.larseknu.indreklasse;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Ansatt {
    private String navn;
    private int ansattNummer;

    private ArrayList<Lonnsslipp> lonnsslipper = new ArrayList<>();

    public Ansatt(String navn, int ansattNummer) {
        this.navn = navn;
        this.ansattNummer = ansattNummer;
    }

    // Legger til et lønnsslippobjekt for denne ansatte
    public void leggTilLonnsslipp(String maaned, double brutto, int skatteprosent){
        lonnsslipper.add(new Lonnsslipp(maaned, brutto, skatteprosent));
    }

    // Skriver ut alle lønslipper for denne ansatte
    public void printLonnsslipper(){
        for(Lonnsslipp lonnsslipp: lonnsslipper){
            System.out.println(lonnsslipp);
        }
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getAnsattNummer() {
        return ansattNummer;
    }

    public void setAnsattNummer(int ansattNummer) {
        this.ansattNummer = ansattNummer;
    }

    // indre klasse (kalles også ikke-statisk nestet klasse) for lønsslipp
    // vi kan like godt la Ansattklassen definere Lønslipp internt siden ingen andre
    // deler av systemet skal forholde seg til lønnslipper
    private class Lonnsslipp {
        private String maaned;
        private double brutto;
        private double netto;
        private int skatteprosent;

        // konstruktør for en lønnsslipp
        public Lonnsslipp(String maaned, double brutto, int skatteprosent) {
            this.maaned = maaned;
            this.brutto = brutto;
            this.skatteprosent = skatteprosent;
            // beregner nettolønnen ved å benytte informasjonen om brutto og skatteprosent
            this.netto = brutto - ((brutto / 100) * skatteprosent);
        }

        // overskriver toString så vi får en "fin" utskrift av lønnsslipper
        @Override
        public String toString() {
            return "Lønn for: " + maaned
                    + "\tBrutto: " + brutto
                    + "\tNetto: " + new DecimalFormat("#.##").format(netto);
        }
    }

}

