package miniproject;

import java.util.ArrayList;
import miniproject.MovieDTO;
import model.StudentDTO;

// 평점 보기 해결 해보기.. 

public class MovieController {
    
    private ArrayList<MovieDTO> list;
    // 다음 입력할 번호를 저장할 int 필드
    private int nextId;
    // 필드를 초기화할 생성자
    public MovieController() {
        list = new ArrayList<>();
        nextId = 1;
        
        for (int i = 1; i <= 4; i++) {
            MovieDTO m = new MovieDTO();
            m.setRating("전체 관람가");
            m.setTitle("영화" + i);
            m.setSummary("이건 "+ i +"점짜리 영화입니다.");
            
            add(m);
        }
        
    }
    

    // 관리자 전용 : 영화 번호 추가 후 list에 추가하는 add()
    public void add(MovieDTO m) {
        m.setMovieNum(nextId++);
        list.add(m);
    }
    // 영화 목록을 뷰어로 보내주는 selectAll()
    public ArrayList<MovieDTO> selectAll() {
        ArrayList<MovieDTO> temp = new ArrayList<>();
        
        for (MovieDTO m : list) {
            temp.add(new MovieDTO(m));
        }
        return temp;
    }
    
    // 영화 번호를 파라미터로 받아서 일치하는 MovieDTO를 리턴하는 selectOne().
    
    public MovieDTO selectOne(int movieNum) {
//        MovieDTO m = new MovieDTO();
//        m.setMovieNum(movieNum);
//        if(list.contains(m)) {
//            return new MovieDTO(list.get(list.indexOf(m)));
//        }
        
        for (MovieDTO m : list) {
            if (m.getMovieNum() == movieNum) {
                return new MovieDTO(m);
            }
        }
        return null;
    }
    
    // 영화 전체 평점
    // 영화 평론가 평점
    // 일반 관람객 평점 
    
    // 관리자 전용 
    

    
    // 관리자 전용 :  update
    public void update(MovieDTO m) {
        int index = list.indexOf(m)+1;
       list.set(list.indexOf(m),m); //아. 내가 1번2번 이렇게 지정했으니 배열은 0부터니까!! 
        
        
    }
    // 관리자 전용 delete
    public void delete(int movieNum) {
        MovieDTO temp = new MovieDTO();
        temp.setMovieNum(movieNum);
        
        list.remove(temp);
          
    }
    
    
    
}
