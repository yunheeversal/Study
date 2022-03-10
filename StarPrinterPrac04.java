package practice1;

import java.util.Scanner;

public class StarPrinterPrac04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();
        
        // i값 최소값
        int iMin = 1;
        // i값 최대값
        int iMax = userNumber;
        // i for문
        for (int i = iMin; i <= iMax; i++) {
            String stars = "";
            int spaceWidth = i-1;
            // j for문 (공백)
            for (int j = 1; j <= spaceWidth; j++) {
                stars += " ";
            }
            
             int starWidth = userNumber-spaceWidth;
            // j for문 (별)
            for (int j = 1; j <= starWidth; j++) {
                stars += "*";
            }
            System.out.println(stars);
            
        }
        
    }

}
