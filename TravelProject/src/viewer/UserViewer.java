package viewer;

import java.util.ArrayList;
//1. 회원
// 회원 번호, 회원 유저네임, 회원 비밀번호, 회원 닉네임, 회원 등급
// 단, 신규 회원 등록 시 무조건 일반 회원으로 등록이 되며 별도로 신청해야 관리자가 
// 해당 회원을 여행사용 등급으로 변경 가능
import java.util.Scanner;
import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
    private HotelViewer hotelViewer; 
    private AirViewer airViewer; 
    private RentalCarViewer rentalCarViewer; 
    private UserController userController;
    private UserDTO logIn;
    private Scanner scanner;

    public void setHotelViewer(HotelViewer hotelViewer) {
        this.hotelViewer = hotelViewer;
    }

    public void setAirViewer(AirViewer airViewer) {
        this.airViewer = airViewer;
    }

    public void setRentalCarViewer(RentalCarViewer rentalCarViewer) {
        this.rentalCarViewer = rentalCarViewer;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public UserViewer() {
        userController = new UserController();
    }
    
    public void showIndex() {
        String message = "1. 로그인 2. 회원가입 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
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

    private void logIn() {
        String usernameMsg = "아이디를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, usernameMsg);

        String passwordMsg = "비밀번호를 입력해주세요.";
        String password = ScannerUtil.nextLine(scanner, passwordMsg);

        while (userController.auth(username, password) == null) {
            System.out.println("아이디와 비밀번호를 다시 확인해주세요.");
            usernameMsg = "아이디나 뒤로 가실려면 \"X\"를 입력해주세요.";
            username = ScannerUtil.nextLine(scanner, usernameMsg);

            if (username.equalsIgnoreCase("X")) {
                break;
            }

            password = ScannerUtil.nextLine(scanner, password);
        }

        logIn = userController.auth(username, password);

//        if (logIn != null) {
//            hotelViewer.setLogIn(logIn);
//            airViewer.setLogIn(logIn);
//            rentalCarViewer.setLogIn(logIn); 
//  
//        }
    }

    
    private void register() {
        String usernameMsg = "사용하실 아이디나 뒤로 가실려면 \"X\"를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, usernameMsg);

        while (userController.validateUsername(username) && !username.equalsIgnoreCase("X")) {
            System.out.println("잘못 입력하셨습니다.");
            username = ScannerUtil.nextLine(scanner, usernameMsg);
        }

        if (!username.equalsIgnoreCase("X")) {

            String passwordMsg = "사용하실 비밀번호를 입력해주세요.";
            String password = ScannerUtil.nextLine(scanner, passwordMsg);

            String nicknameMsg = "사용하실 닉네임을 입력해주세요.";
            String nickname = ScannerUtil.nextLine(scanner, nicknameMsg);
            
            // 회원 유형을 입력해주세요.(1. 관리자 2. 여행사 3. 일반회원)"
            int category = 3;

            UserDTO u = new UserDTO();
            u.setUsername(username);
            u.setPassword(password);
            u.setNickname(nickname);
            u.setCategory(category);

            userController.add(u);
        }

    }
    
    private void showMenu() {
        String message;
        if (logIn.getCategory() == 1) {
            message = "1. 항공권 관리 2. 렌터카 관리 3. 호텔 관리 4. 회원 정보 관리 5. 로그아웃";
        } else {
            message = "1. 항공권 검색 2. 렌터카 검색 3. 호텔 검색 4. 회원 정보 관리 5. 로그아웃";
        }

        while (logIn != null) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
//                movieViewer.showMenu();
             
            } else if (userChoice == 2) {

            } else if (userChoice == 3) {

            } else if (userChoice == 4) {
                showUserMenu();
            }else if (userChoice == 5) {
                System.out.println("정상적으로 로그아웃 되었습니다.");
                logIn = null;
            }
        }
    }

    // 회원 관리
    private void showUserMenu() {
        printOne();

        String message = "1. 정보 수정 2. 탈퇴 3. 뒤로 가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        if (userChoice == 1) {
            if(logIn.getCategory() == 1) {
                printAllAdmin();
            }else {
            updateUserInfo();
            }
        } else if (userChoice == 2) {
            deleteUserInfo();
        }
    }
    
    private void printOne() {
        System.out.println("\n----------------------------------------");
        System.out.println(logIn.getUsername() + "회원님의 정보");
        System.out.println("========================================");
        System.out.println("닉네임: " + logIn.getNickname());
        System.out.print("회원 등급: ");
        switch (logIn.getCategory()) {
        case 1:
            System.out.println("관리자");
            break;
        case 2:
            System.out.println("여행사 회원");
            break;
        case 3:
            System.out.println("일반 회원");
            break;
        }

        System.out.println("----------------------------------------\n");
    }

    
    // 관리자 전용 
    private void printAllAdmin() {
        ArrayList<UserDTO> list = userController.selectAll();
        if (list.isEmpty()) {
            System.out.println("아직 등록된 회원이 없습니다.");
        } else {
            for (UserDTO u : list) {
                System.out.printf("%d. %s\n", u.getId(), u.getNickname());
            }
            
            String message = "상세보기할 회원의 번호나 뒤로가시려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && userController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        
    }
    }
    // 일반 회원 전용 
    private void printOne(int id) {
        UserDTO u = userController.selectOne(id);
        System.out.println("\n=======================================");
        System.out.println("닉네임: " + u.getNickname());
        System.out.println("아이디: " + u.getId());
        System.out.println("등급: ");
        switch (u.getCategory()) {
        case 1:
            System.out.println("관리자");
            break;
        case 2:
            System.out.println("여행사");
            break;
        case 3:
            System.out.println("일반 회원");
            break;
        }
        System.out.println("=======================================\n");
        
        String message = "1. 회원 정보 수정 2. 회원 탈퇴 3. 목록으로 돌아가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        if (userChoice == 1) {
            updateUserInfoAdmin(id);
        } else if (userChoice == 2) {
            deleteUserInfoAdmin(id);
        } else if (userChoice == 3) {
            printAllAdmin();
        }
                
    }
    
    // 유저 전용 
    private void updateUserInfo() {
        UserDTO u = new UserDTO(logIn);
        
        String message = "사용하실 닉네임을 입력해주세요.";
        u.setNickname(ScannerUtil.nextLine(scanner, message));
        
        message = "사용하실 비밀번호를 입력해주세요.";
        u.setPassword(ScannerUtil.nextLine(scanner, message));
        
        userController.update(u);
        
        logIn = u;
        
        showUserMenu();
    }

    private void deleteUserInfo() {
        String message = "정말로 탈퇴하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            userController.delete(logIn.getId());
            logIn = null;
        } else {
            showUserMenu();
        }
    }
    // 관리자 전용 
    private void updateUserInfoAdmin(int id) {
        UserDTO u = userController.selectOne(id);
        String categoryMsg = "회원 유형을 입력해주세요.(1. 관리자 2. 여행사 3. 일반회원)";
        u.setCategory(ScannerUtil.nextInt(scanner, categoryMsg, 1, 3));

        userController.update(u);
        
    }

    private void deleteUserInfoAdmin(int id) {
        String message = "정말로 탈퇴하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            userController.delete(logIn.getId());
            logIn = null;
        } else {
            showUserMenu();
        }
    }
    
   
    
    public void printNickname(int id) {
        UserDTO u = userController.selectOne(id);
        System.out.print(u.getNickname());
    }

    public int selectCategoryById(int id) {
        return userController.selectOne(id).getCategory();
    }
    
}
