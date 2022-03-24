package miniproject;

import java.util.ArrayList;


import miniproject.TheaterDTO;
// 기능 뭐 더 추가할 거 있는지 생각해보기

public class TheaterController {

    private ArrayList<TheaterDTO> list;
    private int nextId;
    
    // 필드를 초기화할 생성자
    public TheaterController() {
        list = new ArrayList<>();
        nextId = 1;
        
        for (int i = 1; i <= 4; i++) {
            TheaterDTO t = new TheaterDTO();
            t.setTheaterLocation("평택");
            t.setTheaterName("A"+i+"극장");
            t.setTheaterTel("031-123-333"+i);
            add(t);
        }
        
    }
    
    // 극장번호를 추가 후 리스트에 저장 
    public void add(TheaterDTO t) {
        t.setTheaterNum(nextId++);
        list.add(t);
    }
    
    // 해당 극장 상영중인 영화 목록 보기 ?? 
    
    // 2. 극장의 목록을 뷰어로 보내주는
    // selectAll()
    public ArrayList<TheaterDTO> selectAll() {
        ArrayList<TheaterDTO> temp = new ArrayList<>();
        for (TheaterDTO t : list) {
            temp.add(new TheaterDTO(t));
        }
        
        return temp;
    }
    
  //3. 평점 번호를 파라미터로 받아서 일치하는 ScoreDTO를 리턴하는 selectOne().
    public TheaterDTO selectOne(int theaterNum) {
        for (TheaterDTO t : list) {
            if (t.getTheaterNum() == theaterNum) {
                return new TheaterDTO(t);
            }
        }
        return null;
    }
    
    public void update(TheaterDTO t) {
        int index = list.indexOf(t)+1; // 일단 +1 추가

        list.set(index, t);
    }

    public void delete(int theaterNum) {
        TheaterDTO t = new TheaterDTO();
        t.setTheaterNum(theaterNum);
        
        list.remove(t);
    }

    
}
