package viewer;

import java.util.ArrayList;
import java.util.Scanner;
import model.HotelRecordDTO;
import model.UserDTO;
import util.ScannerUtil;
import controller.HotelRecordController;

// 8. 방 예약 기록
//방 예약 번호, 방 번호, 예약 시작일, 예약 종료일
public class HotelRecordViewer {
    
    private UserDTO logIn;
    private Scanner scanner;
    private UserViewer userViewer;
    private HotelViewer hotelViewer;
    private HotelRoomViewer hotelRoomViewer;
    private HotelRecordController hotelRecordCotroller;

    
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
//            showGeneralMenu();
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
// 
//    private void showGeneralMenu() {
//        HotelRecordDTO h = new HotelRecordDTO();
//        String message = "1. 예약 목록 보기 2. 뒤로 가기";
//        while (true) {
//            int userChoice = ScannerUtil.nextInt(scanner, message);
//
//            if (userChoice == 1) {
//                printOne();
//            } else if (userChoice == 2) {
//                System.out.println("뒤로 돌아갑니다.");
//                break;
//            }
//
//        }
//    }

    private void printAll() {
        ArrayList<HotelRecordDTO> list = hotelRecordCotroller.selectAll();

        for (HotelRecordDTO h : list) {
            
            System.out.printf("%d. ", h.getId());
            System.out.print("호실: ");
            hotelRoomViewer.printName(h.getRoomId());
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
        
    }
    
    
}
