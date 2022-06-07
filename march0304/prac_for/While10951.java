package prac_for;

import java.util.Scanner;

/*A+B - 4
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10) */

public class While10951 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		
		while(sc.hasNextInt()) { // NoSuchElement 오류: 존재하지 않는 것을 가져오려고 할 때 발생합니다. sc.hasNextInt()를 이용해서 해결 
			 a = sc.nextInt();
			 b = sc.nextInt();
			 int c = a+b;
			 if(a<=0 || b>=10) {
				 break;
			 }
			 
			 System.out.println(c);
			
		}
		
	}

}
