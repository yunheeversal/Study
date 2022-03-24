package miniproject;

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
    // 평점 상수
    private final int SCORE_MIN = 1;
    private final int SCORE_MAX = 5;

    private ScoreController scoreController;
    private Scanner scanner;
    private MovieViewer movieViewer;
    private MovieUserViewer movieUserViewer;
    private MovieUserDTO logIn;
    private MovieController movieController;

    public ScoreViewer() {
        scoreController = new ScoreController();
        scanner = new Scanner(System.in);
        movieController = new MovieController();
        

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

    // 상세보기를 출력하는 printOne()
    public void printOne(int movieNum) {
        ScoreDTO s = scoreController.selectOne(movieNum);

//        ArrayList<ScoreDTO> temp = scoreController.selectAll();
        String message = "1. 해당 영화 전체 평점 2. 평론가 평점 3. 일반 관람객 평점";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {
            // 영화별 전체 평점 보기
            System.out.println("전체 평점");
            System.out.printf("%s 점 \n", s.getMovieScore());
            System.out.printf("%s  \n", s.getMovieReview());
        } else if (userChoice == 2) {
            // 영화별 평론가 평점 보기
            System.out.println("평론가 평점");
            System.out.printf("%s 점 \n", s.getMovieScore());
            System.out.printf("%s  \n", s.getMovieReview());
        } else if (userChoice == 3) {
            // 영화별 일반 관람객 평점 보기
            System.out.println("일반 관람객 평점");
            System.out.printf("%s 점 \n", s.getMovieScore());
            System.out.printf("%s  \n", s.getMovieReview());
        }

        message = "평점을 등록 하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);
//        movieUserViewer.printRank(logIn.getUserRank());
        if (yesNo.equalsIgnoreCase("Y")) {
            writeScore(movieNum);
//            if (logIn.getUserRank() == 2) {
//                // 전문 평론가 평점 작성
//                writeScore2();
//            } else {
//                // 일반 관람객 평점 작성
//                writeScore();
//            }
        }

    }

    private void writeScore(int movieNum) {
        ScoreDTO s = new ScoreDTO();
        MovieDTO temp = movieController.selectOne(movieNum);

        String message;
        message = "1. 새 평점 등록 2. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {

            message = "평점을 입력해주세요.";
            s.setMovieScore(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
            message = "평론을 입력해주세요.";
            s.setMovieReview(ScannerUtil.nextLine(scanner, message));

            scoreController.add(s);
                       
        }

    }

//    private void writeScore2() {
//        ScoreDTO s = new ScoreDTO();
//        ArrayList<MovieDTO> temp = movieController.selectAll();
//
//        String message;
//        message = "1. 새 평점 등록 2. 뒤로가기";
//        int userChoice = ScannerUtil.nextInt(scanner, message);
//
//        if (userChoice == 1) {
//
//            for (MovieDTO m1 : temp) {
//                System.out.printf("%d번. 제목: %s\n", s.getMovieNum(), m1.getTitle());
//            }
//            message = "평점을 등록할 영화의 번호를 입력해주세요.";
//            s.setMovieNum(ScannerUtil.nextInt(scanner, message));
//            message = "평점을 입력해주세요.";
//            s.setMovieScore(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
//            message = "평론을 입력해주세요.";
//            s.setMovieReview(ScannerUtil.nextLine(scanner, message));
//
//            scoreController.add(s);
//
//        }
//
//    }

}
