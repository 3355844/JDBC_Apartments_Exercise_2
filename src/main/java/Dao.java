import java.util.ArrayList;

/**
 * Created by user on 08.02.2017.
 */
public interface Dao {
    void deleteApartmentById(int id);

    void updateApartments(Apartments apartments);

    ArrayList<Apartments> getApartmentsById(int id);

    ArrayList<Apartments> getApartmentsByRegion(String region);

    ArrayList<Apartments> getApartmentsByAddress(String address);

    ArrayList<Apartments> getApartmentsBySquare(int square);

    ArrayList<Apartments> getApartmentsByRooms(int rooms);

    ArrayList<Apartments> getApartmentsByPrice(double price);

    void addApartments(Apartments apartments);

}
