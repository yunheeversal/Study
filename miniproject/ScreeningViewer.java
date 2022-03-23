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
    
    private MovieUserViewer movieUserViewer; 
    private MovieUserDTO logIn;
    
    
    public ScreeningViewer() {
        scanner = new Scanner(System.in);
        screeningController = new ScreeningController();
    }
    // 로그인 정보를 위한 유저 뷰어    
    public void setMovieUserViewer(MovieUserViewer movieUserViewer) {
        this.movieUserViewer = movieUserViewer;
    }
    
    public void setLogIn(MovieUserDTO m) {
        if (m != null) {
            logIn = new MovieUserDTO(m);
        } else {
            logIn = null;
        }
    }
    
    // showMenu()
    public void showMenu() {
        String message = "1. 상영정보 목록 2. 메인화면으로";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            
            if (userChoice == 1) {
                showIndex();
            } else if (userChoice == 2) {
//                movieUserViewer.showMenu();
                
              }
        }
        
    }
    
    // showIndex()
    public void showIndex() {
        String message = "1.현재 상영중인 영화 보기 2. 뒤로 가기 ";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
          
            if (userChoice == 1) {
                printAll();
            } else if (userChoice == 2) {
                showMenu();
            
            }
        }
        
    }
    
    // printOne()
    private void printAll() {
        ArrayList<ScreeningDTO> temp = screeningController.selectAll();
        MovieDTO m = new MovieDTO();
        
        if (temp.isEmpty()) {
            System.out.println("등록된 영화 정보가 존재하지 않습니다.");
        } else {
            for (ScreeningDTO s : temp) {
                System.out.printf("%d번. %s\n", s.getScreeningNum(), m.getTitle() );// 영화 제목도 넣어야해
            }
         
            String message = "상세보기할 영화의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && screeningController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
            
        }
        
        
        
    }
    
 // 상영 영화 개별 보기  영화 제목 넣기.. ㅠ
    private void printOne(int screeningNum) {
        ScreeningDTO s = screeningController.selectOne(screeningNum);
        
        // 관리자 전용 메뉴 
        int optionMin, optionMax; // 선택 가짓수를 변수로 일단 정한다.
        if (logIn.getUserRank() == 3) {
            String message = "1. 수정 2. 삭제 3. 목록으로 가기";
            optionMin = 1;
            optionMax = 3;

            int userChoice1 = ScannerUtil.nextInt(scanner, message, optionMin, optionMax);// 작성자가 아닐 경우 오직 3만
                                                                                         // 입력가능하게 만든것임.
            if (userChoice1 == 1) {
                update(screeningNum);
            } else if (userChoice1 == 2) {
                delete(screeningNum);
            } else if (userChoice1 == 3) {
               
            } 
        }
        System.out.println("권한이 없습니다.");
        
        
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

//        message = "정말로 수정하시겠습니까? Y/N";
//        String yesNo = ScannerUtil.nextLine(scanner, message);
//
//        if (yesNo.equalsIgnoreCase("Y")) {
            screeningController.update(s);
//        }

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
