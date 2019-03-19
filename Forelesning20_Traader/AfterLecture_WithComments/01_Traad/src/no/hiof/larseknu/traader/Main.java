package no.hiof.larseknu.traader;

public class Main {

    public static void main(String[] args) throws InterruptedException {
// Lager en instans av tellerklassen vår som arver fra Thread
        ThreadTeller threadTeller = new ThreadTeller(1000);
        // Lager en instans av RunnableTeller-klassen
        RunnableTeller runnableTeller = new RunnableTeller(1000);
        // Vi må fortsatt lage en egen tråd som RunnableTeller skal kjøres i
        Thread runnableThread = new Thread(runnableTeller);

        // Starter threadTeller, som da kjører run() og teller opp
        threadTeller.start();
        // Starter runnableThread, som da kjører run() og teller opp
        runnableThread.start();

        // Blokkerer videre kjøring til tråden er ferdig med å kjøre
        threadTeller.join();
        // Blokkerer videre kjøring til tråden er ferdig med å kjøre
        runnableThread.join();

        // Skriver ut ferdig
        System.out.println("Ferdig!");
    }
}
