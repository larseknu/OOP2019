package no.hiof.larseknu.databasetest;

import java.sql.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {
        initiellDatabasetest();
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
