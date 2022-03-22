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
    
    public TheaterViewer() {
        theaterController = new TheaterController();
        scanner = new Scanner(System.in);

    }
    
    // showMenu()
    public void showMenu() {
        String message = "1. 극장 목록 2. 극장 개별 보기 3. 메인 화면으로";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {

            } else if (userChoice == 2) {
                
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
        
    }
     // showIndex() 현재 상영중인 영화 목록을 상영정보뷰어랑 연동?? 
        public void showIndex() {
            String message = "1.현재 상영중인 영화 보기 2. 관리자 전용 3. 메인화면으로 ";
            while (true) {
                int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
                if (userChoice == 1) {
                    printList();
                } else if (userChoice == 2) {
                  // 관리자 전용 메뉴 
                } else if (userChoice == 3) {
                 System.out.println("사용해주셔서 감사합니다.");
                    break;
                }
            }
        
    }
    // 현재 상영중인 영화 보기 printList()
        // 영화 제목을 써야 하는데.. movie에서 빌려 와야함 ㅠ 
        public void printList() {
            ArrayList<TheaterDTO> list = theaterController.selectAll();
            
            if (list.isEmpty()) {
                System.out.println("아직 상영중인 영화가 존재하지 않습니다.");
            } else {
                for (TheaterDTO t : list) {
//                    System.out.printf("%d. %s\n", 영화 번호 , 영화 제목 );
                }
            
        }
    
}
        
        // 관리자 전용 
        String message;

        int optionMin, optionMax;
//
//        if (b.getWriterId() == logIn.getId()) {
//            message = "1. 수정 2. 삭제 3. 목록으로 가기";
//            optionMin = 1;
//            optionMax = 3;
//
//            int userChoice = ScannerUtil.nextInt(scanner, message, optionMin, optionMax);
//            if (userChoice == 1) {
//                update(id);
//            } else if (userChoice == 2) {
//                delete(id);
//            } else {
//                printAll();
//            }
//        } else {
//            message = "1. 댓글 달기 2. 목록으로 가기";
//            optionMin = 1;
//            optionMax = 2;
//
//            int userChoice = ScannerUtil.nextInt(scanner, message, optionMin, optionMax);
//
//            if (userChoice == 1) {
//                replyViewer.writeReply(logIn.getId(), id);
//                printOne(id);
//            } else if (userChoice == 2) {
//                printAll();
//            }
//        }
        
        
}

