package practice1;

import java.util.Scanner;

public class StarPrinterPrac03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        // 최소값
        int iMin = 1;
        // 최대값
        int iMax = userNumber ;

        for (int i = iMin; i <= iMax; i++) {
            String stars = "";
            int spaceWidth = userNumber - i;
            // 공백
            for (int j = 1; j <= spaceWidth; j++) {
                stars += " ";
            }
            int starWidth = i;
            // 별
            for (int j = 1; j <= starWidth; j++) {
                stars += "*";
            }

            System.out.println(stars);
        }

    }

}
