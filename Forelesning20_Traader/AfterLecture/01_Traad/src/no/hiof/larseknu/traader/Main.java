package no.hiof.larseknu.traader;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadTeller threadTeller = new ThreadTeller(1000);
        RunnableTeller runnableTeller = new RunnableTeller(1000);
        Thread runnableThread = new Thread(runnableTeller);

        threadTeller.start();
        runnableThread.start();

        threadTeller.join();
        runnableThread.join();

        System.out.println("Ferdig!");
    }
}
