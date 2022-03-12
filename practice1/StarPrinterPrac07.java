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
            
            if(i<userNumber) {   // 1 < 5  4줄까지 입력하는 부분 
                int starWidth = i;   // 별이 하나씩 많아져야 하니까.
            for(int j = 1; j<=starWidth; j++) {
                stars +="*";
            }
            
            }else {   // 6(i) > 5(userNumber) 이래야지 아랫부분을 이어나갈 수 있지요.
                int lowerI = i-userNumber;  // 6-5 = 1 
                int starWidth = userNumber - lowerI ; // 별이 네개에서 시작해서 하나로 끝나니까.
                for (int j = 1; j <= starWidth; j++) {
                    stars += "*";
                }
                
            }
            System.out.println(stars);
            
        }
        
        
    }

}
