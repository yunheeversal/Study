package prac_fx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*한수
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 
등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.*/

public class fx1065 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		System.out.println(hansu(Integer.parseInt(br.readLine())));
		
	}
	
	public static int hansu(int num) {
		int cnt =0;

		if(num<100) { // 100보다 작은 건 다 수열이니까 다 return
			return num;
		}else {
			cnt =99; // 한수의 최소 개수는 99개니까.
			
			for(int i =100; i<=num ; i++) {
				int hun = i/100; // 백의 자리
				int ten = (i/10)%10; // 십의 자리
				int one = i%10;// 일의 자리
				
				if((hun-ten)==(ten-one)){// 각 자리수가 수열을 이루면 카운트
					cnt++;
				}
			}
			
		}
		
		return cnt;
	}

	
}
