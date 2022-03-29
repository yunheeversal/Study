package main;

import java.util.Scanner;
import viewer.*;

public class TravelMain {

    public static void main(String[] args) {
        UserViewer userViewer = new UserViewer();
        AirViewer airViewer = new AirViewer();
        AirRecordViewer airRecordViewer = new AirRecordViewer();
        HotelViewer hotelViewer = new HotelViewer();
        HotelRoomViewer hotelRoomViewer = new HotelRoomViewer();
        HotelRecordViewer hotelRecordViewer = new HotelRecordViewer();
        RentalCarViewer rentalcarViewer = new RentalCarViewer();
        RentRecordViewer rentRecordViewer = new RentRecordViewer();
        
        
        Scanner scanner = new Scanner(System.in);
        

        userViewer.setScanner(scanner);
        userViewer.setAirViewer(airViewer);
        userViewer.setHotelViewer(hotelViewer);
        userViewer.setRentalCarViewer(rentalcarViewer);
        userViewer.setAirRecordViewer(airRecordViewer);
        userViewer.setHotelRecordViewer(hotelRecordViewer);
        userViewer.setHotelRoomViewer(hotelRoomViewer);
        userViewer.setRentRecordViewer(rentRecordViewer);
        
        airViewer.setScanner(scanner);
        airViewer.setUserViewer(userViewer);
        airViewer.setHotelViewer(hotelViewer);
        airViewer.setRentalCarViewer(rentalcarViewer);
        airViewer.setAirRecordViewer(airRecordViewer);
        airViewer.setHotelRecordViewer(hotelRecordViewer);
        airViewer.setHotelRoomViewer(hotelRoomViewer);
        airViewer.setRentRecordViewer(rentRecordViewer);
        
        hotelViewer.setScanner(scanner);
        hotelViewer.setAirViewer(airViewer);
        hotelViewer.setUserViewer(userViewer);
        hotelViewer.setRentalCarViewer(rentalcarViewer);
        hotelViewer.setAirRecordViewer(airRecordViewer);
        hotelViewer.setHotelRecordViewer(hotelRecordViewer);
        hotelViewer.setHotelRoomViewer(hotelRoomViewer);
        hotelViewer.setRentRecordViewer(rentRecordViewer);
        
        rentalcarViewer.setScanner(scanner);
        rentalcarViewer.setAirViewer(airViewer);
        rentalcarViewer.setHotelViewer(hotelViewer);
        rentalcarViewer.setUserViewer(userViewer);
        rentalcarViewer.setAirRecordViewer(airRecordViewer);
        rentalcarViewer.setHotelRecordViewer(hotelRecordViewer);
        rentalcarViewer.setHotelRoomViewer(hotelRoomViewer);
        rentalcarViewer.setRentRecordViewer(rentRecordViewer);
        
        airRecordViewer.setScanner(scanner);
        airRecordViewer.setAirViewer(airViewer);
        airRecordViewer.setHotelViewer(hotelViewer);
        airRecordViewer.setRentalCarViewer(rentalcarViewer);
        airRecordViewer.setUserViewer(userViewer);
        airRecordViewer.setHotelRecordViewer(hotelRecordViewer);
        airRecordViewer.setHotelRoomViewer(hotelRoomViewer);
        airRecordViewer.setRentRecordViewer(rentRecordViewer);
        
        hotelRecordViewer.setScanner(scanner);
        hotelRecordViewer.setAirViewer(airViewer);
        hotelRecordViewer.setHotelViewer(hotelViewer);
        hotelRecordViewer.setRentalCarViewer(rentalcarViewer);
        hotelRecordViewer.setAirRecordViewer(airRecordViewer);
        hotelRecordViewer.setUserViewer(userViewer);
        hotelRecordViewer.setHotelRoomViewer(hotelRoomViewer);
        hotelRecordViewer.setRentRecordViewer(rentRecordViewer);
        
        hotelRoomViewer.setScanner(scanner);
        hotelRoomViewer.setAirViewer(airViewer);
        hotelRoomViewer.setHotelViewer(hotelViewer);
        hotelRoomViewer.setRentalCarViewer(rentalcarViewer);
        hotelRoomViewer.setAirRecordViewer(airRecordViewer);
        hotelRoomViewer.setHotelRecordViewer(hotelRecordViewer);
        hotelRoomViewer.setUserViewer(userViewer);
        hotelRoomViewer.setRentRecordViewer(rentRecordViewer);
        
        rentRecordViewer.setScanner(scanner);
        rentRecordViewer.setAirViewer(airViewer);
        rentRecordViewer.setHotelViewer(hotelViewer);
        rentRecordViewer.setRentalCarViewer(rentalcarViewer);
        rentRecordViewer.setAirRecordViewer(airRecordViewer);
        rentRecordViewer.setHotelRecordViewer(hotelRecordViewer);
        rentRecordViewer.setHotelRoomViewer(hotelRoomViewer);
        rentRecordViewer.setUserViewer(userViewer);
        
        
        userViewer.showIndex();
        
    }

}
