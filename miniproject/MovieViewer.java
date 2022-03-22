package miniproject;

import java.util.ArrayList;
import java.util.Scanner;

import miniproject.MovieController;
import model.StudentDTO;
import util.ScannerUtil;

// 영화 목록 보기, 개별 보기, 영화별 전체, 평론가, 일반 관람객 평점 보기
// 관리자 전용: 등록, 수정, 삭제 
// 해야 할일: 평점보기, 관리자 전용 !! 
public class MovieViewer {
    
    private MovieController movieController;
    private Scanner scanner;

    public MovieViewer() {
        movieController = new MovieController();
        scanner = new Scanner(System.in);
    }
    
 // 메뉴를 출력하는 showMenu() - 목록
    public void showMenu() {
        String message = "1. 영화 개별 보기 2. 관리자 전용 3. 메인화면으로";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

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
    // 영화 개별 보기
    private void printList() {
        ArrayList<MovieDTO> temp = movieController.selectAll();

        if (temp.isEmpty()) {
            System.out.println("등록된 영화 정보가 존재하지 않습니다.");
        } else {
            for (MovieDTO m : temp) {
                System.out.printf("%d번. %s\n", m.getMovieNum(), m.getTitle());
            }

            
            // 평점은 평점 뷰어랑 연결해 보기.. 
            String message = "1. 영화별 전체 평점 보기 2. 영화별 평론가 평점 보기 3. 영화별 일반 관람객 평점 보기 4. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && movieController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            while (true) {
                message = "1. 영화별 전체 평점 보기 2. 영화별 평론가 평점 보기 3. 영화별 일반 관람객 평점 보기  4. 종료";
                userChoice = ScannerUtil.nextInt(scanner, message);

                if (userChoice == 1) {
                    
                } else if (userChoice == 2) {
                 
                } else if (userChoice == 3) {
                    
                }else if (userChoice == 4) {
                    System.out.println("사용해주셔서 감사합니다.");
                    break;
                }
               
            }
        }
    }
    
    // 평점 보기 
        
    private void printOne(int movieNum) {
        MovieDTO m = movieController.selectOne(movieNum);
              
        System.out.println("전체 평점");
        System.out.printf("영화 번호: %d 제목: %s\n", m.getMovieNum(), m.getTitle());
//        System.out.printf(": %s점 \n", );  전체 평점 보기
        
        
        System.out.println("일반인 평점");
        System.out.printf("영화 번호: %d 제목: %s\n", m.getMovieNum(), m.getTitle());
//      System.out.printf(": %s점\n", );  일반인 평점 보기 
  
        System.out.println("평론가 평점");
        System.out.printf("영화 번호: %d 제목: %s\n", m.getMovieNum(), m.getTitle());
//      System.out.printf(": %s점\n", );  평론가 평점 보기 
  
        
        // 관리자만 -> 따로 메서드를 만들어야 하나??
        // if(userRank(MovieUserDTO소속) == 3 (관리자){일때 할 수 있게!
        String message = "1. 수정 2. 삭제 3. 목록으로 가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);

//        if (userChoice == 1) {
//            update(id);
//        } else if (userChoice == 2) {
//            delete(id);
//        } else if (userChoice == 3) {
//            printList();
//        }
  
       
    }
    
    // 관리자 전용 
    private void update(int movieNum) {
        MovieDTO m = movieController.selectOne(movieNum);

        String message;

        message = "새로운 영화 제목을 입력해주세요.";
        m.setTitle(ScannerUtil.nextLine(scanner, message));
        message = "새로운 영화 줄거리를 입력해주세요.";
        m.setSummary(ScannerUtil.nextLine(scanner, message));
        message = "새로운 영화 등급을 입력해주세요.";
        m.setRating(ScannerUtil.nextLine(scanner, message));

        message = "정말로 수정하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            movieController.update(m);
        }

        printOne(movieNum); // ?? 이거 다시 확인하기 
    }

    // 관리자 전용 
    private void delete(int movieNum) {
        String message = "해당 영화의 정보를 정말 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            movieController.delete(movieNum);
            printList();
        } else {
            printOne(movieNum);
        }
    } 
    
}
