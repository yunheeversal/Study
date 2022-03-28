package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import model.HotelRoomDTO;
import model.HotelDTO;
import model.UserDTO;
import util.ScannerUtil;
import controller.HotelRoomController;

// 7. 방
//방 번호(=id), 호텔 번호, 방 위치(###호), 가격
//단, 예약 가능 목록만 보여줄 수 있도록 합니다.
public class HotelRoomViewer {
    private UserDTO logIn;
    private Scanner scanner;
    private UserViewer userViewer;
    private HotelRecordViewer hotelRecordViewer;
    private HotelViewer hotelViewer;
    private HotelRoomController hotelRoomController;
    
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }
    
    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setHotelRecordViewer(HotelRecordViewer hotelRecordViewer) {
        this.hotelRecordViewer = hotelRecordViewer;
    }

    public void setHotelViewer(HotelViewer hotelViewer) {
        this.hotelViewer = hotelViewer;
    }
    
    public void showMenu() {
        if (logIn.getCategory() == 1) {
            showAdminMenu();
        } else {
            showGeneralMenu();
        }
    }
    
    private void showAdminMenu() {
        String message = "1. 전체 방 정보 보기 2. 신규 방 등록 3. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
//                printAll();
            } else if (userChoice == 2) {
                add();
            } else if (userChoice == 3) {
                System.out.println("뒤로 돌아갑니다.");
                break;
            }
        }
    }

    // 일반 회원의 자기가 예약한 방을 볼 수 있게 하고 싶다... 
    private void showGeneralMenu() {
        String message = "1. 방 목록 보기 2. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
//                printAll();
            } else if (userChoice == 2) {
                System.out.println("뒤로 돌아갑니다.");
                break;
            }

        }
    }

    private void add() {
        HotelRoomDTO h = new HotelRoomDTO();
        String message;
        h.setHotelId(hotelViewer.selectHotelId());
        message = "방의 호실을 입력해주세요."; // 제대로 되는지 점검해보기.
        h.setRoomLocation(ScannerUtil.nextInt(scanner, message));
        System.out.print("호실\n");
        message = "방의 가격을 입력해주세요.";
        h.setRoomPrice(ScannerUtil.nextInt(scanner, message));
        
        hotelRoomController.add(h);
    }
    
    
    
    public void printName(int id) {
        HotelRoomDTO h = hotelRoomController.selectOne(id);
        System.out.print(h.getId());
    }
    
    public int selectHotelRoomId() {
        ArrayList<HotelRoomDTO> list = hotelRoomController.selectAll();

        for (HotelRoomDTO h : list) {
            System.out.printf("%d. " , h.getId());
            System.out.print("호텔명: ");
            hotelViewer.printName(h.getHotelId());  // 이게 맞는지 모르겠음.
            System.out.print("호실: "+ h.getRoomLocation());
        
        }

        String message = "등록할 방의 번호를 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        while (hotelRoomController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }

        return userChoice;
    }

}
