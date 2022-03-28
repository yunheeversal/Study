package viewer;
// 4. 렌터카
//렌터카 번호, 차량 등록 번호(=흔히 말하는 번호판 번호), 차종, 색깔
//만약 고객이 해당 렌터카를 예약 했을 경우, 더이상 예약 가능 목록에 보이지 않습니다.

import java.util.ArrayList;
import java.util.Scanner;
import controller.RentalCarController;
import model.UserDTO;
import util.ScannerUtil;
import model.HotelDTO;
import model.RentalCarDTO;

public class RentalCarViewer {
    private UserDTO logIn;
    private Scanner scanner;
    private UserViewer userViewer;
    private RentalCarController rentalCarController;
    private RentRecordViewer rentRecordViewer;

    
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setRentRecordViewer(RentRecordViewer rentRecordViewer) {
        this.rentRecordViewer = rentRecordViewer;
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
        String message = "1. 렌터카 전체 목록 보기 2. 신규 렌터카 등록 3. 뒤로 가기";
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
        String message = "1. 렌터카 전체 목록 보기 2. 뒤로 가기";
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
        RentalCarDTO r = new RentalCarDTO();

        String message;
        message = "차량 번호를 입력해주세요.";
        r.setCarId(ScannerUtil.nextLine(scanner, message));
        message = "차종을 입력해주세요.";
        r.setCarModel(ScannerUtil.nextLine(scanner, message));
        message = "색깔을 입력해주세요.";
        r.setCarColor(ScannerUtil.nextLine(scanner, message));
      
        rentalCarController.add(r);
    }
    
    private void printList() {
        ArrayList<RentalCarDTO> list = rentalCarController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 렌터카가 없습니다.");
        } else {
            for (RentalCarDTO r : list) {
                System.out.printf("%d. %s\n", r.getId(), r.getCarId());
            }

            String message = "상세보기할 차량의 번호나 뒤로가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && rentalCarController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }
    
    private void printOne(int id) {
        RentalCarDTO r = rentalCarController.selectOne(id);

        System.out.println("\n=======================================");
        System.out.println("차량 번호: " + r.getCarId() );
        System.out.println("차종: " + r.getCarModel() );
        System.out.println("색깔: " + r.getCarColor() );
        System.out.println("=======================================\n");
       
        if (logIn.getCategory() == 1) {
            String message = "1. 차량 수정 2. 차량 삭제 3. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                updateCarInfo(id);
            } else if (userChoice == 2) {
                deleteCarInfo(id);
            } else if (userChoice == 3) {
                printList();
            }
        } else {
            String message = "1. 호텔 예약하기 2. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                // 예약 뷰어로 가서 기록 남기게 하기.
                // rentRecordRoomViewer.showMenu();
            } else if (userChoice == 2) {
                printList();
            }
        }
        
    }
    
    private void updateCarInfo(int id) {
        RentalCarDTO r = rentalCarController.selectOne(id);

        System.out.printf("%d. %s\n", r.getId(), r.getCarId());
        
        String message;
        message = "차량 번호를 입력해주세요.";
        r.setCarId(ScannerUtil.nextLine(scanner, message));
        message = "차종을 입력해주세요.";
        r.setCarModel(ScannerUtil.nextLine(scanner, message));
        message = "색깔을 입력해주세요.";
        r.setCarColor(ScannerUtil.nextLine(scanner, message));
      
        rentalCarController.update(r);
    }
    
    private void deleteCarInfo(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            rentalCarController.delete(id);
//            hotelRecord.deleteShowByMovieid(id);  나중에 만들기 
            printList();
        } else {
            printOne(id);
        }
    }
    
    
    public int selectCarId() {
        ArrayList<RentalCarDTO> list = rentalCarController.selectAll();

        for (RentalCarDTO r : list) {
            System.out.printf("%d. %s\n", r.getId(), r.getCarId());
        }

        String message = "등록할 차의 번호를 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        while (rentalCarController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }

        return userChoice;
    }
    
}
