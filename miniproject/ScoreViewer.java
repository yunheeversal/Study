package miniproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import miniproject.ScoreController;
import util.ScannerUtil;
import miniproject.MovieViewer;

// 평점 번호, 작성 회원 번호, 영화 번호, 평점, 평론
//E. 영화별 전체 평점 보기
//F. 영화별 평론가 평점 보기
//G. 영화별 일반 관람객 평점 보기

// 해야할 것 영화랑 연결해서.. 평점 볼 수 있게 하기. 
public class ScoreViewer {
    private ScoreController scoreController;
    private Scanner scanner;
    private MovieViewer movieViewer;

    public ScoreViewer() {
        scoreController = new ScoreController();
        scanner = new Scanner(System.in);
    }

    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
    }

    public void showMenu() {
        String message = "1. 영화별 전체 평점 보기 2. 영화별 평론가 평점 보기 3. 영화별 일반 관람객 평점 보기 4. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
//                printOne();
            } else if (userChoice == 2) {
//                printTwo();
            } else if (userChoice == 3) {
//                printThree();

            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public void printList(int movieNum) {
        ArrayList<ScoreDTO> list = scoreController.selectAll();

        if (list.isEmpty()) {
            System.out.println("\n아직 해당 영화의 평점이 존재하지 않습니다.\n");
        } else {
            for (ScoreDTO s : list) {
                System.out.printf("%d. %s\n", s.getMovieNum(), s.getMovieReview());
            }
            
            String message = "상세보기할 영화의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && scoreController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

   
    private void printOne(int movieNum) {
       ScoreDTO s = scoreController.selectOne(movieNum);

        // 영화별 전체 평점 보기
       System.out.println("전체 평점");
        System.out.printf("%s - by \n", s.getMovieNum());
        System.out.printf("%s 점 \n", s.getMovieScore());
        System.out.printf("%s  \n", s.getMovieReview());
       
        // 영화별 평론가 평점 보기
        System.out.println("평론가 평점");
        System.out.printf("%s - by \n", s.getMovieNum());
        System.out.printf("%s 점 \n", s.getMovieScore());
        System.out.printf("%s  \n", s.getMovieReview());

        // 영화별 일반 관람객 평점 보기
        System.out.println("일반 관람객 평점");
        System.out.printf("%s - by \n", s.getMovieNum());
        System.out.printf("%s 점 \n", s.getMovieScore());
        System.out.printf("%s  \n", s.getMovieReview());
        
        
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

}
