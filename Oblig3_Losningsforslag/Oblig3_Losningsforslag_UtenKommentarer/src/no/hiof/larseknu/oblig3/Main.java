package no.hiof.larseknu.oblig3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        lagOgSkrivUtInformasjonOmStrangerThings();

        lagOgSkrivUtInformasjonOmEtParFilmer();

        lagOgSkrivUtInformasjonOmDaysOfOurLives();
    }

    public static void lagOgSkrivUtInformasjonOmStrangerThings() {
        TVSerie strangerThings = new TVSerie("Stranger Things",
                "Når en ung gutt forsvinner, avdekker en liten by et mysterium som involverer hemmelige eksperimenter, skremmende, overnaturlige krefter, samt ei merkverdig, lita jente.",
                LocalDate.of(2016,6,15));

        Person mattDufferRegissor = new Person("Matt", "Duffer");
        Rolle joyceByers = new Rolle("Joyce", "Byers", new Person("Fiona", "Ryder"));
        Rolle jimHopper = new Rolle("Jim", "Hopper", new Person("David", "Harbour"));
        Rolle mikeWheeler = new Rolle("Mike", "Wheeler", new Person("Finn", "Wolfhard"));
        Rolle eleven = new Rolle("Eleven", "", new Person("Millie", "Bobby Brown"));

        ArrayList<Rolle> fullCast = new ArrayList<>(List.of(joyceByers, jimHopper, mikeWheeler, eleven));
        ArrayList<Rolle> coreCast = new ArrayList<>(List.of(mikeWheeler, eleven));

        Episode e1s1 = new Episode("Chapter One: The Vanishing of Will Byers", "Beskrivelse...", 1, 1, 47, LocalDate.of(2016, 7, 15), mattDufferRegissor);
        Episode e2s1 = new Episode("Chapter Two: The Weirdo on Maple Street", "Beskrivelse...", 2, 1, 55, LocalDate.of(2016, 7, 15), mattDufferRegissor);
        Episode e3s1 = new Episode("Chapter Three: Holly Jolly", "Beskrivelse...", 3, 1, 51, LocalDate.of(2016, 7, 15), mattDufferRegissor);
        Episode e4s1 = new Episode("Chapter Four: The Body", "Beskrivelse...", 4, 1, 47, LocalDate.of(2016, 7, 15), mattDufferRegissor);

        e1s1.leggTilFlereRoller(coreCast);
        e2s1.leggTilFlereRoller(coreCast);
        e3s1.leggTilFlereRoller(fullCast);
        e4s1.leggTilFlereRoller(fullCast);

        // Legger til episodene i TVSerien
        strangerThings.leggTilEpisode(e1s1);
        strangerThings.leggTilEpisode(e2s1);
        strangerThings.leggTilEpisode(e3s1);
        strangerThings.leggTilEpisode(e4s1);

        Random randomTallGenerator = new Random();

        // Genererer episoder
        for (int sesongNummmer = 2; sesongNummmer < 5; sesongNummmer++) {
            for (int episodeNummer = 1; episodeNummer <= 20; episodeNummer++) {
                strangerThings.leggTilEpisode(new Episode("Generisk Tittel", "Noe skjer...", episodeNummer, sesongNummmer, randomTallGenerator.nextInt(11)+20, LocalDate.now(), mattDufferRegissor));
            }
        }

        System.out.println("**************************");
        System.out.println("* " + strangerThings + " *");
        System.out.println("**************************");
        System.out.println("**** Spilletid: " + strangerThings.getGjennomSnittligSpilletid() + "min ****");
        System.out.println("**************************");
        System.out.println("-------Episoder S04-------");

        for (Episode enEpisode : strangerThings.hentEpisoderISesong(4)) {
            System.out.println(enEpisode);
        }

        System.out.println("*****************************");

        strangerThings.leggTilEpisode(new Episode("Chapter TwoHundred: The Other Side", 1, 10));

        System.out.println("-------Rollebesetning--------");
        for (Rolle enRolle : strangerThings.hentRollebesetning()) {
            System.out.println(enRolle);
        }
        System.out.println("---Rollebesetning og antall---");
        for (Map.Entry<Rolle, Integer> rolleSpilt : strangerThings.hentRollebesetningMedAntallEpisoderSpilt().entrySet()) {
            System.out.println(rolleSpilt.getKey().getSkuespiller() + " har spilt i " + rolleSpilt.getValue() + " episoder");
        }
        System.out.println("******************************");
    }

    public static void lagOgSkrivUtInformasjonOmEtParFilmer() {

        Rolle ironMan = new Rolle("Iron", "Man", new Person("Robert", "Downey Jr."));
        Rolle thor = new Rolle("Thor", "", new Person("Chris", "Evans"));

        Film avengers = new Film("The Avengers",
                "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity." ,
                143,
                LocalDate.of(2012, 4, 27),
                new Person("Josh", "Whedon", LocalDate.of(1964, 6, 23)));

        avengers.leggTilEnRolle(ironMan);
        avengers.leggTilEnRolle(thor);

        Film birdBox = new Film("Bird Box",
                "Five years after an ominous unseen presence drives most of society to suicide, a mother and her two children make a desperate bid to reach safety.",
                124,
                LocalDate.of(2018, 12, 21),
                new Person("Susanne", "Bier", LocalDate.of(1960, 4, 15)));

        ArrayList<Rolle> avengersRoller = avengers.getRolleListe();

        System.out.println("--------------------------");
        System.out.println("*******"+avengers.getTittel()+"*******");
        System.out.println("*"+"Regissert av " + avengers.getRegissor().getFornavn() + " " + avengers.getRegissor().getEtternavn() +"*");
        System.out.println("*****Rollebesetning*******");
        for (Rolle enRolle : avengersRoller)
            System.out.println(enRolle);

        System.out.println("**************************");
        System.out.println("--------------------------");
        System.out.println("*********"+birdBox.getTittel()+"*********");
        System.out.println("Regisser av " + birdBox.getRegissor());
        System.out.println("--------------------------");
    }

    public static void lagOgSkrivUtInformasjonOmDaysOfOurLives() {
        TVSerie daysOfOurLives = new TVSerie("Days of our Lives", "Time goes by...", LocalDate.of(1965, 11, 8));

        Person regisor = new Person("Herb", "Stein");

        LocalDate sisteDato = LocalDate.of(1965, 11, 8);

        int sesongNummer = 1;
        int episodeNummer = 1;
        int innevaerendeAar = sisteDato.getYear();

        // Går gjennom å lager 13518 episoder
        for (int e = 1; e <= 13518; e++){
            // Lager en ny episode
            //daysOfOurLives(new Episode("Generisk Episodetittel", "Red Wedding", episodeNummer, sesongNummer, 60, sisteDato, regisor));
            daysOfOurLives.leggTilEpisode(new Episode("Generisk Episodetittel", "Red Wedding", episodeNummer, sesongNummer, 60, sisteDato, regisor));
            episodeNummer++;

            // Undersøker om vi er kommet til fredag
            if (sisteDato.getDayOfWeek().getValue() == 5)
                // Hvis vi har det, øk med 3 dager (vi hopper over helgen)
                sisteDato = sisteDato.plusDays(3);
            else
                // HVis ikke, gå til neste dag
                sisteDato = sisteDato.plusDays(1);

            // Undersøker om vi har kommet til et nytt år
            if (innevaerendeAar != sisteDato.getYear()) {
                // Har vi det, øker vi innevarendeAar med året vi har kommet til, øker sesong med 1 og starter episode på 1
                innevaerendeAar = sisteDato.getYear();
                sesongNummer++;
                episodeNummer = 1;
            }
        }


        System.out.println("*****************************************");
        System.out.println("*********"+daysOfOurLives+"********");
        System.out.println("-------------Episoder i S42--------------");

        for (Episode episode : daysOfOurLives.hentEpisoderISesong(42))
            System.out.println(episode.toString());

        System.out.println("-----------------------------------------");
    }
}
