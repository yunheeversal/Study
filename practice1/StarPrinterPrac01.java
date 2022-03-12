package practice1;

import java.util.Scanner;

public class StarPrinterPrac01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                
        System.out.println("줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();
        
        // 최소값
        int iMin = 1;
        // 최대값
        int iMax = userNumber;
        
        for(int i=iMin;i<=iMax;i++) {
            int jMin = 1;
            int jMax = i;
            for(int j=jMin; j<=jMax;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        
    }

}
