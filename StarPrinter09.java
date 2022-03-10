package day0310;

import java.util.Scanner;

public class StarPrinter09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**************************");
        System.out.println("\t\t별찍기 9번");
        System.out.println("**************************");

        System.out.println("출력할 줄 수를 입력해 주세요");
        System.out.println("> ");
        int userNumber = scanner.nextInt();
        int iMin = 1;
        int iMax = userNumber;

        // 윗부분을 담당하는 i for문
        for (int i = iMin; i <= iMax; i++) {
            String stars = "";
            
            // 공백 갯수
            int spaceWidth = userNumber - i;
            
            // 공백을 담당하는 j for문
            for (int j = 1; j <= spaceWidth; j++) {
                stars += " ";
            }
            // 별의 갯수
            int starWidth = i * 2 - 1;
            // 별을 담당하는 j for문
            for (int j = 1; j <= starWidth; j++) {
                stars += "*";
            }

            System.out.println(stars);

        }
                
        // 아랫부분을 담당하는 i for문
        for (int i = iMin; i <= iMax; i++) {
            String stars = "";
            
            // 공백 갯수
            int spaceWidth = i-1; // 공백은 1-1= 0, 2-1=1, 3-1=2, 이런식으로 0부터 1씩 늘어남
            // 공백을 담당하는 j for문
            for (int j = 1 ; j <= spaceWidth  ; j++) {
                stars += " ";
            }
            
            // 별 갯수
            // 첫번째 줄의 별의 갯수
            // 9 = (-2 * 1) + x
            // 9 = -2 +x
            // 9 + 2 = -2 +2 +x
            // 11 = x (5 기준)
            // 11 = 2 * 5 + a
            // 11 = 10 + a
            // a = 1
            
            
            // 11 = (-2 * 1) + x (userNumber가 1씩 오를 때마다 x가 2씩 올라감. )
            // 11 = x -2
            // 13 = x
            
            int starWidth = -2 * i + 2 * userNumber + 1; // 
            //별을 담당하는 j for문
            for (int j = 1; j <= starWidth; j++) {
                stars += "*";
            }
          
            // 공백을 담당하는 j for문
            for (int j = 0 ; j <= userNumber  ; j++) {
                stars += " ";
            }
            System.out.println(stars);

        
        }
        
    }

}


