package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DogTypes {
    /*
    A DogTypes osztályba dolgozz, mely egy DataSource-ot kap konstruktorba.
    A DogTypesTest hívja meg, ott van a DataSource deklarálva. Nyugodtan írd át a benne lévő értékeket.

Legyen egy List<String> getDogsByCountry(String country) metódusa,
mely adatbázisból visszaadja az adott országhoz tartozó kutyafajtákat!
A teszteset a V1__dogs.sql állományt futtatja le Flyway-jel.
Létrehoz egy dog_types táblát, amiből a lényeges a name és a country oszlop.
Adatokat is beszúrja. Ha lassú, akkor csak azokat a sorokat hagyd benne, amiben szerepel a HUNGARY szó!

Vigyázz, a metódus kisbetűsen kapja az ország nevét, de az adatbázisban csupa nagybetűsen szerepel.
Vigyázz, a kutyák fajtái nagybetűkkel vannak, de kisbetűkkel kell visszaadni. (Konvertálásokat végezheted Javaban vagy SQL-ben is.)

Név szerint sorbarendezve add vissza őket!
     */
    DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country){


        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select name from dog_types where country = ?");
        ) {
            stmt.setString(1, country.toUpperCase());

            return getDogTypesOfACountry(stmt);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("cannot select", sqle);
        }
    }

    private List<String> getDogTypesOfACountry(PreparedStatement stmt) {
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            List<String> dogNames = new ArrayList<>();
            while (rs.next()) {
                String dogName = rs.getString("name").toLowerCase();
                dogNames.add(dogName);
            }

            Collections.sort(dogNames);
            return dogNames;

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("cannot find", sqle);
        }
    }

}
