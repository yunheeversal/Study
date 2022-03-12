package practice1;

import java.util.Scanner;

public class StarPrinterPrac09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 별찍기 5번 6번을 합친 형태
        System.out.println("줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();

        int iMin = 1;
        int iMax = 2 * userNumber - 1;

        // i for문 (행 수)
        for (int i = iMin; i <= iMax; i++) {
            String stars = "";
            // if로 위아래 나누기
            
            // 위아래 if문에 내용이 겹쳐서 공백, 별 for문을 바깥으로 둔다. 
            // 그리고 아래 중복되는 변수들을 바깥에 정의 해둔다. 
            int spaceWidth;
            int starWidth;

            if (i < userNumber) {

                // 공백 갯수
                spaceWidth = userNumber - i;
                // 별 갯수
                starWidth = i * 2 - 1;

            } else {
                // 아랫부분
                int lowerI = 2 * userNumber - i; // 2*5 10-6=4 3 2 1
                // 공백 갯수
                spaceWidth = userNumber - lowerI; // 5-4=1, 2, 3,4
                // 별 갯수
                starWidth = 2 * lowerI - 1;

            }
            // 공백 for문
            for (int j = 1; j <= spaceWidth; j++) {
                stars += " ";
            }
            // 별 for문
            for (int j = 1; j <= starWidth; j++) {
                stars += "*";
            }

            System.out.println(stars);

        }

    }

}
