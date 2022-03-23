package miniproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import miniproject.ScoreController;
import model.BoardDTO;
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
    private MovieUserViewer movieUserViewer;
    private MovieUserDTO logIn;
    private MovieDTO movieNum;
    private MovieController movieController;

    public ScoreViewer() {
        scoreController = new ScoreController();
        scanner = new Scanner(System.in);
    }

    public void setMovieViewer(MovieViewer movieViewer) {
        this.movieViewer = movieViewer;
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

    public void showMenu() {
        String message = "1. 영화 평점 보기 2.종료";

        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                printAll();

            } else if (userChoice == 2) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public void printAll() {
        ArrayList<MovieDTO> list = movieController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 영화가 존재하지 않습니다.");
        } else {
            for (MovieDTO m : list) {
                System.out.printf("%d번. 제목: %s\n", m.getMovieNum(), m.getTitle());
            }

            String message = "상세보기할 글의 번호나 뒤로 가실려면 0을 입력해주세요.";
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


    // 글 상세보기를 출력하는 printOne()
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
        
        String message;
        int optionMin, optionMax; // 선택 가짓수를 변수로 일단 정한다.
        
        if (logIn.getUserRank() == 3) {
            message = "1. 수정 2. 삭제 3. 목록으로 가기";
            optionMin = 1;
            optionMax = 3;

            int userChoice = ScannerUtil.nextInt(scanner, message, optionMin, optionMax);// 작성자가 아닐 경우 오직 3만
                                                                                         // 입력가능하게 만든것임.
            if (userChoice == 1) {
                update(movieNum);
            } else if (userChoice == 2) {
                delete(movieNum);
            } else if (userChoice == 3) {
               
            } 
        }
        System.out.println("권한이 없습니다.");
       

    }

//    // 관리자 페이지
//    private void scoreManager(int scoreNum) {
//        ScoreDTO s = scoreController.selectOne(scoreNum);
//        movieViewer.printList();
//
//        // 관리자 전용
//        if (logIn.getUserRank() == 3) {
//            String message = "1. 수정 2. 삭제  3. 뒤로 가기 ";
//            int userChoice = ScannerUtil.nextInt(scanner, message);
//
//            if (userChoice == 1) {
//                update(scoreNum);
//            } else if (userChoice == 2) {
//                delete();
//            } else if (userChoice == 3) {
//                printAll();
//            }
//
//        } else {
//            System.out.println("권한이 없습니다.");
//            printAll();
//        }
//
//    }

    private void update(int scoreNum) {
        
        ScoreDTO s = scoreController.selectOne(scoreNum);

        String message;

        message = "새로운 평점을 입력해주세요.";
        s.setMovieScore(ScannerUtil.nextInt(scanner, message));
        message = "새로운 평론 입력해주세요.";
        s.setMovieReview(ScannerUtil.nextLine(scanner, message));

        message = "정말로 수정하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            scoreController.update(s);
            printOne(s.getScoreNum());
        }

       
    }

    private void delete(int scoreNum) {
        ScoreDTO s = new ScoreDTO();
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            scoreController.delete(s.getScoreNum());
            printAll();
        } else {
            
        }
    }
}
