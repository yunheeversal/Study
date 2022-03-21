package practice1;

public class StudentDTO {
    // 필드 - 외부 접근 불가 
    private int id;
    private String name;
    private int kor;
    private int eng;
    private int math;
    
    // 겟터 셋터
    public int getId() { // 필드를 우회하여 반환 
        return id;
    }
    public void setId(int id) { // 필드를 우회적으로 변경(write)합니다. 
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getKor() {
        return kor;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public int getEng() {
        return eng;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    
       
    // equals() 오버라이드
    public boolean equals(Object o) {
        if(o instanceof StudentDTO) {
            StudentDTO s = (StudentDTO)o;
            return id == s.id;
        }
        
        return false;
    }
    
    // 파라미터 없는 생성자
    public StudentDTO(){
        
    }
    // 깊은 복사를 위한 파라미터가 있는 생성자
    public StudentDTO(StudentDTO s){
        this.id = s.id;
        name = s.name;
        kor = s.kor;
        eng = s.eng;
        math = s.math;
                
    }
    
}
