package no.hiof.larseknu.databasetest;

import java.sql.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Postgres
        String url = "jdbc:postgresql://localhost:5432/dyrepark";
        // Mysql
        //String url = "jdbc:mysql://localhost:3306/dyrepark";


        String bruker = "dyreparkadmin";
        String passord = "drossap";

        try (Connection connection = DriverManager.getConnection(url, bruker, passord))
        {
            // Henter en connection som blir laget for oss av DriverManager metoden
            // Benytter da riktig driver basert på databasen vi har spesifisert i URL'en
            DyrMapper dyrMapper = new DyrMapper(connection);

            // Henter dyr med ID 20 fra databasen
            System.out.println(dyrMapper.hentForsteDyrMedNavn("Nils"));

            // Henter alle dyr fra databasen
            System.out.println(dyrMapper.hentAlleDyr());

            // Går gjennom listen med dyr og skriver ut navn og art
            for (Dyr etDyr : dyrMapper.hentAlleDyr()) {
                System.out.println(etDyr.getNavn() + " -- " + etDyr.getArt());
            }

            // Oppretter et nytt dyr
            Dyr julius = new Dyr(0, "Julius", "Ape", LocalDate.now());

            // Legger Julius til i databasen
            dyrMapper.leggTilDyr(julius);

            // Endrer navn på objektet til JuliusJr
            julius.setNavn("JuliusJr");

            // Oppdaterer databasen med den nye informasjonen
            dyrMapper.oppdaterDyr(julius);

            // Henter ut data om juliusjr
            System.out.println(dyrMapper.hentDyrMedId(julius.getId()));

            // Sletter juliusjr fra databasen igjen
            dyrMapper.slettDyr(julius.getId());
        }
        catch(SQLException sqle)
        {
            System.err.println("Feilet i opprettelsen av tilkobling: "+sqle.getMessage());
        }

        //initiellDatabasetest();
    }

    public static void initiellDatabasetest() {
        // Postgres
        String url = "jdbc:postgresql://localhost:5432/dyrepark";
        // Mysql
        //String url = "jdbc:mysql://localhost:3306/dyrepark";


        String bruker = "dyreparkadmin";
        String passord = "drossap";

        try {
            Connection connection = DriverManager.getConnection(url, bruker, passord);

            String sporring = "SELECT * FROM dyr;";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sporring);

            while (resultSet.next()) {
                int dyrid = resultSet.getInt(1);
                String navn = resultSet.getString(2);
                String art = resultSet.getString(3);
                String fodselsdato = resultSet.getString(4);

                System.out.println(new Dyr(dyrid, navn, art, LocalDate.parse(fodselsdato)));
            }
        }
        catch (SQLException e) {
            System.out.println("Klarte ikke koble til databasen: " + e.getMessage());
        }
    }
}
