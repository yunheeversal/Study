package miniproject;
// 극장 번호, 극장 이름, 극장 위치, 극장 전화번호가 존재

// 극장 목록, 개별 보기, 극장 상영중 영화 목록 보기 

import java.util.ArrayList;
import java.util.Scanner;

import miniproject.TheaterController;
import util.ScannerUtil;
import miniproject.TheaterDTO;

// 뭐 더 추가할 거 있는지 생각해보자.

public class TheaterViewer {
    private TheaterController theaterController;
    private Scanner scanner;
    private MovieUserViewer movieUserViewer;
    private MovieUserDTO logIn;
    private ScreeningViewer screeningViewer;
    private ScreeningController screeningController;
    

    public TheaterViewer() {
        theaterController = new TheaterController();
        scanner = new Scanner(System.in);
        screeningViewer = new ScreeningViewer();
        screeningViewer.setTheaterViewer(this);

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
        MovieUserViewer  movieUserViewer = new MovieUserViewer();
        String message = "1. 극장 목록 2. 메인 화면으로";
        
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                showIndex();
            } else if(userChoice == 2){
               

            }
        

    }

    // showIndex() 현재 상영중인 영화 목록을 상영정보뷰어랑 연동??
    public void showIndex() {
        ArrayList<TheaterDTO> list = theaterController.selectAll();

        if (list.isEmpty()) {

        } else {
            for (TheaterDTO t : list) {
                System.out.printf("%d. %s %s점\n", t.getTheaterNum(), t.getTheaterName(), t.getTheaterLocation());
            }
        }
        
        String message = "1.극장 개별 보기 2. 뒤로가기 ";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
               printAll();
            } else if (userChoice == 2) {
                showMenu() ;
            }
        }

    }

    public void printAll() {
            String message = "상세보기할 극장의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && theaterController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
                showMenu();
            }


    }

    private void printOne(int theaterNum) {
        TheaterDTO t = theaterController.selectOne(theaterNum);
        String message;
        System.out.println("극장번호: " + t.getTheaterNum());
        System.out.println("극장명: " + t.getTheaterName());
        System.out.println("극장 위치: " + t.getTheaterLocation());
        System.out.println("극장 번호: " + t.getTheaterTel());

        if (logIn.getUserRank() == 3) {
            message = "1. 수정 2. 삭제 3. 목록으로 가기";

            int userChoice = ScannerUtil.nextInt(scanner, message);// 작성자가 아닐 경우 오직 3만
            if (userChoice == 1) {
                update(theaterNum);
            } else if (userChoice == 2) {
                delete(theaterNum);
               
            } else if (userChoice == 3) {

            }
        }
        
 
            message = "1.현재 상영중인 영화 보기 2. 뒤로 가기 ";
         int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
      
          if (userChoice == 1) {
              
              if (logIn.getUserRank() == 3) {
                  screeningViewer.printAll2();
              }else {
                  screeningViewer.printAll();
              }
              
         } 
         
     
        

    }

    private void update(int theaterNum) {
        TheaterDTO t = theaterController.selectOne(theaterNum);

        String message;

        System.out.println("극장명: " + t.getTheaterName());
        System.out.println("극장 위치: " + t.getTheaterLocation());
        System.out.println("극장 전화 번호: " + t.getTheaterTel());
        
        message = "변경할 극장명을 입력해주세요.";
        t.setTheaterName(ScannerUtil.nextLine(scanner, message));
        message = "변경할 극장 위치를 입력해주세요.";
        t.setTheaterLocation(ScannerUtil.nextLine(scanner, message));
        message = "변경할 극장 전화 번호를 입력해주세요.";
        t.setTheaterTel(ScannerUtil.nextLine(scanner, message));


        theaterController.update(t); 

        showMenu();
    }

    // 관리자 전용
    private void delete(int theaterNum) {
        String message = "해당 극장의 정보를 정말 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            theaterController.delete(theaterNum);
            showMenu();
        } else {
            showMenu();
        }
    }
}
