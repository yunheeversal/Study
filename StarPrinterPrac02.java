package practice1;

import java.util.Scanner;

public class StarPrinterPrac02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                
        System.out.println("줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();
        
        int iMin = 1;
        int iMax = userNumber;
        
        for(int i=iMin;i<=iMax;i++) {
            int jMin = i;
            int jMax = userNumber;
            String stars = "";
            
            for(int j=jMin; j<=jMax;j++) {
                stars +="*";
            }
            
            System.out.println(stars);
        }
        
    }

}
