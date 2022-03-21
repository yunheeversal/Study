package practice1;

import java.util.ArrayList;
import practice1.StudentDTO;

public class StudentController {

    // 데이터베이스를 대신할 어레이리스트 필드
    private ArrayList<StudentDTO> list;
    // 다음 입력할 학생의 번호를 저장할 int 필드 
    private int nextId;
    // 필드를 초기화할 생성자 
    public StudentController() {
        list = new ArrayList<>();
    }
    
    // 1. 파라미터로 넘어온 StudentDTO 객체에 학생 번호 추가 후 list에 추가하는 insert()
    public void insert(StudentDTO s) {
        s.setId(nextId++);
        list.add(s);
    }
    // 2. 학생의 목록을 뷰어로 보내주는 selectAll() 
    public ArrayList<StudentDTO> selectAll() {
        // 목록을 내보내야 하니까 ArrayList를 사용. 
        ArrayList<StudentDTO> temp = new ArrayList<>();
        // forEach를 사용하여 원본 저장되어 있는 ArrayList 객체 list에서
        // StudentDTO 객체를 깊은 복사 하여 temp에 추가 
        // 깊은 복사: 한쪽값을 변경해도 다른 쪽 값은 유지, 필드안 저장된 값 복사해 와서 직접 넣어주는 형태)
        for(StudentDTO s : list) {
            StudentDTO sTemp = new StudentDTO(s);
            temp.add(sTemp);
        }
        return temp;
        
    }
    
    // 3. 학생 번호를 파라미터로 받아서 일치하는 StudentDTO를 리턴하는 selectOne().
    // 단 해당 학생 번호를 가진 학생이 존재하지 않으면 null이 리턴한다. 
  
    public StudentDTO selectOne(int id) {
        StudentDTO s = new StudentDTO(); // 객체 불러오기
        s.setId(id); // id 필드에 값을 넣는 메소드 
        if(list.contains(s)) { // s가 list에 포함 되어 있으면 실행
            return new StudentDTO(list.get(list.indexOf(s)));
            // 그 공간에 주소 값을 리턴하겠다. 
        }
        return null;
    }
    // 4. 파라미터로 들어온 StudentDTO 객체를 사용하여 원본을 수정하는 update()
    public void update(StudentDTO s) {
        StudentDTO origin = list.get(list.indexOf(s)); 
        // 원본을 불러와서 그 주소값에 수정을 하는??
        origin.setKor(s.getKor()); // origing에 kor를 반환하면 그 값으로 변환 
        origin.setEng(s.getEng());
        origin.setMath(s.getMath());
        
    }
    //  indexOf(객체): 특정 객체가 ArrayList의 몇번 인덱스에 있는지 찾을 때
    // 가장 먼저 등장하는 인덱스를 불어오며, 만약 해당 객체가 존재하지 않으면 -1이 리턴된다.

      // 파라미터로 들어온 int값과 일치하는 StudentDTO 객체를 삭제하는 delete()
     public void delete(int id) {
         StudentDTO s = new StudentDTO();
         s.setId(nextId);
         list.remove(s);
         
     }
    
}
