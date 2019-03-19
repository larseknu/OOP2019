package no.hiof.larseknu.traader;

public class Main {

    public static void main(String[] args) {
	    String viktigRessurs1 = "Viktig ressurs 1";
	    String viktigRessurs2 = "Viktig ressurs 2";


	    Thread traad1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (viktigRessurs1) {
                    System.out.println(Thread.currentThread().getName() + " låst " + viktigRessurs1);

                    traadPause(100);

                    synchronized (viktigRessurs2) {
                        System.out.println(Thread.currentThread().getName() + " låst " + viktigRessurs2);
                    }
                }
            }
        });


	    Thread traad2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (viktigRessurs2) {
                    System.out.println(Thread.currentThread().getName() + " låst " + viktigRessurs2);

                    traadPause(100);

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
