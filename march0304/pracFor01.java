package practiceFor;
// 다시 해보기!!!
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class pracFor01 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<N;i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if(value < X) {
				sb.append(value).append(' ');
			}
			
		}
		System.out.println(sb);
		
	}

}
