package no.hiof.larseknu.dyrepark;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Dyrepark {
    private String navn;
    private ArrayList<Dyr> dyrIDyreparken = new ArrayList<>();

    public Dyrepark(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Dyr> getDyrIDyreparken() {
        return new ArrayList<>(dyrIDyreparken);
    }

    public void leggTilEttDyrIDyreparken(Dyr etDyr) {
        dyrIDyreparken.add(etDyr);
    }

    public void leggTilDyrIDyreparken(ArrayList<Dyr> dyrIDyreparken) {
        this.dyrIDyreparken.addAll(dyrIDyreparken);
    }

    public void skrivAlleBursdagerForMaanedTilFil(int maaned, String filsti) {
        PrintWriter printSkriver = null;

        try {
            printSkriver = new PrintWriter(new FileWriter(filsti));

            for (int i = 0; i < 3; i++) {
                Dyr dyret = dyrIDyreparken.get(i);

                if (dyret.getFodselsDato().getMonthValue() == maaned)
                    printSkriver.println(dyret.getNavn() + " har bursdag " + dyret.getFodselsDato());
            }

        }
        catch (IndexOutOfBoundsException | FileNotFoundException e) {
            System.err.println("Fanget en exception: " +  e.getMessage());
            e.printStackTrace(System.out);
            //throw new IndexOutOfBoundsException();
        }
        catch (IOException e) {
            System.err.println("Fanget IOException: " +  e.getMessage());
            e.printStackTrace(System.out);
        }
        finally {
            if (printSkriver != null) {
                System.out.println("Lukker PrintWriter");
                printSkriver.close();
            }
            else {
                System.out.println("PrintWriter er ikke åpnet");
            }
        }


    }
}
