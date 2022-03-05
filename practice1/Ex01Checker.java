package practice1;

import java.util.Scanner;

// 음식 주문

// 1. 입력 - 먹고 싶은 메뉴를 고르세요
// 2. 메뉴 - 1. 떡볶이 2. 치킨 3. 피자 4. 햄버거
// 3. 메뉴 > 

public class Ex01Checker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("먹고 싶은 메뉴를 고르세요");
        System.out.println("1. 떡볶이 2. 치킨 3. 피자 4.햄버거");
        System.out.println(">");
        int menu = scanner.nextInt();
        
        System.out.printf("당신이 고른 메뉴는 : ");
        
        if(menu == 1) {
            System.out.println("떡볶이");
        } else if(menu == 2) {
            System.out.println("치킨");
        } else if(menu == 3) {
            System.out.println("피자");
        } else {
            System.out.println("햄버거");
        }
        
        
        
    }
}
