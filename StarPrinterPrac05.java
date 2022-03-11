package practice1;

import java.util.Scanner;

public class StarPrinterPrac05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("줄 수를 입력해 주세요.");
        System.out.println("> ");
        int userNumber = scanner.nextInt();
        
        int iMin = 1;
        int iMax = userNumber;

        // i for문
        for (int i = iMin; i <= iMax; i++) {
            String stars = "";
            // 공백
            int spaceWidth = userNumber - i;
            for(int j = 1; j <= spaceWidth; j++) {
                stars += " ";
            }
            // 별
            int starWidth = i * 2 - 1;
            for(int j = 1; j <= starWidth ; j++) {
                stars +="*";
            }
            System.out.println(stars);
        }
        

    }

}
