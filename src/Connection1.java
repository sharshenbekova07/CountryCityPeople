import java.sql.*;
import java.util.Scanner;

public class Connection1 {
    Scanner scan = new Scanner(System.in);

    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "12345";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to server successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertCities(City city) {
        String SQL = "INSERT INTO \"it-academy\".cities" +
                "(name,country_id,maior_name,population)" + "VALUES(?,?,?,?);";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, city.getName());
            stmt.setInt(2, city.getCountry_id());
            stmt.setString(3, city.getFioMayor());
            stmt.setInt(4, city.getPopulation());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insertPeople(People people) {
        String SQL = "INSERT INTO \"it-academy\".people" +
                "(fio,birth_day,city_id) VALUES(?,?,?);";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, people.getFio());
            stmt.setTimestamp(2,new Timestamp(people.getBirthDate().getTime()));
            stmt.setInt(3, people.getCity_id());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insertCountry(Countries countries) {
        String SQL = "INSERT INTO\"it-academy\".countries (name ,code,population,president_name)" +
                "VALUES(?,?,?,?);";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, countries.getName());
            stmt.setInt(2, countries.getCode());
            stmt.setInt(3, countries.getPopulation());
            stmt.setString(4, countries.getPresident());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCity(City city) {
        String SQL = "update \" it - academy\".cities set name=?,country_id=?,maior_name=?,population=?"+
                " where id=?; ";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, city.getName());
            stmt.setInt(2, city.getCountry_id());
            stmt.setString(3, city.getFioMayor());
            stmt.setInt(4, city.getPopulation());
            stmt.setInt(5, city.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectCountry(Countries countries) {
        String SQL = "Select * From\"it-academy\".countries ";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id")+"|"+rs.getString("name") +"|"+
                        rs.getString("president_name")+"|"+
                        rs.getInt("population")+"|"+
                        rs.getInt("code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectCity(City city) {
        String SQL = "Select * From\"it-academy\".cities ";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id")+"|"+
                        rs.getString("name") +"|"+
                        rs.getInt("country_id")+"|"+
                        rs.getInt("population")+"|"+
                        rs.getString("maior_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCityById(City city) {
        String SQL = "DELETE  FROM \"it-academy\".cities WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, city.getId());
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletePeopleById(People people) {
        String SQL = "DELETE  FROM \"it-academy\".people WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, people.getId());
            ResultSet rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


