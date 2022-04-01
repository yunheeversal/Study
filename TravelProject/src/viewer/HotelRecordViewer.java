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

    public void printListAdmin() {
        ArrayList<HotelRecordDTO> list = hotelRecordCotroller.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 예약이 존재하지 않습니다.");
        } else {
            System.out.println("-----------------------------");
            for (HotelRecordDTO h : list) {
                    System.out.println("%d." + h.getId());
                    System.out.printf("호실: %d \n" + h.getRoomId());
                    System.out.printf("입실: %s \n" + h.getBookStart());
                    System.out.printf("퇴실: %s \n" + h.getBookEnd());
                
            }
            System.out.println("-----------------------------");
            System.out.println();
            
            String message = "상세보기나 예약할 방의 번호나 뒤로가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && hotelRecordCotroller.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }
            if (userChoice != 0) {
                message = "1. 상세 보기 2. 목록으로 가기";
                int userChoice2 = ScannerUtil.nextInt(scanner, message);
                if (userChoice2 == 1) {
                    printOne(userChoice);
                } else if (userChoice2 == 2) {
                     hotelRoomViewer.showMenu();
                }
            
            }
        }
        
       

    }

    public void printListGeneral(int id) {
        HotelRecordDTO h = hotelRecordCotroller.selectOne(id);

        if (h == null) {
            System.out.println("아직 예약이 존재하지 않습니다.");
        } else {
            System.out.println("-----------------------------");
            System.out.printf("호실: %d \n" + h.getRoomId());
            System.out.printf("입실: %s \n" + h.getBookStart());
            System.out.printf("퇴실: %s \n" + h.getBookEnd());
            System.out.println("-----------------------------");
            System.out.println();
        }

    }
    
    
    private void printOne(int id) {
        HotelRecordDTO h = hotelRecordCotroller.selectOne(id);

        System.out.printf("%d." + h.getId());
        System.out.printf("호실: %d \n" + h.getRoomId());
        System.out.printf("입실: %s \n" + h.getBookStart());
        System.out.printf("퇴실: %s \n" + h.getBookEnd());
        
        String message = "1. 예약 정보 수정 2. 예약 삭제 3.목록으로 돌아가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        }else if (userChoice == 3) {
            
        }
        
    }
    
    private void update(int id) {
        HotelRecordDTO h = hotelRecordCotroller.selectOne(id);
        String message;
        message = "호실을 입력해 주세요.";
        h.setRoomId(ScannerUtil.nextInt(scanner, message));
        message = "입실 날짜를 입력해 주세요.";
        h.setBookStart(ScannerUtil.nextLine(scanner, message));
        message = "퇴실 날짜를 입력해 주세요.";
        h.setBookEnd(ScannerUtil.nextLine(scanner, message));
        
        hotelRecordCotroller.update(h);
    }
    
    
    private void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            hotelRecordCotroller.delete(id);
        } else {
        }

    }

    public void deleteByRoomId(int roomId) {
        hotelRecordCotroller.deleteByRoomId(roomId);

    }


    public void printRecordId(int id) {
        HotelRecordDTO h = hotelRecordCotroller.selectOne(id);
        System.out.print(h.getId());
    }

}
