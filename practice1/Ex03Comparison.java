package practice1;

import java.util.Scanner;

public class Ex03Comparison {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.println("A B");
       System.out.println("A 값을 입력하세요.");
       System.out.printf(">");
       int a = scanner.nextInt();
       
       while (a < 0 || a > 100) {
           System.out.println("잘못 입력했습니다.");
           System.out.println("A 값을 입력하세요.");
           System.out.print("> ");
           a = scanner.nextInt();
       }
       
       
       System.out.println("B 값을 입력하세요.");
       System.out.printf(">");
       int b = scanner.nextInt();
       
       while (b < 0 || b > 100) {
           System.out.println("잘못 입력했습니다.");
           System.out.println("B 값을 입력하세요.");
           System.out.print("> ");
           b = scanner.nextInt();
       }

       System.out.printf("A의 값은 B의 값");
       if(a > b) {
           System.out.printf("보다 크다");
       } else if(a < b) {
           System.out.printf("보다 작다");
       } else {
           System.out.printf("과 같다");
       }
       
       
    }

}
