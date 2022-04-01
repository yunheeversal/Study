package controller;
import java.util.ArrayList;
import model.UserDTO;

//1. 회원
// 회원 번호, 회원 유저네임, 회원 비밀번호, 회원 닉네임, 회원 등급
// 단, 신규 회원 등록 시 무조건 일반 회원으로 등록이 되며 별도로 신청해야 관리자가 
// 해당 회원을 여행사용 등급으로 변경 가능


public class UserController {
    private ArrayList<UserDTO> list;
    private int nextId;
    
    private final String KEYWORD_BACK = "X";

    public UserController() {
        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i <= 4; i++) {
            UserDTO u = new UserDTO();
            u.setUsername("a" + i);
            u.setPassword("1");
            u.setNickname("사용자" + i);
            u.setCategory(i % 3 + 1);
            add(u);
        }
    }
    
    // 회원 추가
    public void add(UserDTO u) {
        u.setId(nextId++);
        list.add(u);
    }
    
    public boolean validateUsername(String username) {
        if (username.equalsIgnoreCase(KEYWORD_BACK)) {
            return true;
        }

        for (UserDTO u : list) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    public UserDTO auth(String username, String password) {
        for (UserDTO u : list) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                return new UserDTO(u);
            }
        }
        return null;
    }
    //관리자를 위한 회원 관리 
    public ArrayList<UserDTO> selectAll() {
        ArrayList<UserDTO> temp = new ArrayList<>();
        for (UserDTO u : list) {
                temp.add(new UserDTO(u));
        }
        return temp;
    }

    public UserDTO selectOne(int id) {
        for (UserDTO u : list) {
            if (u.getId() == id) {
                return new UserDTO(u);
            }
        }
        return null;
    }
    
 

    // 수정
    public void update(UserDTO u) {
        int index = list.indexOf(u);
        list.set(index, u);
    }

    // 삭제
    public void delete(int id) {
        UserDTO u = new UserDTO();
        u.setId(id);
        list.remove(u);
    }
    
    
    
    
    
}
