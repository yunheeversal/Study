package viewer;
// 5. 렌터카 대여 기록
//렌터카 대여 번호, 회원 번호, 렌터카 번호, 렌트 시작일, 렌트 종료일
//만약 관리자일 경우, 아직 반납이 안된 렌터카들의 목록을 찾을 수 있습니다.

import java.util.Scanner;
import model.RentRecordDTO;
import model.UserDTO;
import util.ScannerUtil;
import controller.RentRecordController;
public class RentRecordViewer {
    private UserDTO logIn;
    private Scanner scanner;
    private UserViewer userViewer;
    private RentalCarViewer rentalCarViewer;
    private RentRecordController rentRecordController;
    
    public void setRentalCarViewer(RentalCarViewer rentalCarViewer) {
        this.rentalCarViewer = rentalCarViewer;
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
        String message = "1. 전체 차 정보 보기 2. 신규 차 등록 3. 뒤로 가기";
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

    // 일반 회원의 자기가 렌트한 차를 볼 수 있게 하고 싶다... 
    private void showGeneralMenu() {
        String message = "1. 전체 차 목록 보기 2. 뒤로 가기";
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
    
    
 // 뭐 더 넣을거 없는지 확인해 보기... 
    private void add() {
        RentRecordDTO r = new RentRecordDTO();
        String message;
        r.setCarId(rentalCarViewer.selectCarId());
        message = "렌트를 시작할 날짜를 입력해주세요.";
        r.setRentStart(message);
        message = "렌트를 반납할 날짜를 입력해주세요.";
        r.setRentEnd(message);
        
        rentRecordController.add(r);
    }
    
    
    
    
}
