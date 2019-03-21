package no.hiof.larseknu.databasetest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

// Det er en del duplisering av kode i denne klassen, bare for å gi dere et konkret eksempel med "alt"
// som skal til for hver enkelt handling
// Normalt sett vil man nok refaktorere dette litt og hatt en eller flere interne metode
// som samler den dupliserte koden
public class DyrMapper {

    private Connection connection;

    public DyrMapper(Connection connection) {
        this.connection = connection;
    }

    public Dyr hentDyrMedId(int id) {
        try (//Lag et nytt statement objekt
             Statement stmnt = connection.createStatement();
             // Henter resultatet fra databasen
             ResultSet resultSet = stmnt.executeQuery("SELECT * FROM dyr WHERE id = " + id + ";"))
        {
            if (resultSet.next()) {
                int dyreId = resultSet.getInt("id");
                String navn = resultSet.getString("navn");
                String art = resultSet.getString("art");
                String fodselsDatoString = resultSet.getString("fodselsdato");
                LocalDate fodselsdato = LocalDate.parse(fodselsDatoString);

                return new Dyr(dyreId, navn, art, fodselsdato);
            }
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);

        }

        return null;
    }

    public Dyr hentForsteDyrMedNavn(String dyreNavn) {
        try (//Lag et nytt statement objekt
             Statement statement = connection.createStatement();
             // Henter resultatet fra databasen
             ResultSet resultSet = statement.executeQuery("SELECT * FROM dyr WHERE navn LIKE '" + dyreNavn + "';"))
        {
            if (resultSet.next()) {
                int dyreId = resultSet.getInt("id");
                String navn = resultSet.getString("navn");
                String art = resultSet.getString("art");
                String fodselsDatoString = resultSet.getString("fodselsdato");
                LocalDate fodselsdato = LocalDate.parse(fodselsDatoString);

                return new Dyr(dyreId, navn, art, fodselsdato);
            }
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);

        }

        return null;
    }

    public ArrayList<Dyr> hentAlleDyr() {
        ArrayList<Dyr> dyreListe = new ArrayList<>();

        try (//Lag et nytt statement objekt
             Statement statement = connection.createStatement();

             ResultSet resultSet = statement.executeQuery("SELECT * FROM dyr;"))
        {


            while (resultSet.next()) {
                dyreListe.add(new Dyr(resultSet.getInt("id"),
                        resultSet.getString("navn"),
                        resultSet.getString("art"),
                        LocalDate.parse(resultSet.getString("fodselsdato"))));
            }
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);
        }

        return dyreListe;
    }

    public void leggTilDyr(Dyr etDyr)  {
        String sql = String.format("INSERT INTO dyr (navn, art, fodselsdato) " +
                        "VALUES('%s','%s','%s');",
                etDyr.getNavn(), etDyr.getArt(), etDyr.getFodselsDato());

        try (//Lag et nytt statement objekt
             Statement statement = connection.createStatement())
        {
            statement.execute(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next())
                etDyr.setId((int) resultSet.getLong(1));
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);
        }
    }

    public void slettDyr(int id) {
        try(//Lag et nytt statement objekt
            Statement statement = connection.createStatement())
        {
            String sql = String.format("DELETE FROM dyr WHERE id = %d;", id);

            statement.executeUpdate(sql);
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);
        }
    }

    public void oppdaterDyr(Dyr etDyr) {
        try (//Lag et nytt statement objekt
             Statement statement = connection.createStatement())
        {


            String sql = String.format("UPDATE dyr " +
                            "SET navn = '%s', art = '%s', fodselsdato = '%s' " +
                            "WHERE id = %d;",
                    etDyr.getNavn(), etDyr.getArt(), etDyr.getFodselsDato().toString(), etDyr.getId());

            statement.executeUpdate(sql);
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);
        }
    }
}
