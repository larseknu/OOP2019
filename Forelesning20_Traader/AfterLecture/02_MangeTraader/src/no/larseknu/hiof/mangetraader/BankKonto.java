package no.larseknu.hiof.mangetraader;

public class BankKonto {
    private String kontoNr;
    private int saldo;

    public BankKonto(String kontoNr, int saldo) {
        this.kontoNr = kontoNr;
        this.saldo = saldo;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void settInn(int belop) {
        saldo += belop;
    }
}
