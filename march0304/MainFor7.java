package practiceBaekjoon;
// A+B - 8
// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
// 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
// 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
// 각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class MainFor7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        try {
            int N = Integer.parseInt(br.readLine());
            int[] A  = new int[N];
            int[] B = new int[N];
            
            for(int i =0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 0; i<N ; i++) {
                bw.write("Case #"+(i+1)+": "+A[i]+" + "+B[i]+" = "+(A[i]+B[i]));
                bw.newLine();
            }

            
        }catch(Exception e ) {
            e.printStackTrace();
        }finally {
            try {
                if(br!=null) {
                    br.close();
                }
                
                if(bw != null) {
                    bw.flush();
                    bw.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
          

    }

}