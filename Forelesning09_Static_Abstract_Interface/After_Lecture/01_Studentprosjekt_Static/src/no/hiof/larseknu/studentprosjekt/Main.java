package no.hiof.larseknu.studentprosjekt;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    // Lager et "tomt" Student-objekt
    Student enDynamiskStudent = null;

    // Ser om vi får noen inputargumenter fra "kommandolinja"
    if (args.length > 0) {
      // Legger inputargumentene i egne variabler
      String fornavn = args[0];
      String etternavn = args[1];
      String studentId = args[2];

      // Instansierer Student-objektet basert på input'en
      enDynamiskStudent = new Student(fornavn, etternavn, studentId);
    }

    System.out.println("*Student fra input args:*");
    System.out.println(enDynamiskStudent);

    // Oppretter et par Student-objekter
    Student albertEinstein = new Student("Albert", "Einstein", "454545");
    Student nikolaTesla = new Student("Nikola", "Tesla", "3");

    // Oppretter et par Ansatt-objekter
    Ansatt lek = new Ansatt("Lars Emil", "Knudsen", "1337", 90.0);
    Ansatt thn = new Ansatt("Tom Heine", "Nätt", "0001", 500.0);

    // Henter ut den statiske listen over alle personer
    ArrayList<Person> allePersoner = Person.getAllePersoner();

    System.out.println("********Liste:*********");
    for (Person enPersonIListen : allePersoner) {
      System.out.println(enPersonIListen);
    }
  }

}
