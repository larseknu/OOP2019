package no.hiof.larseknu.studentprosjekt;

public class Ansatt extends Person {
    private String ansattId;
    private double timeLonn;

    public Ansatt(String fornavn, String etternavn, String ansattId, double timeLonn) {
        super(fornavn, etternavn);
        this.ansattId = ansattId;
        this.timeLonn = timeLonn;
    }
}
