package miniproject;

import java.util.Scanner;
import java.util.ArrayList;

import util.ScannerUtil;
import miniproject.MovieUserDTO;
import model.UserDTO;
import miniproject.MovieUserController;
// 뷰어 연결하기~~~
import miniproject.MovieViewer;
import miniproject.ScoreViewer;
import miniproject.TheaterViewer;

// 영화, 극장, 상영중  뷰어? 목록 불러오기..!

public class MovieUserViewer {
    
     // 등급입력시 사용할 String 상수
    private final String RANK_INPUT_MSG = "1.일반 관람객 2. 전문 평론가 3. 관리자";
    
    private final String OPTION_GO_BACK = "X";

    private Scanner scanner;
    private MovieUserDTO logIn;
    private MovieUserController userController;
    // 추후에 뷰어 추가할 일 생기면 추가하기  private BoardViewer boardViewer; 이런식으로
    
    public MovieUserViewer() {
        scanner = new Scanner(System.in);
        userController = new MovieUserController();
    // 추후 연관된 뷰어 추가하려면 이렇게 ! replyViewer = new ReplyViewer();
        
        
    }
    
 // showIndex()
    public void showIndex() {
        String message = "1. 로그인 2. 회원가입 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                logIn();

                if (logIn != null) {
                    showMenu();
                }
            } else if (userChoice == 2) {
                register();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }
    
    // logIn() 로그인  -> 관리자면 다른 목록 보여줄 수 있게 해야함. 
    private void logIn() {
        String message;

        message = "아이디를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, message);

        message = "비밀번호를 입력해주세요.";
        String password = ScannerUtil.nextLine(scanner, message);

        while (userController.auth(username, password) == null) {
            System.out.println("잘못 입력하셨습니다.");

            message = "아이디를 입력하시거나 뒤로 가실려면 X를 입력해주세요.";
            username = ScannerUtil.nextLine(scanner, message);

            if (username.equalsIgnoreCase(OPTION_GO_BACK)) {
                break;
            }

            message = "비밀번호를 입력해주세요.";
            password = ScannerUtil.nextLine(scanner, message);
        }

        logIn = userController.auth(username, password);

    }
    
    // register() 회원가입
    // 회원 번호, 아이디, 비밀번호, 닉네임, 등급이 존재한다.
    // 등급의 경우, 일반 관람객, 전문 평론가, 관리자로 나뉘며 int 값을 통해 각 등급이 결정된다.
    private void register() {
        String message;

        message = "사용하실 아이디나 뒤로 가실려면 X를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, message);

        while (userController.validateUsername(username)) {
            System.out.println("사용하실 수 없는 아이디입니다.");
            username = ScannerUtil.nextLine(scanner, message);

            if (username.equalsIgnoreCase(OPTION_GO_BACK)) {
                break;
            }
        }

        if (!username.equalsIgnoreCase(OPTION_GO_BACK)) {
            message = "사용하실 비밀번호를 입력해주세요.";
            String password = ScannerUtil.nextLine(scanner, message);

            message = "사용하실 닉네임을 입력해주세요.";
            String nickname = ScannerUtil.nextLine(scanner, message);

            message = "등급을 입력해주세요.(" + RANK_INPUT_MSG + ")";
            int userRank= ScannerUtil.nextInt(scanner, message, 1,3);
  
            
            MovieUserDTO m = new MovieUserDTO();
            m.setUsername(username);
            m.setPassword(password);
            m.setNickname(nickname);
            m.setUserRank(userRank);

            userController.add(m);
        }
    }

    // showMenu()  목록 보기.
    private void showMenu() {
        String message = "1. 영화 목록 보기 2. 극장 목록 보기 3. 상영중인 영화 목록 보기 4. 로그아웃";
        while (logIn != null) {

//            boardViewer.setLogIn(logIn); 영화, 극장, 상영중 세 개 다 불러오기?

            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
//                boardViewer.showMenu(); 영화 목록 불러오기
            } else if (userChoice == 2) {
//                                          극장 목록 불러오기
            } else if (userChoice == 3) {
//                boardViewer.setLogIn(null); 상영중인 영화 목록 불러오기 
            } else if (userChoice == 4) {
                System.out.println("로그아웃 되셨습니다.");
                logIn = null;
//              boardViewer.setLogIn(null); /?? 다른 부분에서도 로그아웃 필요한지 확인하기. 
      }
    }
    
    

}

    public void printNickname(int id) {
        MovieUserDTO m = userController.selectOne(id);
        System.out.print(m.getNickname());
    }
    
    
}

