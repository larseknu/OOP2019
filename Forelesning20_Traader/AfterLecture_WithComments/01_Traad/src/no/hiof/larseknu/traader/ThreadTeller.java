package no.hiof.larseknu.traader;

public class ThreadTeller extends Thread {
    private int tellerTil;

    public ThreadTeller(int tellerTil) {
        this.tellerTil = tellerTil;
    }

    @Override
    public void run() {

        for (int i=0; i < tellerTil; i++) {
            System.out.println(Thread.currentThread().getName() + " - TT - " + i);
        }
    }
}
