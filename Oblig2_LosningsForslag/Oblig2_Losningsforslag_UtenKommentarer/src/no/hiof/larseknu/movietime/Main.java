package no.hiof.larseknu.movietime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        TvSerie strangerThings = new TvSerie("Stranger Things",
                "When a young boy disappears, his mother, a police chief, and his friends must confront terrifying forces in order to get him back.",
                LocalDate.of(2016, 7,15));


        Episode episode1 = new Episode("Chapter One: The Vanishing of Will Byers", 1, 1, 50);
        Episode episode2 = new Episode("Chapter Two: The Weirdo on Maple Street", 2, 1, 50);
        Episode episode3 = new Episode("Chapter Three: Holly, Jolly", 3, 1, 50);
        Episode episode4 = new Episode("Chapter Four: The Body", 4, 1, 50);

        strangerThings.leggTilEpisode(episode1);
        strangerThings.leggTilEpisode(episode2);
        strangerThings.leggTilEpisode(episode3);
        strangerThings.leggTilEpisode(episode4);

        strangerThings.leggTilEpisode(new Episode("Chapter One: MADMAX", 1, 2, 50));
        strangerThings.leggTilEpisode(new Episode("Chapter Two: Trick or Treat, Freak", 2, 2, 50));
        strangerThings.leggTilEpisode(new Episode("Chapter Three: The Pollywog", 3, 2, 50));

        ArrayList<Episode> episodeListe = strangerThings.getEpisodeListe();

        System.out.println("**************************");
        System.out.println("* " + strangerThings + " *");
        System.out.println("**************************");
        System.out.println("-------Alle Episoder------");


        for (Episode enEpisode : episodeListe) {
            System.out.println(enEpisode);
        }

        System.out.println("**************************\n");


        TvSerie gameOfThrones = new TvSerie("Game of Thrones", "They are in a game for the throne.", LocalDate.of(2011, 4, 11));

        Random randomTallGenerator = new Random();

        for (int sesongNr = 1; sesongNr <= 5; sesongNr++) {
            for (int episodeNr = 1; episodeNr <= 20; episodeNr++) {
                gameOfThrones.leggTilEpisode(new Episode("Generic Title", episodeNr, sesongNr, randomTallGenerator.nextInt(11) + 20));
            }
        }

        ArrayList<Episode> gameOfThronesSesong4Episoder = gameOfThrones.hentEpisoderISesong(4);

        System.out.println("**************************");
        System.out.println("* " + gameOfThrones + " *");
        System.out.println("**************************");
        System.out.println("**** Spilletid: " + gameOfThrones.getGjennomSnittligSpilletid() + "min ****");
        System.out.println("**************************");
        System.out.println("-------Episoder S04-------");

        for (Episode enEpisode : gameOfThronesSesong4Episoder) {
            System.out.println(enEpisode);
        }

        System.out.println("**************************");

        gameOfThrones.leggTilEpisode(new Episode("EpisodeISesong10", 1, 10, 50));

    }
}
