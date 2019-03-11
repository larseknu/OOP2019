package no.hiof.larseknu.oblig4.model;

import java.time.LocalDate;

public class Person {
    private String fornavn, etternavn;
    private LocalDate fodselsDato;

    public Person(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        fodselsDato = LocalDate.MIN;
    }

    public Person(String fornavn, String etternavn, LocalDate fodselsDato) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsDato = fodselsDato;
    }

    public Person() {
        this.fornavn = "";
        this.etternavn = "";
        this.fodselsDato = LocalDate.MIN;
    }

    public String getFulltNavn() {
        return fornavn + " " + etternavn;
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

    public LocalDate getFodselsDato() {
        return fodselsDato;
    }

    public void setFodselsDato(LocalDate fodselsDato) {
        this.fodselsDato = fodselsDato;
    }

    @Override
    public String toString() {
        // Har en "hurtig-if" som sjekker om fodselsdato er lik minimumsverdi, er den det skrives det bare en tom streng, har den en verdi skriver vi ut "født i år " etterflugt av året
        return fornavn + " " + etternavn + (fodselsDato.equals(LocalDate.MIN) ? "" : " født i år " + fodselsDato.getYear()) ;
    }
}
