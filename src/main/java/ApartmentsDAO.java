import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by user on 01.02.2017.
 */
public class ApartmentsDAO {

    private MySqlConnector connector = new MySqlConnector();

    public void deleteApartmentById(int id) {
        String query = "DELETE  FROM apartments WHERE ID = ?;";
        try {
            PreparedStatement statement = connector.getConnection().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateApartments(Apartments apartments) {
        PreparedStatement statement;
        String query = "UPDATE apartments SET REGION=?, ADDRESS=?, SQUARE=?, ROOMS=?, PRICE=? WHERE ID=?;";
        try {
            statement = connector.getConnection().prepareStatement(query);
            statement.setString(1, apartments.getRegion());
            statement.setString(2, apartments.getAddress());
            statement.setInt(3, apartments.getSquare());
            statement.setInt(4, apartments.getRooms());
            statement.setDouble(5, apartments.getPrice());
            statement.setInt(6, apartments.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Apartments> getApartmentsById(int id) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM apartments WHERE ID = '" + id + "';";
        try {
            Statement statement = connector.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parseApartments(resultSet);
    }

    public ArrayList<Apartments> getApartmentsByRegion(String region) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM apartments WHERE REGION = '" + region + "';";
        try {
            Statement statement = connector.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parseApartments(resultSet);
    }

    public ArrayList<Apartments> getApartmentsByAddress(String address) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM apartments WHERE ADDRESS = '" + address + "';";
        try {
            Statement statement = connector.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parseApartments(resultSet);
    }

    public ArrayList<Apartments> getApartmentsBySquare(int square) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM apartments WHERE SQUARE = '" + square + "';";
        try {
            Statement statement = connector.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parseApartments(resultSet);
    }

    public ArrayList<Apartments> getApartmentsByRooms(int rooms) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM apartments WHERE ROOMS = '" + rooms + "';";
        try {
            Statement statement = connector.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parseApartments(resultSet);
    }

    public ArrayList<Apartments> getApartmentsByPrice(double price) {
        ResultSet resultSet = null;
        String query = "SELECT * FROM apartments WHERE PRICE = '" + price + "';";
        try {
            Statement statement = connector.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parseApartments(resultSet);
    }

    private ArrayList<Apartments> parseApartments(ResultSet resultSet) {
        ArrayList<Apartments> resultList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Apartments apartments = new Apartments();
                apartments.setId(resultSet.getInt("ID"));
                apartments.setRegion(resultSet.getString("REGION"));
                apartments.setAddress(resultSet.getString("ADDRESS"));
                apartments.setSquare(resultSet.getInt("SQUARE"));
                apartments.setRooms(resultSet.getInt("ROOMS"));
                apartments.setPrice(resultSet.getDouble("PRICE"));
                resultList.add(apartments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public void addApartments(Apartments apartments) {
        PreparedStatement statement;
        try {
            statement = connector.getConnection().prepareStatement("INSERT INTO apartments (REGION, ADDRESS, SQUARE, ROOMS, PRICE) VALUES (?,?,?,?,?)");
            statement.setString(1, apartments.getRegion());
            statement.setString(2, apartments.getAddress());
            statement.setInt(3, apartments.getSquare());
            statement.setInt(4, apartments.getRooms());
            statement.setDouble(5, apartments.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTenApartment() {

        PreparedStatement statement;
        try {
            for (int i = 0; i < 10; i++) {

                statement = connector.getConnection().prepareStatement("INSERT INTO apartments (REGION, ADDRESS, SQUARE, ROOMS, PRICE) VALUES (?,?,?,?,?)");
                statement.setString(1, "Svatoshin " + i);
                statement.setString(2, "Pobedu 12 " + i);
                statement.setInt(3, 150 + i);
                statement.setInt(4, 5 + i);
                statement.setDouble(5, 500000 + i);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

