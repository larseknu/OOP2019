package no.larseknu.hiof.mangetraader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Oppretter et bankkontoobjekt
        BankKonto dinBankKonto = new BankKonto("9001", 1000);

        // Kjører transaksjoner i en thread pool ved hjelp av executorservice
        excecutorTraader(dinBankKonto);

        // Kjører transaksjoner ved hjelp av manuell opprettelse av tråder
        manuelleTraader(dinBankKonto);
    }

    private static void excecutorTraader(BankKonto bankKonto) throws InterruptedException {
        // Oppretter en ExcecutorService med 3 tråder i en threadpool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            // Oppretter en instans av Worker, som legger inn penger på bankkontoen
            TransaksjonsHaandterer transaksjonsHaandterer = new TransaksjonsHaandterer(bankKonto);
            // Legger til transaksjonsHaandterer til i køen til ExecutorService
            // er det en ledig tråd blir den kjørt med en gang
            // hvis ikke blir den kjørt når det blir en plass ledig i threadpool'en
            executorService.submit(transaksjonsHaandterer);
        }

        // Stopper å ta imot mer arbeid til threadpoolen. Det som allerede kjører vil kjøre ferdig
        executorService.shutdown();

        // Blokkerer videre kjøring frem til alle tråder er ferdig kjørt, eller timeouten intreffer
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        // Skriver ut endelig saldo
        System.out.println("Sluttbeløp: " + bankKonto.getSaldo());
    }


    private static void manuelleTraader(BankKonto bankKonto) throws InterruptedException {
        // Lager en liste med tråder slik at vi kan vente på at alle trådene blir ferdig
        List<Thread> traader = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            // Oppretter en instans av TransaksjonsHåndterer, som legger penger på bankkontoen
            TransaksjonsHaandterer transaksjonsHaandterer = new TransaksjonsHaandterer(bankKonto);

            // Lager en ny tråd og legger den til i lista
            traader.add(new Thread(transaksjonsHaandterer));
            // Starter kjøringen av transaksjonene
            traader.get(i).start();
        }

        // Går gjennom alle trådene i arrayen
        for (Thread enTraad : traader)
            // Blokkerer videre kjøring frem til tråden er ferdig kjørt
            enTraad.join();

        // Skriver ut endelig saldo
        System.out.println("Sluttbeløp: " + bankKonto.getSaldo());
    }
}
