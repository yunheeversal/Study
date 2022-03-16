package homework;
// 숙제 1번

import java.util.Scanner;

// 입력, 출력, 종료 기능을 가지고 있는
// 학생 성적 출력 프로그램을 만들되,
// 점수를 사용자가 입력하면 올바른 점수(범위, 어딘가에 저장할 수 있는)를 리턴해주는 메서드를 만들어서
// 국어, 영어, 수학 점수를 입력 받을 때 해당 메서드를 사용하고
// 출력도 별개의 메서드로 분리해서 프로그램을 작성하시오.

public class Ex01GradeBook {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        int kor = 0;
        int eng = 0;
        int math = 0;
        String name = "";
        final int SUBJECT_SIZE = 3;
        
        // 사용자가 입력했는지를 저장할 boolean변수
        boolean inputSwitch = false;
        
        // 무한루프를 사용한 메뉴 출력
        while (true) {

            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();
           
            if (userChoice == 1) {
                // 입력 코드 구현
                
                // 번호 입력
                System.out.println("번호를 입력해 주세요.");
                System.out.print("> ");
                id = scanner.nextInt();

                // 이름 입력
                System.out.println("이름을 입력해 주세요.");
                System.out.print("> ");
                scanner.nextLine();
                name = scanner.nextLine();
                
                // 국어 성적 입력
                kor = setScore(scanner, "국어");
                
                // 영어 성적 입력
                eng = setScore(scanner, "영어");

                // 수학 성적 입력
                math = setScore(scanner, "수학");
                
                inputSwitch = true;

            } else if (userChoice == 2) {
                // 출력 코드 구현
                if(inputSwitch=true) {
                printInfo(id, name, kor, eng, math);
                }else {
                    System.out.println("아직 입력된 정보가 존재하지 않습니다.");
                }
            } else if (userChoice == 3) {
                // 메시지 출력 후 종료
                System.out.println("사용해 주셔서 감사합니다.");
                break;
            }
        }

    }

    // 입력 메서드
    public static int setScore(Scanner scanner, String subject) {
        // 상수
        // 1. 가능한 최소 점수
        final int SCORE_MIN=0;
        // 2. 가능한 최대 점수
        final int SCORE_MAX=100;
        
        int score = 0;
        
        System.out.println(subject + " 점수를 입력해 주세요.");
        System.out.print("> ");
        score = scanner.nextInt();
        
        while(!(score >= SCORE_MIN && score <=SCORE_MAX)) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("다시 점수를 입력해 주세요.");
            System.out.print("> ");
            score = scanner.nextInt();
        }
        
        return score;
    
       }

    // 출력 메서드
    public static void printInfo(int id, String name, int kor, int eng, int math) {
        // 상수
        // 과목의 갯수
        final int SUBJECT_SIZE = 3;
        
        // 번호 이름 출력
        System.out.printf("번호: %03d번 이름: %s\n", id, name);
        // 국영수 점수 출력
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", kor, eng, math);
        
        int sum = kor + eng + math;
        double avg = sum / (double) SUBJECT_SIZE;
        System.out.printf("총점: %03d점  평균: %06.2f점\n ", sum, avg);

    }
       
}

