package viewer;
//2. 항공권
//항공권 번호, 출발지, 출발 시간, 도착지, 도착 시간, 좌석
//단, 이미 예매가 완료된 항공권은 리스트에서 보이지 않습니다.

import java.util.ArrayList;
import java.util.Scanner;
import controller.AirController;
import model.UserDTO;
import util.ScannerUtil;
import model.AirDTO;
import model.HotelDTO;

public class AirViewer {
    private UserDTO logIn;
    private Scanner scanner;
    private UserViewer userViewer;
    private AirRecordViewer  airRecordViewer;
    private AirController airController;

    public void setAirRecordViewer(AirRecordViewer airRecordViewer) {
        this.airRecordViewer = airRecordViewer;
    }
    
    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }
    
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
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
        String message = "1. 항공권 전체 목록 보기 2. 신규 항공권 등록 3. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                insertAir();
            } else if (userChoice == 3) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }
        }
    }
    
    private void showGeneralMenu() {
        String message = "1. 항공권 전체 목록 보기 2. 뒤로 가기";
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
    
    private void insertAir() {
        AirDTO a = new AirDTO();

        String message;
        message = "출발지를 입력해주세요.";
        a.setDeparture(ScannerUtil.nextLine(scanner, message));
        message = "출발 시간을 입력해주세요.";
        a.setDepartureTime(ScannerUtil.nextLine(scanner, message));
        message = "도착지를 입력해주세요.";
        a.setArrival(ScannerUtil.nextLine(scanner, message));
        message = "도착 시간을 입력해주세요.";
        a.setArrivalTime(ScannerUtil.nextLine(scanner, message));
      
        airController.add(a);

    }
    
    
    // 예매 완료된 항공권은 숨기는 기능 만들기 
    
    private void printList() {
        ArrayList<AirDTO> list = airController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 항공권이 없습니다.");
        } else {
            for (AirDTO a : list) {
                System.out.printf("%d. 출발지: %s ~  도착지: %s\n", a.getId() ,a.getDeparture(), a.getArrival());
            }

            String message = "상세보기할 항공권의 번호나 뒤로가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && airController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }
    private void printOne(int id) {
        AirDTO a = airController.selectOne(id);

        System.out.println("\n=======================================");
        System.out.println("출발지: " + a.getDeparture());
        System.out.println("출발시간: " + a.getDepartureTime());
        System.out.println("도착지: " + a.getArrival());
        System.out.println("도착시간: " + a.getArrivalTime());
        System.out.println("예약 가능 여부: " + a.getSeat().isEmpty()); //?? 맞나? ㅋㅋ
        System.out.println("=======================================\n");
       
        if (logIn.getCategory() == 1) {
            String message = "1. 항공권 수정 2. 항공권 삭제 3. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                updateAirInfo(id);
            } else if (userChoice == 2) {
                deleteAirInfo(id);
            } else if (userChoice == 3) {
                printList();
            }
        } else {
            String message = "1. 예매하기 2. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                // 예매 뷰어로 가서 예매 기록 남기게 하기.
            } else if (userChoice == 2) {
                printList();
            }
        }
        
    }
    
    
    private void updateAirInfo(int id) {
        AirDTO a = airController.selectOne(id);
             
        System.out.printf("%d. 출발지: %s ~  도착지: %s\n", a.getId() ,a.getDeparture(), a.getArrival());
                
        String message;
        message = "출발지를 입력해주세요.";
        a.setDeparture(ScannerUtil.nextLine(scanner, message));
        message = "출발 시간을 입력해주세요.";
        a.setDepartureTime(ScannerUtil.nextLine(scanner, message));
        message = "도착지를 입력해주세요.";
        a.setArrival(ScannerUtil.nextLine(scanner, message));
        message = "도착 시간을 입력해주세요.";
        a.setArrivalTime(ScannerUtil.nextLine(scanner, message));
      
        airController.update(a);
    }
    
    private void deleteAirInfo(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            airController.delete(id);
//            airRecord.deleteShowByMovieid(id);  나중에 만들기 
            printList();
        } else {
            printOne(id);
        }
    }
    
       
    public int selectAirlId() {
        ArrayList<AirDTO> list = airController.selectAll();

        for (AirDTO a : list) {
            System.out.printf("%d. %s~%s\n", a.getId(), a.getDeparture(), a.getArrival() );
        }

        String message = "등록할 항공권의 번호를 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        while (airController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }

        return userChoice;
    }
    
}
