
/**
* Representerer en student
*/
public class Student {
  // Instansvariabler
  private String fornavn;
  private String etternavn;
  private int alder;
  private String studentId;
  /* String variablene kunne også vært deklarert slik:
  private String fornavn, etternavn, studentId; */

  /**
  * Metode for å hente ut en students fornavn
  */
  public String getFornavn() {
    return fornavn;
  }

  public String getEtternavn() {
    return etternavn;
  }

  public int getAlder() {
    return alder;
  }

  public String getStudentId() {
    return studentId;
  }

  /**
  * Metode for å hente sette en students fornavn
  */
  public void setFornavn(String fornavn) {
    this.fornavn = fornavn;
  }

  public void setEtternavn(String etternavn) {
    this.etternavn = etternavn;
  }

  public void setAlder(int alder) {
    this.alder = alder;
  }

  /**
  * Metode for å hente sette en students studentId.
  * studentId må ha en lengde på 6 tegn.
  */
  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  /**
  * Instansmetode som printer informasjon om data i klassen selv
  */
  public void printStudentInformasjon() {
    // Printer ut fornavn og etternavn til terminalen
    System.out.println(fornavn + " " + etternavn);
  }

}
