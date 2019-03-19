package no.hiof.larseknu.traader;

public class RunnableTeller implements Runnable {
    private int tellerTil;

    public RunnableTeller(int tellerTil) {
        this.tellerTil = tellerTil;
    }


    @Override
    public void run() {
        for (int i = 0; i < tellerTil; i++) {
            System.out.println(Thread.currentThread().getName() + " - RT - " + i);
        }
    }
}
