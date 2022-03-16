package homework;
// 구조체를 사용해서 게시판 프로그램을 작성하세요. 
// 게시판에 입력될 게시글은 
// 글 번호, 글 제목, 글 작성자, 글 내용 네가지 정보가 입력되어야 하며
// 입력, 목록출력, 수정, 삭제 기능이 모두 들어가야 합니다. 
// 또한 동적 할당이 된 배열을 통해서 프로그램이 제어되어야 합니다. 

import java.util.Scanner;

import struct.Board;
import struct.Student;
import util.ArrayUtil;
import util.ScannerUtil;

public class Ex05Board {
    
    // 전역 상수
    
    // 전역 변수
    // 1. 입력을 처리할 Scanner 클래스 변수
    public static Scanner scanner;
    // 2. 정보를 저장할 String 배열
    public static Board[] array;
    // 3. 다음 입력할 글 번호를 저장할 int nextId
    public static int nextId;
         
    // 1. 각 전역 변수를 초기화 해주는 init()
    public static void init() {
        scanner = new Scanner(System.in);
        array = new Board[0];
        nextId = 1;
    }
    
    // 2. init() 메소드를 호출하고 메뉴를 출력할 showMenu()
    public static void showMenu() {
        init();
        while (true) {
            String message = "1. 입력 2. 목록 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                // 입력 메소드 호출
                insert();
            } else if (userChoice == 2) {
                // 출력 메소드 호출
                printAll();

            } else if (userChoice == 3) {
                // 메시지 출력 후 종료
                System.out.println("사용해 주셔서 감사합니다.");
                break;
            }
        }
    }
    // 3. 새로운 글 정보를 입력하는 insert() 메소드
    public static void insert() {
        Board b = new Board();
        
        b.id = nextId++;
        String message = "글 제목을 입력해주세요.";
        b.tytle = ScannerUtil.nextLine(scanner, message);
        message = "작성자를 입력해주세요.";
        b.name = ScannerUtil.nextLine(scanner, message);
        message = "글 내용을 입력해주세요.";
        b.contents = ScannerUtil.nextLine(scanner, message);
        
        array = ArrayUtil.add(array, b); 
                       
    }
    // 4. 글 목록을 출력하는 printAll()
    public static void printAll() {
        if (ArrayUtil.isEmpty(array)) {
            System.out.println("아직 입력된 글이 존재하지 않습니다.");

        } else {
            for (int i = 0; i < ArrayUtil.size(array); i++) {
                Board b = ArrayUtil.get(array, i);
                System.out.printf("%d번째 글\n", i + 1, b.name );
            }

            // 사용자 한테서 상세보기할 학생의 인덱스를 입력받는다.
            String message = "상세보기할 글 번호나 메뉴로 가시려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message, 0, ArrayUtil.size(array)) - 1;// 실제 배열 인덱스와 일치하도록 !!

            if ((userChoice) != -1) {
                printOne(userChoice);
            }
        
    }
    }
    // 5. 개별 글을 출력하는 printOne()
    public static void printOne(int index) {
        // 각 배열의 index 번째 값을 변수에 저정한다. 훨씬 더 짧게 만들기 위해!
        Board b = ArrayUtil.get(array, index);
        
        // 번호, 작성자 출력 
        System.out.printf("번호: %03d번 작성자: %s\n", b.id, b.name);
       
        // 글제목 출력
        System.out.printf("글 제목: %s\n", b.tytle);

        // 글 내용 출력
        System.out.printf("글 내용: %s\n", b.contents);
        
        System.out.println("---------------------------------------");
        String message = "1. 수정 2. 삭제 3. 글 목록으로";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

        if (userChoice == 1) {
            // 개별 글 수정 메소드 호출
            update(index);
        } else if (userChoice == 2) {
            // 개별 글 삭제 메소드 호출
            delete(index);
        } else if (userChoice == 3) {
            // 여기에 아무것도 안 쓰면 코드의 진행 순서에 따라 진행해버리니 꼭 빈코드가 아니어야 해용.
            printAll();
        }

        
    }
    // 6. 글을 수정하는 update()
    public static void update(int index) {
     // 업데이트 할 글 정보를 불러와서 Board 변수에 저장한다.
        Board b = ArrayUtil.get(array, index); // 실제로는 주소값이 연결되어 있음.

        String message = "글 제목을 입력해주세요.";
        b.tytle = ScannerUtil.nextLine(scanner, message);
        message = "작성자를 입력해주세요.";
        b.name = ScannerUtil.nextLine(scanner, message);
        message = "글 내용을 입력해주세요.";
        b.contents = ScannerUtil.nextLine(scanner, message);
        printOne(index);
    }
    // 7. 글을 삭제하는 delete()
    public static void delete(int index) {
        String message = "정말로 삭제 하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);
       
        if(yesNo.equalsIgnoreCase("Y")) {
            array = ArrayUtil.remove(array, index);
            printAll();  // Y 누르면 삭제하고 목록보기로 돌아가기
        } else {
            printOne(index); // 개별보기 화면으로 돌아가게 해준다. 
        }
        
    }
    // 8. main()s
    public static void main(String[] args) {
        showMenu();
    }
    
    
}
