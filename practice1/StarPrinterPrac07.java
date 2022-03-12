package practice1;

import java.util.Scanner;

public class StarPrinterPrac07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                
        System.out.println("줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();
        
        int iMin = 1;
        int iMax = userNumber*2-1;
        
        for(int i =iMin ; i<=iMax;i++) {
            String stars = "";
            
            if(i<userNumber) {
                int starWidth = i;
            for(int j = 1; j<=starWidth; j++) {
                stars +="*";
            }
            
            }else {
                int lowerI = i-userNumber;
                int starWidth = userNumber - lowerI ;
                for (int j = 1; j <= starWidth; j++) {
                    stars += "*";
                }
                
            }
            System.out.println(stars);
            
        }
        
        
    }

}
