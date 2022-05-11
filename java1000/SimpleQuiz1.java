package java1000;
// [Java1000제] Simple Quiz 1 - 간단한 다지선다형 문제
// 주어진 문자열 데이터를 가지고 실행결과와 같이 출력되도록 코드를 완성하세요.
// 데이터의 형식은 문제, 답, 선택지의 순서로 되어 있으며 구분자는 `(숫자1옆의 키)입니다.
// [출처] [Java1000제] Simple Quiz 1 - 간단한 다지선다형 문제 (남궁성의 코드초보스터디(자바 java, c언어, javascript, python) | 작성자 남궁성
public class SimpleQuiz1 {

    public static void main(String[] args) {
        String[] data = {
                "다음 중 키워드가 아닌 것은?`2`final`True`if`public",
                "다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^",
                "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false",
          }; 

        String[][] div = new String[data.length][];
        String[] sel = null;
        
          for(int i=0;i<data.length;i++) {

                 // 1. String클래스의 String[] split(String regex, int limit)를 사용해서 문제와 선택지를 나누세요.
              String regex = "`";
              int limit = 3;
              div[i] = data[i].split(regex, limit); 
              
                 // 2. 문제를 출력하세요.
              System.out.println("["+(i+1)+"]"+div[i][0]);
              
                 // 3. 선택지를 나누기 위해 String[] split(String regex)를 사용하세요.

              sel =div[i][2].split(regex); 
              
                 // 4.반복문을 이용해서 선택지를 출력하세요.
              for(int j=0; j<sel.length;j++) {
                  System.out.println((j+1)+". "+sel[j]+" ");
                  System.out.println();
              }
              
              
          }
        
    }

}
