package practice1;

import java.util.Scanner;

public class Ex04LeapYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("연도를 입력하세요.");
        int year = scanner.nextInt();
        
        if(year<1 || year>4000) {
            System.out.println("연도를 다시 입력하세요");
        } else if(year%4 == 0 && year % 100 != 0) {
            System.out.println("윤년");
        } else if( year % 400 == 0) {
            System.out.println("윤년");
        } else {
            System.out.println("평년");
       }

    }

}
