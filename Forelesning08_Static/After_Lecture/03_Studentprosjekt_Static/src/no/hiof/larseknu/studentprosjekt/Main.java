package no.hiof.larseknu.studentprosjekt;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    Student enDynamiskStudent = null;

    if (args.length > 0) {
      String fornavn = args[0];
      String etternavn = args[1];
      String studentId = args[2];

      enDynamiskStudent = new Student(fornavn, etternavn, studentId);
    }

    System.out.println(enDynamiskStudent);

    // Oppretter et par studentobjekter
    Student albertEinstein = new Student("Albert", "Einstein", "454545");
    Student nikolaTesla = new Student("Nikola", "Tesla", "3");

    System.out.println(albertEinstein);

    Ansatt lek = new Ansatt("Lars Emil", "Knudsen", "1337", 90.0);
    Ansatt thn = new Ansatt("Tom Heine", "Nätt", "0001", 500.0);

    // Henter ut den statiske listen over alle personer
    ArrayList<Person> allePersoner = Person.getAllePersoner();

    for (Person enPersonIListen : allePersoner) {
      System.out.println(enPersonIListen);
    }
  }

}
