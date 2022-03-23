package miniproject;

import java.util.ArrayList;
import java.util.Scanner;

import miniproject.MovieController;
import util.ScannerUtil;

// 영화 목록 보기, 개별 보기, 영화별 전체, 평론가, 일반 관람객 평점 보기
// 관리자 전용: 등록, 수정, 삭제 
// 해야 할일: 평점보기, 관리자 전용 !! 
public class MovieViewer {

    private MovieController movieController;
    private Scanner scanner;
    private ScoreViewer scoreViewer;
    private MovieUserViewer movieUserViewer;
    private MovieUserDTO logIn;

    public MovieViewer() {
        movieController = new MovieController();
        scanner = new Scanner(System.in);
    }
    // 다른 뷰어 연결

    // 평점 뷰어
    public void setScoreViewer(ScoreViewer scoreViewer) {
        this.scoreViewer = scoreViewer;
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

    // 메뉴를 출력하는 showMenu() - 목록
    public void showMenu() {
        String message = "1. 영화 개별 보기 2. 메인화면으로";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    // 영화 개별 보기
    public void printList() {
        ArrayList<MovieDTO> temp = movieController.selectAll();
        if (temp.isEmpty()) {
            System.out.println("등록된 영화 정보가 존재하지 않습니다.");
            movieUserViewer.showMenu();
        } else {
            for (MovieDTO m : temp) {
                System.out.printf("%d번. 제목: %s\n", m.getMovieNum(), m.getTitle());
            }
            String message = "상세보기할 영화의 번호나 뒤로 가시려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && movieController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

    private void printOne(int movieNum) {
        MovieDTO m = movieController.selectOne(movieNum);

        System.out.print("영화 번호:" + m.getMovieNum() + "번");
        System.out.println(" 제목: " + m.getTitle());
        System.out.println("관람 등급: " + m.getRating());
        System.out.println("줄거리: " + m.getSummary());

        String message;
        int optionMin, optionMax; // 선택 가짓수를 변수로 일단 정한다.

        MovieDTO mo = movieController.selectOne(m.getMovieNum());
        if (logIn.getUserRank() == 3) {
            message = "1. 수정 2. 삭제 3. 목록으로 가기";
            optionMin = 1;
            optionMax = 3;

            int userChoice = ScannerUtil.nextInt(scanner, message, optionMin, optionMax);// 작성자가 아닐 경우 오직 3만
            if (userChoice == 1) {
                update(m.getMovieNum());
            } else if (userChoice == 2) {
                delete(m.getMovieNum());
            } else if (userChoice == 3) {

            }
        } else {

            message = "> 해당 영화의 평점보러 갈까요? (Y / N)";
            String yesNo = ScannerUtil.nextLine(scanner, message);

            if (yesNo.equalsIgnoreCase("Y")) {
                scoreViewer.printOne(movieNum);
            }

        }

    }

    // 관리자 전용
    private void update(int movieNum) {
        MovieDTO m = movieController.selectOne(movieNum);

        String message;

        message = "새로운 영화 제목을 입력해주세요.";
        m.setTitle(ScannerUtil.nextLine(scanner, message));
//        String title =ScannerUtil.nextLine(scanner, message);
        message = "새로운 영화 줄거리를 입력해주세요.";
        m.setSummary(ScannerUtil.nextLine(scanner, message));
//        String summary =ScannerUtil.nextLine(scanner, message);
        message = "새로운 영화 등급을 입력해주세요.";
        m.setRating(ScannerUtil.nextLine(scanner, message));
//        String rating =ScannerUtil.nextLine(scanner, message);
//
//        message = "정말로 수정하시겠습니까? Y/N";
//        String yesNo = ScannerUtil.nextLine(scanner, message);

        movieController.update(m); // 업데이트가 안됨. 여기서 막힘.
//        if (yesNo.equalsIgnoreCase("Y")) {
//            MovieDTO m1 = new MovieDTO();
//            m1.setTitle(title);
//            m1.setSummary(summary);
//            m1.setRating(rating);
//            
//            movieController.add(m1); // 수정 삭제가 안된다.. 
//            movieController.update(m);
//        }

        showMenu(); // ?? 이거 다시 확인하기
    }

    // 관리자 전용
    private void delete(int movieNum) {
        String message = "해당 영화의 정보를 정말 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            movieController.delete(movieNum);
            printList();
        } else {
            showMenu();
        }
    }

}
