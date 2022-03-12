package practice1;

import java.util.Scanner;

public class StarPrinterPrac08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                
        System.out.println("줄 수를 입력해 주세요.");
        System.out.print("> ");
        int userNumber = scanner.nextInt();
        
        int iMin = 1;
        int iMax = 2*userNumber-1;
        
        // i for문 (행 수)
        for(int i =iMin ; i<=iMax;i++) {
            String stars = "";
            // if로 위 아래 나누기
            if(i<userNumber) {
                // 별이 하나씩 증가, 공백 하나씩 감소
                
                // 공백 갯수
                int spaceWidth = userNumber -i ;
                // 윗부분 j for문 - 공백
                for(int j = 1; j <= spaceWidth ; j++) {
                    stars +=" ";
                }
                // 별 갯수
                int starWidth = i;
                // 윗부분 j for문 - 별
                for(int j = 1; j <= starWidth ; j++) {
                    stars +="*";
                }
                
                
            }else {
                // 별이 하나씩 감소, 공백 하나씩 증가
                int lowerI = i-userNumber +1; // 5-5+1=1 1,2,3 1씩 증가
                // 공백 갯수
                int spaceWidth = lowerI - 1; // 1-1 =0개 -> 2-1= 1개 -> 3-1= 2개
                
                // 아랫부분 j for문 - 공백
                for(int j= 1; j <= spaceWidth ; j++ ) {
                    stars +=" ";
                }
                // 별 갯수
                int starWidth = userNumber - lowerI + 1;// 5-1+1 =5, 5-2+1 =4, 1씩 감소
                // 윗부분 j for문 - 별
                for(int j = 1; j <= starWidth ; j++) {
                    stars +="*";
                }
            }
            
            System.out.println(stars);
                       
        }
      
    }

}
