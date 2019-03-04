package no.hiof.larseknu.serialisering;

import no.hiof.larseknu.serialisering.model.Superhelt;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        skrivSerialisertObjektTilFil();

        lesSerialisertObjektFraFil();
    }

    private static void lesSerialisertObjektFraFil() {
        // lage File-objekt
        File fil = new File("superhelter.ser");

        try {
            // Forsøker å koble til filen
            FileInputStream fileIn = new FileInputStream(fil);

            // Legger buffer på strømmen
            BufferedInputStream bufferIn = new BufferedInputStream(fileIn);

            // Sier at bufferen må håndtere innkommende objekt
            ObjectInputStream objectIn = new ObjectInputStream(bufferIn);

            // Vi henter ut en liste med objekter fra den serialiserte filen
            ArrayList<Superhelt> superhelter = (ArrayList<Superhelt>) objectIn.readObject();

            System.out.println(superhelter);

            // Stenger strømmer
            objectIn.close();
            bufferIn.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            // Skriver ut feilmelding
            System.out.println(e);
        }
    }

    private static void skrivSerialisertObjektTilFil() {
        // Lager en liste med superhelter
        ArrayList<Superhelt> superheltArrayList = new ArrayList<>();
        // Lager og legger til noen superhelter i listen
        superheltArrayList.add(new Superhelt("Batman", "Bruce Wayne"));
        superheltArrayList.add(new Superhelt("Hulk", "Bruce Banner"));
        superheltArrayList.add(new Superhelt("Superman", "Clark Kent"));

        // Lager File-objekt
        File fil = new File("superhelter.ser");

        try {
            // Forsøk å koble til filen
            FileOutputStream fileOut = new FileOutputStream(fil);

            // Legg buffer på skrivestrøm
            BufferedOutputStream bufferOut = new BufferedOutputStream(fileOut);

            // Si at bufferen skal sende strøm av objekter
            ObjectOutputStream objectOut = new ObjectOutputStream(bufferOut);

            // skriv superheltlisten til filen
            objectOut.writeObject(superheltArrayList);

            // Tvinger skriving
            objectOut.flush();

            // Stenger strømmer
            objectOut.close();
            bufferOut.close();
            fileOut.close();

        } catch (IOException e) {
            // Skriver ut feilmelding
            System.out.println(e);
        }
    }
}

