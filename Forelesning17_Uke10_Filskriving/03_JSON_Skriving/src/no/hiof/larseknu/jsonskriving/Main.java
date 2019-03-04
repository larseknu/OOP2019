package no.hiof.larseknu.jsonskriving;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import no.hiof.larseknu.jsonskriving.model.Superhelt;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Oppretter og instansierer et JSON-objekt
        Gson gson = new Gson();

        // Konverterer et Superhelt-objekt om til JSON (string-representasjon)
        String jsonText = gson.toJson(new Superhelt("Superman", "Clark Kent"));
        // Skriver ut JSON stringen til konsollen
        System.out.println("JSON objekt: " + jsonText);
        // Konverterer JSON-stringen tilbake til et Superhelt-objekt
        Superhelt superman = gson.fromJson(jsonText, Superhelt.class);
        // Skriver ut objektet til konsollen
        System.out.println("Konvertert fra JSON: " + superman);


        // Lager en liste med superhelter
        ArrayList<Superhelt> superheltArrayList = new ArrayList<>();
        // Lager og legger til noen superhelter i listen
        superheltArrayList.add(new Superhelt("Batman", "Bruce Wayne"));
        superheltArrayList.add(new Superhelt("The Hulk", "Bruce Banner"));
        superheltArrayList.add(superman);


        // Skriver listen til JSON-fil
        skrivTilJSONFil(superheltArrayList, "superhelter.json");

        // Leser liste fra JSON-fil
        ArrayList<Superhelt> superhelterFraJSONFil = lesFraJSONFil("superhelter.json");

        // Skriver ut superhelter leste fra fil
        for (Superhelt enHelt : superhelterFraJSONFil) {
            System.out.println(enHelt);
        }
    }

    private static void skrivTilJSONFil(ArrayList<Superhelt> superheltListe, String filsti) {
        // Oppretter og instansierer et gsonbuilder objekt
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        // Oppretter og instansierer et gson-objekt basert på de parameterne vi har laget builderen med
        Gson gson = gsonBuilder.create();

        // Konverterer hele listen til JSON
        String jsonTextListe = gson.toJson(superheltListe);
        // Skriver ut JSON-en til konsollen
        System.out.println("JSON liste: " + jsonTextListe);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filsti))) {
            bufferedWriter.write(jsonTextListe);
        } catch (IOException ioexc) {
            System.out.println(ioexc.getMessage());
        }
    }

    private static ArrayList<Superhelt> lesFraJSONFil(String filnavn) {
        // Oppretter og instansierer et gsonbuilder objekt
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        // Oppretter og instansierer et gson-objekt basert på de parameterne vi har laget builderen med
        Gson gson = gsonBuilder.create();

        ArrayList<Superhelt> superheltListeFraFil = new ArrayList<>();
        String linje = "";
        StringBuilder jsonTekstFraFil = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filnavn))) {
            while ((linje = bufferedReader.readLine()) != null) {
                jsonTekstFraFil.append(linje);
            }

            System.out.println("Fra fil: " + jsonTekstFraFil.toString());

            // Konverterer listen tilbake til en array
            Superhelt[] superheltArray = gson.fromJson(jsonTekstFraFil.toString(), Superhelt[].class);

            // Legger array'en inn i ArrayList'en vi skal returnere
            superheltListeFraFil.addAll(Arrays.asList(superheltArray));
        } catch (IOException ioexc) {
            System.out.println(ioexc.getMessage());
        }

        return superheltListeFraFil;
    }
}
