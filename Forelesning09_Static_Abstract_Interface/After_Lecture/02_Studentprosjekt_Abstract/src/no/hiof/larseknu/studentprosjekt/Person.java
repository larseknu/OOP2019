package no.hiof.larseknu.studentprosjekt;

import java.util.ArrayList;

public abstract class Person {
    private String fornavn;
    private String etternavn;
    private static ArrayList<Person> allePersoner = new ArrayList<>();

    public Person(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        allePersoner.add(this);
    }

    public static ArrayList<Person> getAllePersoner() {
        ArrayList<Person> innkapslingAvListe = new ArrayList<>(allePersoner);
        return innkapslingAvListe;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    @Override
    public String toString() {
        return fornavn + " " + etternavn;
    }
}
