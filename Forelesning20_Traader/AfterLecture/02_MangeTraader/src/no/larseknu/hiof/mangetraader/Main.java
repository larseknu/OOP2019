package no.larseknu.hiof.mangetraader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BankKonto dinBankKonto = new BankKonto("9001", 1000);

        excecutorTraader(dinBankKonto);

        manuelleTraader(dinBankKonto);
    }

    private static void excecutorTraader(BankKonto bankKonto) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            TransaksjonsHaandterer transaksjonsHaandterer = new TransaksjonsHaandterer(bankKonto);
            executorService.submit(transaksjonsHaandterer);
        }

        executorService.shutdown();

        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("Sluttbeløp: " + bankKonto.getSaldo());
    }


    private static void manuelleTraader(BankKonto bankKonto) throws InterruptedException {
        List<Thread> traader = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            TransaksjonsHaandterer transaksjonsHaandterer = new TransaksjonsHaandterer(bankKonto);

            traader.add(new Thread(transaksjonsHaandterer));
            traader.get(i).start();
        }

        for (Thread enTraad : traader)
            enTraad.join();

        System.out.println("Sluttbeløp: " + bankKonto.getSaldo());
    }
}
