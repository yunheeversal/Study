package march0304;
// 구구단 만들기 
// N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.

import java.util.Scanner;

public class MainFor01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        for(int i = a; i <= a; ) {
            for(int j = 1; j <= 9; j++ ) {
            System.out.printf("%d * %d = %d \n", i, j, i*j);
            }
            break;
        }

    }

}
