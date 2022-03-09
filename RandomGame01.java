package practice1;

import java.util.Random;
import java.util.Scanner;

public class RandomGame01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int bestScore = 0;

        while (true) {
            System.out.println("1. 플레이 2. 최고기록 보기 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                int computerNumber = random.nextInt(100) + 1;
                int currentScore = 0;
                int userNumber = 0;

                while (userNumber != computerNumber) {
                    System.out.println("1부터 100사이의 숫자를 입력해 주세요.");
                    System.out.print("> ");
                    userNumber = scanner.nextInt();

                    if (userNumber > computerNumber) {
                        System.out.println("!!! DOWN !!!");
                    } else if (userNumber < computerNumber) {
                        System.out.println("!!! UP !!!");
                    }
                    currentScore++;

                }

                System.out.printf("사용자의 이번 플레이 기록: [%d]\n", currentScore);

                if (bestScore > 0) {
                    System.out.printf("현재 까지 최고 기록: [%d] \n", bestScore);
                }
                
                if (bestScore==0 || bestScore > currentScore) {
                    bestScore = currentScore;
                    System.out.println("새로운 최고 기록입니다!!!!!!!!!!");
                }
               

            } else if (userChoice == 2) {
                System.out.printf("현재 최고 기록은 [%d]\n", bestScore);

            } else if (userChoice == 3) {
                System.out.println("게임을 종료하겠습니다.");
                break;
            }

        }

    }
}

