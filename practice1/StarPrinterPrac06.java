package practice1;

import java.util.Scanner;

public class StarPrinterPrac06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                
        System.out.println("줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();
        
        int iMin = 1;
        int iMax = userNumber;
        
        for(int i = iMin; i <= iMax ; i++) {
            String stars = "";
            // 공백
            int spaceWidth = i-1;
            for(int j=1; j<=spaceWidth; j++) {
                stars += " ";
            }
            
            int starWidth = userNumber*2-i;
            for(int j=i; j<=starWidth; j++) {
                stars +="*";
            }
            
            System.out.println(stars);
            
            
        }
        
        
    }

}
