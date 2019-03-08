package no.hiof.larseknu.indreklasse;

public class Main {

    public static void main(String[] args) {
        // Lager et ansattobjekt
        Ansatt larsEmil = new Ansatt("Lars Emil", 1337);

        // Legger til lønnsslipper
        larsEmil.leggTilLonnsslipp("Januar", 39000, 40);
        larsEmil.leggTilLonnsslipp("Februar", 32000, 35);

        // Printer ut lønnsslipper
        larsEmil.printLonnsslipper();

        // Vi har her ikke egentlig forholdt oss til klassen Lonnsslipp i det hele tatt,
        // den er blitt "skjult" for oss i Ansatt klassen
    }

}

