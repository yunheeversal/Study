package viewer;
//3. 항공권 예매 기록
//예매 번호, 항공권 번호, 예매 회원 번호, 예매일

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import model.AirRecordDTO;
import model.UserDTO;
import util.ScannerUtil;
import controller.AirRecordController;
public class AirRecordViewer {
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
    private AirRecordController airRecordController;
    
    public AirRecordViewer() {
        airRecordController = new AirRecordController();
    }
    
    public void setHotelViewer(HotelViewer hotelViewer) {
        this.hotelViewer = hotelViewer;
    }


    public void setRentalCarViewer(RentalCarViewer rentalCarViewer) {
        this.rentalCarViewer = rentalCarViewer;
    }



    public void setHotelRoomViewer(HotelRoomViewer hotelRoomViewer) {
        this.hotelRoomViewer = hotelRoomViewer;
    }


    public void setHotelRecordViewer(HotelRecordViewer hotelRecordViewer) {
        this.hotelRecordViewer = hotelRecordViewer;
    }


    public void setRentRecordViewer(RentRecordViewer rentRecordViewer) {
        this.rentRecordViewer = rentRecordViewer;
    }


    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }


    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }


    public void setAirViewer(AirViewer airViewer) {
        this.airViewer = airViewer;
    }


    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    
    public void showMenu() {
        if (logIn.getCategory() == 3) {
            showGeneralMenu();
        } else {
            showAdminMenu();
        }
    }
    
    // 예약자가 예매한걸 볼 수 있게 만들고 -> 예매 확정 처리?? 
    private void showAdminMenu() {
        ArrayList<AirRecordDTO> list;
        String message = "1. 전체 항공 예약 정보 보기 2. 신규 예약 승인 3. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                printAll();
            } else if (userChoice == 2) {
//                add();
            } else if (userChoice == 3) {
                System.out.println("뒤로 돌아갑니다.");
                break;
            }
        }
    }

    // 유저의 본인이 예약한 목록 볼 수 있게..
    private void showGeneralMenu() {
        String message = "1. 나의 예매 내역 보기 2. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                String usernameMsg = "아이디를 입력해주세요.";
                int userId = ScannerUtil.nextInt(scanner, usernameMsg);
                printOne(userId);
            }else if (userChoice == 2) {
                System.out.println("뒤로 돌아갑니다.");
                break;
            }
        }
       
        
    }
    
    // 관리자 전용/ 다시 점검해 보기. - 다른 뷰어에서 가져오는 부분!! 
    private void printAll() {
        ArrayList<AirRecordDTO> list = airRecordController.selectAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yy/m/d H:m");
        
        for(AirRecordDTO a : list) {
            System.out.println("\n===================================");
            System.out.printf("%d. ", a.getId());
            System.out.printf("예매일: %s", sdf.format(a.getReservationDate().getTime()));
            System.out.printf("항공권 번호: ", a.getTicketId());
            System.out.printf("예약자 ID", a.getUserId());
            System.out.print("예약자 닉네임: ");
            userViewer.printNickname(a.getUserId()); // 이게 맞나?
            System.out.println("===================================\n");
        }
      
        String message = "상세보기할 예매 내역의 번호나 뒤로가실려면 0을 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        while (userChoice != 0 && airRecordController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }

        if (userChoice != 0) {
            printOne(userChoice);
        }
    }
    
    private void printOne(int id) {
        AirRecordDTO a = airRecordController.selectOne(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yy/m/d H:m");
        
        System.out.println("\n----------------------------------------");
        System.out.println(logIn.getUsername() + "회원님의 예약 정보");
        System.out.println("========================================");
        System.out.printf("%d. ", a.getId());
        System.out.printf("예매일: %s", sdf.format(a.getReservationDate().getTime()));
        System.out.printf("항공권 번호: ", a.getTicketId());
        System.out.printf("예약자 ID", a.getUserId());
        System.out.print("예약자 닉네임: ");
        userViewer.printNickname(a.getUserId()); // 이게 맞나?
        System.out.println("----------------------------------------\n");
        
        if (logIn.getCategory() == 1) {
        String message = "1. 예매 정보 수정 2. 예매 삭제 3. 목록으로 돌아가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        if (userChoice == 1) {
            updateBookingInfo(id);
        } else if (userChoice == 2) {
            deleteBookingInfo(id);
        } else if (userChoice == 3) {
            printAll();
        }
        }else {
            
        }
        
        
    }

    private void updateBookingInfo(int id) {
        AirRecordDTO a = airRecordController.selectOne(id);
        
        String message = "새로운 항공권 번호를 입력해주세요.";
        a.setTicketId(ScannerUtil.nextInt(scanner, message));
        
        airRecordController.update(a);
    }
    
    private void deleteBookingInfo(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            airRecordController.delete(id);
            printAll();
        } else {
            printOne(id);
        }
        
    }
    
    
    
    
}
