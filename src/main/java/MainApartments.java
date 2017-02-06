import java.util.ArrayList;

/**
 * Created by user on 01.02.2017.
 */
public class MainApartments {
    public static void main(String[] args) {

        ApartmentsDAO dao = new ApartmentsDAO();
//        dao.createTenApartment();
        ArrayList<Apartments> apartmentsArrayList;
        System.out.println("get by id");
        apartmentsArrayList = dao.getApartmentsById(8);
        System.out.println(apartmentsArrayList.toString());

        System.out.println("get by region");
        apartmentsArrayList = dao.getApartmentsByRegion("Svatoshin 6");
        System.out.println(apartmentsArrayList.toString());

        System.out.println("get by address");
        apartmentsArrayList = dao.getApartmentsByAddress("Pobedu 12 3");
        System.out.println(apartmentsArrayList.toString());

        System.out.println("get by square");
        apartmentsArrayList = dao.getApartmentsBySquare(152);
        System.out.println(apartmentsArrayList.toString());

        System.out.println("get by rooms");
        apartmentsArrayList = dao.getApartmentsByRooms(11);
        System.out.println(apartmentsArrayList.toString());

        System.out.println("get by price");
        apartmentsArrayList = dao.getApartmentsByPrice(500000);
        System.out.println(apartmentsArrayList.toString());

        Apartments apartments = dao.getApartmentsById(2).get(0);
        apartments.setAddress("new Address");
        apartments.setRegion("new Region");
        apartments.setPrice(20000);
        apartments.setSquare(250);
        apartments.setRooms(6);
        dao.updateApartments(apartments);
        dao.deleteApartmentById(4);

    }
}
