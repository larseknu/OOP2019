package no.hiof.larseknu.flyoversikt;

public class Transportfly extends Fly {
    private double bruktLast;
    private double maksLast;

    public Transportfly() {
        maksLast = 10000.0;
    }

    public Transportfly(String modell, int seter, double maksLast) {
        super(modell, seter);
        this.maksLast = maksLast;
    }

    public double getBruktLast() {
        return bruktLast;
    }

    public double getMaksLast() {
        return maksLast;
    }

    public void leggTilEnPakke(double hoyde, double bredde, double dybde) {
        double storrelse = hoyde * bredde * dybde;

        if ( harLedigLagringsPlass(storrelse) )
            bruktLast += storrelse;
        else
            System.out.println("Du vil overskride makslast");
    }

    private boolean harLedigLagringsPlass(double storrelse) {
        return bruktLast + storrelse <= maksLast;
    }

}
