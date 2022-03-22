package miniproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import miniproject.ScreeningController;
import util.ScannerUtil;

// 상영정보 번호, 영화 번호, 극장 번호, 상영 시간
// M. 해당 극장 상영중인 영화 목록 보기
//Q. (관리자 전용) 새로운 상영정보 등록하기
//R. (관리자 전용) 기존 상영정보 수정하기
//S. (관리자 전용) 기존 상영정보 삭제하기

public class ScreeningViewer {
    private final String DATE_FORMAT = "yy-MM-dd H:m";

    private Scanner scanner;
    private ScreeningController screeningController;
    
    public ScreeningViewer() {
        scanner = new Scanner(System.in);
        screeningController = new ScreeningController();
    }
    
    // showMenu()
    public void showMenu() {
        String message = "1. 상영정보 목록 2. 관리자 전용 3. 메인화면으로";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {

            } else if (userChoice == 2) {
                // 관리자 전용 메뉴 
              } else if (userChoice == 3) {
               System.out.println("사용해주셔서 감사합니다.");
                  break;
              }
        }
        
    }
    
    // showIndex()
    public void showIndex() {
        String message = "1.현재 상영중인 영화 보기 2. 메인화면으로 ";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
             System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
        
    }
    
    // printOne()
    private void printOne(int id) {
        
        
    }
    
 // 상영 영화 개별 보기  영화 제목 넣기.. ㅠ
    private void printList() {
        ArrayList<ScreeningDTO> temp = screeningController.selectAll();

        if (temp.isEmpty()) {
            System.out.println("등록된 영화 정보가 존재하지 않습니다.");
        } else {
            for (ScreeningDTO s : temp) {
                System.out.printf("%d번. %s\n", s.getMovieNum() );// 영화 제목도 넣어야해
            }
         
        }
        
        
    }
    
    // 관리자 전용 
    private void update(int screeningNum) {
        ScreeningDTO s = screeningController.selectOne(screeningNum);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        String message;

        message = "새로운 영화 번호를 입력해주세요.";
        s.setMovieNum(ScannerUtil.nextInt(scanner, message));
        message = "새로운 극장 번호를 입력해주세요.";
        s.setTheaterNum(ScannerUtil.nextInt(scanner, message));
        message = "새로운 상영시간을 입력해주세요.";
        System.out.println("작성일: " + sdf.format(s.getScreeningDate())); 
        // 상영시간 다시 하기 

        message = "정말로 수정하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            screeningController.update(s);
        }

        printOne(screeningNum); // ?? 이거 다시 확인하기 
    }

    // 관리자 전용 
    private void delete(int screeningNum) {
        String message = "해당 상영 정보를 정말 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            screeningController.delete(screeningNum);
//            printList();
        } else {
            printOne(screeningNum);
        }
    } 
    
}
