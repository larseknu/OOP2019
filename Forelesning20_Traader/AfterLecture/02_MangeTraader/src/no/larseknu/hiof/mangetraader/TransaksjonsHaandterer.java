package no.larseknu.hiof.mangetraader;

public class TransaksjonsHaandterer implements Runnable {
    private BankKonto konto;

    public TransaksjonsHaandterer(BankKonto konto) {
        this.konto = konto;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            synchronized (konto) {
                int startBelop = konto.getSaldo();

                konto.settInn(100);

                traadPause(150);

                int sluttBelop = konto.getSaldo();

                System.out.println(String.format("Startbeløp: %d Sluttbeløp: %d - %s", startBelop, sluttBelop, Thread.currentThread().getName()));
            }

            traadPause(100);
        }
    }


    private void traadPause(int tidMillisekunder) {
        try {
            Thread.sleep(tidMillisekunder);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
