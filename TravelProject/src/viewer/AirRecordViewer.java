package viewer;
//3. 항공권 예매 기록
//예매 번호, 항공권 번호, 예매 회원 번호, 예매일

import java.util.Scanner;
import model.AirRecordDTO;
import model.UserDTO;
import util.ScannerUtil;
import controller.AirRecordController;
public class AirRecordViewer {
    private UserDTO logIn;
    private Scanner scanner;
    private UserViewer userViewer;
    private AirViewer airViewer;
    private AirRecordController airRecordController;
    
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
        if (logIn.getCategory() == 1) {
            showAdminMenu();
        } else {
            showGeneralMenu();
        }
    }
    
    
    private void showAdminMenu() {
        String message = "1. 전체 항공 예약 정보 보기 2. 신규 예약 등록 3. 뒤로 가기";
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

    // 유저의 본인이 예약한 목록 볼 수 있게..
    private void showGeneralMenu() {
        String message = "1. 예약 목록 보기 2. 뒤로 가기";
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
        AirRecordDTO a = new AirRecordDTO();
        String message;
        a.setTicketId(airViewer.selectAirlId());
        
        airRecordController.add(a);
    }
    
    
}
