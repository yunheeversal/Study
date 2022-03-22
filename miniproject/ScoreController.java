package miniproject;

import java.util.ArrayList;
import java.util.Calendar;

import miniproject.ScoreDTO;

public class ScoreController {

    private ArrayList<ScoreDTO> list;
    private int nextId;

    public ScoreController() {
        list = new ArrayList<>();
        nextId = 1;
    }
    
    // 평점번호를 추가 후 리스트에 저장 
    public void add(ScoreDTO s) {
        s.setScoreNum(nextId++);
        list.add(s);
    }
    
    // 2. 평점의 목록을 뷰어로 보내주는
    // selectAll()
    public ArrayList<ScoreDTO> selectAll() {
        ArrayList<ScoreDTO> temp = new ArrayList<>();
        for (ScoreDTO s : list) {
            temp.add(new ScoreDTO(s));
        }
        
        return temp;
    }

    //3. 평점 번호를 파라미터로 받아서 일치하는 ScoreDTO를 리턴하는 selectOne().
    public ScoreDTO selectOne(int scoreNum) {
        for (ScoreDTO s : list) {
            if (s.getScoreNum()== scoreNum) {
                return new ScoreDTO(s);
            }
        }
        return null;
    }
    
    public void update(ScoreDTO s) {
        int index = list.indexOf(s);

        list.set(index, s);
    }

    public void delete(int scoreNum) {
        ScoreDTO s = new ScoreDTO();
        s.setScoreNum(scoreNum);;

        list.remove(scoreNum);
    }

    
}
