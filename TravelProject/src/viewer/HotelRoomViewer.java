package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import model.HotelRoomDTO;
import model.AirDTO;
import model.HotelDTO;
import model.HotelRecordDTO;
import model.UserDTO;
import util.ScannerUtil;
import controller.HotelController;
import controller.HotelRoomController;

// 7. 방
//방 번호(=id), 호텔 번호, 방 위치(###호), 가격
//단, 예약 가능 목록만 보여줄 수 있도록 합니다.
public class HotelRoomViewer {
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
    private HotelRoomController hotelRoomController;
    
    public HotelRoomViewer() {
        hotelRoomController = new HotelRoomController();
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

    public void setRentRecordViewer(RentRecordViewer rentRecordViewer) {
        this.rentRecordViewer = rentRecordViewer;
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
                printList();
            } else if (userChoice == 2) {
                System.out.println("뒤로 돌아갑니다.");
                break;
            }

        }
    }

    private void printList() {
        ArrayList<HotelRoomDTO> list = hotelRoomController.selectAll();
        
        if (list.isEmpty()) {
            System.out.println("아직 예약 가능한 방이 없습니다.");
        } else {
            for (HotelRoomDTO h : list) {
                System.out.printf("%d. 호실: %s\n",h.getHotelId(), h.getRoomLocation());
            }

            String message = "상세보기할 방의 번호나 뒤로가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && hotelRoomController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
        
    }
    
    private void printOne(int id) {
        HotelRoomDTO h = hotelRoomController.selectOne(id);
        System.out.println("\n=======================================");
        System.out.println("호실: " + h.getRoomLocation());
        System.out.println("가격: "+  h.getRoomPrice());
        
        System.out.println("=======================================\n");
       
        if (logIn.getCategory() == 1) {
            String message = "1. 방 정보 수정 2. 방 삭제 3. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                updateRoomInfo(id);
            } else if (userChoice == 2) {
                deleteRoomInfo(id);
            } else if (userChoice == 3) {
                printList();
            }
        } else {
            String message = "1. 예약 메뉴 2. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                hotelRecordViewer.showMenu();

            }else if (userChoice == 2) {
                printList();
            }
        }
    }
    
    
    private void updateRoomInfo(int id) {
        HotelRoomDTO h = hotelRoomController.selectOne(id);
        String message;
        message = "호실을 입력해주세요.";
        h.setRoomLocation(ScannerUtil.nextInt(scanner, message));
        message = "해당 호실의 가격을 입력해주세요.";
        h.setRoomPrice(ScannerUtil.nextInt(scanner, message));
        
        hotelRoomController.update(h);
    }
    
    private void deleteRoomInfo(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            hotelRoomController.delete(id);
//            airRecord.deleteShowByMovieid(id);  나중에 만들기 
            printList();
        } else {
            printOne(id);
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
    
    private void deleteHoteRoomlInfo(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            hotelRoomController.delete(id);
            hotelRecordViewer.deleteByRoomId(id);
            
        } else {
            
        }
    }
    
    
    public void printName(int id) {
        HotelRoomDTO h = hotelRoomController.selectOne(id);
        System.out.print(h.getId());
    }
    
    public int selectHotelRoomId() {
        ArrayList<HotelRoomDTO> list = hotelRoomController.selectAll();

        for (HotelRoomDTO h : list) {
            System.out.printf("%d. " , h.getId());
//            System.out.print("호텔명: ");
//            hotelViewer.printName(h.getHotelId());  // 이게 맞는지 모르겠음.
            System.out.print("호실: "+ h.getRoomLocation());
            System.out.println();
        
        }

        String message = "등록할 방의 번호를 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        while (hotelRoomController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }

        return userChoice;
    }
    
    public void deleteByHotelId(int hotelId) {
        hotelRoomController.deleteByHotelId(hotelId);
    }

}
