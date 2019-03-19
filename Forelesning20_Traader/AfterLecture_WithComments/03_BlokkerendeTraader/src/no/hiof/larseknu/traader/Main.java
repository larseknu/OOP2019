package no.hiof.larseknu.traader;

public class Main {

    public static void main(String[] args) {
	    String viktigRessurs1 = "Viktig ressurs 1";
	    String viktigRessurs2 = "Viktig ressurs 2";


	    // Tråd 1 prøver å låse ressurs 1, så ressurs 2
	    Thread traad1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Låser viktigRessurs1 for behandling
                synchronized (viktigRessurs1) {
                    System.out.println(Thread.currentThread().getName() + " låst " + viktigRessurs1);

                    traadPause(100);

                    synchronized (viktigRessurs2) {
                        System.out.println(Thread.currentThread().getName() + " låst " + viktigRessurs2);
                    }
                }
            }
        });


        // Tråd 2 prøver å låse ressurs2, så ressurs1
	    Thread traad2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Låser viktigRessurs2 for behandling
                synchronized (viktigRessurs2) {
                    System.out.println(Thread.currentThread().getName() + " låst " + viktigRessurs2);

                    traadPause(100);

                    // Prøver å låse viktigRessurs1
                    synchronized (viktigRessurs1) {
                        System.out.println(Thread.currentThread().getName() + " låst " + viktigRessurs1);
                    }
                }
            }
        });


	    traad1.start();
	    traad2.start();
    }

    private static void traadPause(int tidMillisekunder) {
        try {
            Thread.sleep(tidMillisekunder);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
