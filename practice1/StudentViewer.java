package practice1;

import java.util.ArrayList;
import java.util.Scanner;
import practice1.ScannerUtil;
import practice1.StudentDTO;
import practice1.StudentController;


public class StudentViewer {
    // 전역 상수
    private final int SUBJECT_SIZE = 3;
    private final int SCORE_MAX = 100;
    private final int SCORE_MIN = 0;
    
    // 전역 변수 
    private StudentController controller;
    private Scanner scanner;
    
    public StudentViewer() {
        controller = new StudentController();
        scanner = new Scanner(System.in);
    }
    
    // showMenu()
    public void showMenu() {
        
        while(true) {
            String message = "1. 입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if(userChoice ==1 ) {
                insertInfo();
            } else if(userChoice == 2) {
                printAll();
                
            } else if(userChoice == 3) {
                System.out.println("사용해 주셔서 감사합니다.");
                break;
            }
        }
    }
    
    
    // insertInfo()
    private void insertInfo() {
        StudentDTO s = new StudentDTO();
        
        String message = "학생의 이름을 입력해 주세요.";
        s.setName(ScannerUtil.nextLine(scanner, message));
        message = "학생의 국어 점수를 입력해 주세요.";
        s.setKor(ScannerUtil.nextInt(scanner, message,SCORE_MIN, SCORE_MAX));
        message = "학생의 영어 점수를 입력해 주세요.";
        s.setEng(ScannerUtil.nextInt(scanner, message,SCORE_MIN, SCORE_MAX));
        message = "학생의 수학 점수를 입력해 주세요.";
        s.setMath(ScannerUtil.nextInt(scanner, message,SCORE_MIN, SCORE_MAX));

        controller.insert(s);
        
    }
    
    
    // printAll()
    private void printAll() {
        ArrayList<StudentDTO> temp = controller.selectAll();
        
        if(temp.isEmpty()) {
            System.out.println("아직 등록된 사원 정보가 존재하지 않습니다. ");
        }else {
            for(StudentDTO s : temp) {
                System.out.printf("%d. %s\n", s.getId(),s.getName());
            }
        }
        String message = "상세보기할 학생의 번호나 뒤로 가시려면 0을 입력해 주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        
        while(userChoice!=0 && controller.selectOne(userChoice)==null) {
            System.out.println("잘못 입력하셨습니다. ");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }
        
        if(userChoice!=0) {
            printOne(userChoice);
        }
                
    }
    
    // printOne()
    private void printOne(int id) {
        StudentDTO s = controller.selectOne(id);
        // 번호 이름 출력
        System.out.printf("번호: %03d번 이름: %s\n", s.getId(), s.getName());
        // 국영수 점수 출력
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", s.getKor(),s.getEng(),s.getMath());

        // 총점 평균 출력
        int sum = s.getKor() + s.getEng() + s.getMath();
        double avg = (double) sum / SUBJECT_SIZE;
        System.out.printf("총점: %03d점  평균: %06.2f점\n ", sum, avg);

        System.out.println("---------------------------------------");
        String message = "1. 수정 2. 삭제 3. 학생 목록으로";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
        if (userChoice == 1) {
            // 개별 학생 수정 메소드 호출
            update(id);
        } else if (userChoice == 2) {
            // 개별 학생 삭제 메소드 호출
            delete(id);
        } else if (userChoice == 3) {
            // 여기에 아무것도 안 쓰면 코드의 진행 순서에 따라 진행해버리니 꼭 빈코드가 아니어야 해용.
            printAll();
        }
        
    }
    
    // update()
    private void update(int id) {
        StudentDTO temp = new StudentDTO();
        
        String message = "새로운 국어 점수를 입력해 주세요.";
        temp.setKor(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        message = "새로운 영어 점수를 입력해 주세요.";
        temp.setEng(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        message = "새로운 수학 점수를 입력해 주세요.";
        temp.setMath(ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX));
        
        StudentDTO origin = controller.selectOne(id);
        
        if(temp.getKor() != 0) {
            origin.setKor(temp.getKor());
        }
        if(temp.getEng() != 0) {
            origin.setEng(temp.getEng());
        }
        if(temp.getMath() != 0) {
            origin.setMath(temp.getMath());
        }
        
        controller.update(origin);
        
    }
    
    // delete()
    private void delete(int id) {
        String message = "정말로 삭제 하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);
        
        if(yesNo.equalsIgnoreCase("Y")) {
            controller.delete(id);
            printAll();
        }else {
            printOne(id);
        }
        
    }
    
    
    
}
