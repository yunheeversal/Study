package miniproject;

import miniproject.MovieUserDTO;

import java.util.ArrayList;

public class MovieUserController {
    private final String OPTION_GO_BACK = "X";

    
    private ArrayList<MovieUserDTO> list;
    private int nextId;
    
    // 필드를 초기화할 생성자
    public MovieUserController() {
        list = new ArrayList<>();
        nextId = 1;
        for (int i = 1; i <= 4; i++) {
            MovieUserDTO m = new MovieUserDTO();
            m.setUsername("u" + i);
            m.setNickname("사용자" + i);
            m.setPassword("1");

            add(m);
        }
    }
    
    // 번호 추가 후 list에 추가하는 add()
    public void add(MovieUserDTO m) {
        m.setId(nextId++);
        list.add(m);
    }
    
    // 회원 목록을 뷰어로 보내주는 selectAll()
    public ArrayList<MovieUserDTO> selectAll() {
        ArrayList<MovieUserDTO> temp = new ArrayList<>();
        for (MovieUserDTO m : list) {
            temp.add(new MovieUserDTO(m));
        }

        return temp;
    }
   // 회원 번호를 파라미터로 받아서 일치하는 MovieUserDTO를 리턴하는 selectOne().
    public MovieUserDTO selectOne(int id) {
        for (MovieUserDTO m : list) {
            if (m.getId() == id) {
                return new MovieUserDTO(m);
            }
        }

        return null;
    }
    
    public void update(MovieUserDTO m) {
        int index = list.indexOf(m);
        list.set(index, m);
    }

    public void delete(int id) {
        MovieUserDTO temp = new MovieUserDTO();
        temp.setId(id);
        list.remove(temp);
    }

    public boolean validateUsername(String username) {
        if (username.equalsIgnoreCase(OPTION_GO_BACK)) {
            return true;
        }

        for (MovieUserDTO m : list) {
            if (m.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    public MovieUserDTO auth(String username, String password) {
        for (MovieUserDTO m : list) {
            if (m.getUsername().equalsIgnoreCase(username) && m.getPassword().equals(password)) {
                return new MovieUserDTO(m);
            }
        }

        return null;
    }
    
    
}
