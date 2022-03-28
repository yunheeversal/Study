package viewer;
// 6. 호텔
//호텔 번호, 호텔 이름, 호텔 위치, 등급(5성, 4성 등등), 호텔 전화번호

import java.util.ArrayList;
import java.util.Scanner;

import model.UserDTO;
import util.ScannerUtil;
import model.HotelDTO;
import model.HotelRoomDTO;
import controller.HotelController;

public class HotelViewer {
    private UserDTO logIn;
    private Scanner scanner;
    private UserViewer userViewer;
    private HotelRoomViewer hotelRoomViewer;
    private HotelRecordViewer hotelRecordViewer;
    private HotelController hotelController;
    
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setHotelRoomViewer(HotelRoomViewer hotelRoomViewer) {
        this.hotelRoomViewer = hotelRoomViewer;
    }

    public void setHotelRecordViewer(HotelRecordViewer hotelRecordViewer) {
        this.hotelRecordViewer = hotelRecordViewer;
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
        String message = "1. 호텔 전체 목록 보기 2. 신규 호텔 등록 3. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                insertHotel();
            } else if (userChoice == 3) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }
        }
    }
    
    private void showGeneralMenu() {
        String message = "1. 호텔 전체 목록 보기 2. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }
        }
    }
    
    private void insertHotel() {
        HotelDTO h = new HotelDTO();

        String message;
        message = "호텔명을 입력해주세요.";
        h.setHotelName(ScannerUtil.nextLine(scanner, message));
        message = "호텔 주소를 입력해주세요.";
        h.setHotelAddress(ScannerUtil.nextLine(scanner, message));
        message = "호텔 등급을 입력해주세요.";
        h.setHotelGrade(ScannerUtil.nextInt(scanner, message));
        message = "호텔 전화번호를 입력해주세요.";
        h.setHotelTel(ScannerUtil.nextLine(scanner, message));
      
        hotelController.add(h);

    }
    
    private void printList() {
        ArrayList<HotelDTO> list = hotelController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 호텔이 없습니다.");
        } else {
            for (HotelDTO h : list) {
                System.out.printf("%d. %s\n", h.getId(), h.getHotelName());
            }

            String message = "상세보기할 호텔의 번호나 뒤로가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && hotelController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }
    
    private void printOne(int id) {
        HotelDTO h = hotelController.selectOne(id);

        System.out.println("\n=======================================");
        System.out.println("호텔 이름: " + h.getHotelName() );
        System.out.println("호텔 주소: " + h.getHotelAddress() );
        System.out.println("호텔 등급: " + h.getHotelGrade() + "성");
        System.out.println("호텔 전화 번호: " + h.getHotelTel());
        System.out.println("=======================================\n");
       
        if (logIn.getCategory() == 1) {
            String message = "1. 호텔 수정 2. 호텔 삭제 3. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                updateHotelInfo(id);
            } else if (userChoice == 2) {
                deleteHotelInfo(id);
            } else if (userChoice == 3) {
                printList();
            }
        } else {
            String message = "1. 호텔 예약하기 2. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                // 예매 뷰어로 가서 예매 기록 남기게 하기.
                // hotelRoomViewer.showMenu();
            } else if (userChoice == 2) {
                printList();
            }
        }
        
    }
    
    private void updateHotelInfo(int id) {
        HotelDTO h = hotelController.selectOne(id);
                
        System.out.printf("%d. %s\n", h.getId(), h.getHotelName());
        
        String message;
        message = "호텔명을 입력해주세요.";
        h.setHotelName(ScannerUtil.nextLine(scanner, message));
        message = "호텔 주소를 입력해주세요.";
        h.setHotelAddress(ScannerUtil.nextLine(scanner, message));
        message = "호텔 등급을 입력해주세요.";
        h.setHotelGrade(ScannerUtil.nextInt(scanner, message));
        message = "호텔 전화번호를 입력해주세요.";
        h.setHotelTel(ScannerUtil.nextLine(scanner, message));
      
        hotelController.update(h);
    }
    
    private void deleteHotelInfo(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            hotelController.delete(id);
//            hotelRecord.deleteShowByMovieid(id);  나중에 만들기 
            printList();
        } else {
            printOne(id);
        }
    }
    
    
    
    
    
    
    
    
    
    
    public void printName(int id) {
        HotelDTO h = hotelController.selectOne(id);
        System.out.print(h.getHotelName());
    }
    
    public int selectHotelId() {
        ArrayList<HotelDTO> list = hotelController.selectAll();

        for (HotelDTO h : list) {
            System.out.printf("%d. %s\n", h.getId(), h.getHotelName());
        }

        String message = "등록할 방의 번호를 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        while (hotelController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }

        return userChoice;
    }
    
    
    
}
