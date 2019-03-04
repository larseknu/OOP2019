package no.hiof.larseknu.csvskriving;

import no.hiof.larseknu.csvskriving.model.Superhelt;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Lager en liste med superhelter
        ArrayList<Superhelt> superheltArrayList = new ArrayList<>();

        superheltArrayList.add(new Superhelt("Superman", "Clark Kent"));
        superheltArrayList.add(new Superhelt("Hulk", "Bruce Banner"));
        superheltArrayList.add(new Superhelt("Batman", "Bruce Wayne"));

        // Definrerer filen vi skal skrive til
        File kilde = new File("superheltregister.csv");

        // Skriver listen til den spesifiserte filen
        skrivTilCSVFil(superheltArrayList, kilde);

        // Leser ut fra filen og legger det i en ny liste
        ArrayList<Superhelt> superHelterFraFil = lesFraCSVFil(kilde);

        // Skriver ut den nye listen som er laget basert på innholdet i filen
        System.out.println(superHelterFraFil);
    }

    private static void skrivTilCSVFil(ArrayList<Superhelt> superhelter, File filSomSkrivesTil) {
        try (BufferedWriter bufretSkriver = new BufferedWriter(new FileWriter(filSomSkrivesTil))) {
            // Går igjennom alle superhelter i superheltlisten
            for(Superhelt enSuperhelt: superhelter) {
                // Skriver fornavn og alterego til filen avskilt med ";"
                bufretSkriver.write( enSuperhelt.getNavn() + ";" + enSuperhelt.getAlterEgo() );
                // Skriver et linjeskift
                bufretSkriver.newLine();
            }
        } catch (FileNotFoundException fnfe) {
            // Skriver ut feilmelding om filen ikke finnes
            System.out.println(fnfe.getMessage());
        } catch (IOException ioexc) {
            // skriver ut feilmelding om det oppstår feil ved skriving til fil
            System.out.println(ioexc.getLocalizedMessage());
        }
    }

    private static ArrayList<Superhelt> lesFraCSVFil(File filSomLesesFra) {
        ArrayList<Superhelt> superhelterFraFil = new ArrayList<>();
        try (BufferedReader bufretLeser = new BufferedReader(new FileReader(filSomLesesFra))) {
            // Lager variabel å holde på hver tekstlinje
            String linje;

            // Løkken går så lenge det finnes linjer
            while( (linje = bufretLeser.readLine()) != null ){
                // Deler opp teksten på tegnet ";" -> dette resulterer i an array som heter deler
                // index 0 -> fornavn
                // index 1 -> etternavn
                String[] deler = linje.split(";");

                // Lager en ny superhelt med denne informasjonen
                Superhelt enSuperHelt = new Superhelt(deler[0], deler[1]);

                // Legger til denne superhelten i listen
                superhelterFraFil.add(enSuperHelt);
            }


        } catch (IOException e) {
            // skriver ut feilmelding om det oppstår feil med filen
            System.out.println(e);
        }


        // Returnerer listen med superhelter
        return superhelterFraFil;
    }
}
