package no.hiof.larseknu.hashmaptest;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> maanedsOversikt = new HashMap<>();

        maanedsOversikt.put(1, "Januar");
        maanedsOversikt.put(2, "Februar");
        maanedsOversikt.put(2, "Februar");
        maanedsOversikt.put(2, "Februar");

        // la oss skrive ut inneholdet
        System.out.println(maanedsOversikt); // som du ser har vi kun 2 par i mappen. Dette er fordi alle keys må være unike

        maanedsOversikt.put(3, "Mars");
        maanedsOversikt.put(4, "April");

        System.out.println(maanedsOversikt);

        // vi kan da hente valuen til en key slik
        // verdien til en nøkkel
        System.out.println("Vi henter her verdien til nøkkelen \"0\": " + maanedsOversikt.get(0));

        for(Integer key : maanedsOversikt.keySet()) {
            System.out.println(key + " tilsvarer måneden: " + maanedsOversikt.get(key));
        }
    }
}
