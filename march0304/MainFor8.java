package practiceBaekjoon;
// 별 찍기 - 1
// 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class MainFor8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        try {
            int N = Integer.parseInt(br.readLine());
            
            for(int i = 0; i<N ; i++) {
              for(int j =0; j<=i;j++) {
                bw.write("*");
              }
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