package java1000;

import java.util.ArrayList;
import java.util.List;

public class Student1 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

       //                        이름, 반, 번호, 국어, 수학, 영어 

        list.add(new Student("남궁성", 3,2,100,100,100));
        list.add(new Student("왕자바", 3,1,90,100,80));
        list.add(new Student("자바왕", 3,3,70,100,100));
        list.add(new Student("킹왕짱", 1,2,100,60,90));
        list.add(new Student("자바짱", 1,1,100,100,100));
        list.add(new Student("최고수", 1,3,100,80,60));
        list.add(new Student("홍길동", 2,1,50,80,100));
        list.add(new Student("일지매", 2,3,70,80,100));
        list.add(new Student("변강쇠", 2,4,80,80,85));
        list.add(new Student("이원구", 2,2,90,90,90));


        printList(list);
  }

  public static void printList(List<Student> list) {
        System.out.println("이름\t반\t번호\t국어\t수학\t영어\t총점 ");
        System.out.println("====================================================");

        for(Student s : list) {
              System.out.println(s);
        }

        System.out.println("====================================================");
  }
}

class Student {

   /*

        코드를 완성하세요.

        1.  이름(name), 반(classNo), 번호(studentNo),

            국어(Korean), 수학(Math), 영어(English), 총점(Total)을

            인스턴스변수로 선언한다.

        2. 이름, 반, 번호, 국어, 수학, 영어를 입력받아서 각 인스턴스변수에 저장하는

            생성자를 선언한다.

        3. Object클래스의 toString()을 오버라이딩해서 실행결과와 같이,

            이름, 반, 번호, 국어, 수학, 영어, 총점이 화면에 출력되도록 한다.

    */
    
    String name;
    int classNo;
    int studentNo;
    int Korean;
    int Math;
    int English;
    int Total;
    
    public Student() {}
    
    public Student(String name, int classNo, int studentNo, int Korean, int Math, int English) {
        this.name=name;
        this.classNo=classNo;
        this.studentNo=studentNo;
        this.Korean=Korean;
        this.Math=Math;
        this.English=English;
        this.Total=Korean+Math+English;
        
    }

    @Override
    public String toString() {
        return name + "\t" + classNo + "\t" + studentNo + "\t" + Korean
                + "\t" + Math + "\t" + English + "\t" + Total ;
    }
    
    
    
}