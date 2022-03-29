package viewer;

import java.util.ArrayList;
import java.util.Scanner;
import model.HotelRecordDTO;
import model.HotelRoomDTO;
import model.UserDTO;
import util.ScannerUtil;
import controller.HotelRecordController;
import controller.HotelRoomController;

// 8. 방 예약 기록
//방 예약 번호, 방 번호, 예약 시작일, 예약 종료일
public class HotelRecordViewer {
    private HotelViewer hotelViewer; 
    private AirViewer airViewer; 
    private RentalCarViewer rentalCarViewer; 
    private AirRecordViewer airRecordViewer;
    private HotelRoomViewer hotelRoomViewer;
    private HotelRecordViewer hotelRecordViewer;
    private RentRecordViewer rentRecordViewer;
    private UserDTO logIn;
    private Scanner scanner;
    private UserViewer userViewer;
    private HotelRecordController hotelRecordCotroller;

    public HotelRecordViewer() {
        hotelRecordCotroller = new HotelRecordController();
    }
    
    
    public void setAirViewer(AirViewer airViewer) {
        this.airViewer = airViewer;
    }

    public void setRentalCarViewer(RentalCarViewer rentalCarViewer) {
        this.rentalCarViewer = rentalCarViewer;
    }

    public void setAirRecordViewer(AirRecordViewer airRecordViewer) {
        this.airRecordViewer = airRecordViewer;
    }

    public void setHotelRecordViewer(HotelRecordViewer hotelRecordViewer) {
        this.hotelRecordViewer = hotelRecordViewer;
    }

    public void setRentRecordViewer(RentRecordViewer rentRecordViewer) {
        this.rentRecordViewer = rentRecordViewer;
    }

    public void setHotelViewer(HotelViewer hotelViewer) {
        this.hotelViewer = hotelViewer;
    }

    public void setHotelRoomViewer(HotelRoomViewer hotelRoomViewer) {
        this.hotelRoomViewer = hotelRoomViewer;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }
    
    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }
    
    public void showMenu() {
        if (logIn.getCategory() == 1) {
            showAdminMenu();
        } else {
            showGeneralMenu();
        }
    }

    private void showAdminMenu() {
        String message = "1. 전체 예약 정보 보기 2. 신규 예약 등록 3. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                printAll();
            } else if (userChoice == 2) {
                add();
            } else if (userChoice == 3) {
                System.out.println("뒤로 돌아갑니다.");
                break;
            }
        }
    }
 
    private void showGeneralMenu() {
        String message = "1. 예약하기 2. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                add();
            } else if (userChoice == 2) {
                System.out.println("뒤로 돌아갑니다.");
                break;
            }

        }
    }

    private void printAll() {
        ArrayList<HotelRecordDTO> list = hotelRecordCotroller.selectAll();

        for (HotelRecordDTO h : list) {
            
            System.out.printf("%d. \n", h.getId());
            System.out.printf("%s ~ %s \n", h.getBookStart(), h.getBookEnd());
        }
    }
    
    private void add() {
        HotelRecordDTO h = new HotelRecordDTO();
        String message;
        message = "방의 호실을 입력해 주세요.";
        h.setRoomId(hotelRoomViewer.selectHotelRoomId());
        message = "입실 날짜를 입력해 주세요.";
        h.setBookStart(ScannerUtil.nextLine(scanner, message));
        message = "퇴실 날짜를 입력해 주세요.";
        h.setBookEnd(ScannerUtil.nextLine(scanner, message));
        
        hotelRecordCotroller.add(h);
        System.out.println("예약이 완료 되었습니다.");
        
    }
    
    public void deleteByRoomId(int roomId) {
        hotelRecordCotroller.deleteByRoomId(roomId);
        
    }
  
    
}
