package miniproject;
import java.util.ArrayList;

import miniproject.ScreeningDTO;

public class ScreeningController {
    
    private ArrayList<ScreeningDTO> list;
    // 다음 입력할 사원의 번호를 저장할 int 필드
    private int nextId;
    
    public ScreeningController() {
        list = new ArrayList<>();
        nextId = 1;
    }
    // 목록을 뷰어로 보내주는 selectAll()
    public ArrayList<ScreeningDTO> selectAll() {
        ArrayList<ScreeningDTO> temp = new ArrayList<>();
        for (ScreeningDTO s : list) {
            temp.add(new ScreeningDTO(s));
        }

        return temp;
    }
    
 // 번호를 파라미터로 받아서 일치하는 ScreeningDTO를 리턴하는 selectOne().
    public ScreeningDTO selectOne(int screeningNum) {
        for (ScreeningDTO s : list) {
            if (s.getScreeningNum() == screeningNum) {
                return new ScreeningDTO(s);
            }
        }

        return null;
    }
    
    
    // 관리자 전용 
    // add
    public void add(ScreeningDTO s) {
        s.setScreeningNum(nextId);
        list.add(s);
    }
    // update
    public void update(ScreeningDTO s) {
        int index = list.indexOf(s);
        list.set(index, s);
    }

    // delete
    public void delete(int screeningNum) {
        ScreeningDTO temp = new ScreeningDTO();
        temp.setScreeningNum(screeningNum);
        list.remove(temp);
    }
    
}
