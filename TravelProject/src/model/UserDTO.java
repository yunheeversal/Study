package model;
//1. 회원
// 회원 번호, 회원 유저네임, 회원 비밀번호, 회원 닉네임, 회원 등급
// 단, 신규 회원 등록 시 무조건 일반 회원으로 등록이 되며 별도로 신청해야 관리자가 
// 해당 회원을 여행사용 등급으로 변경 가능
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private int category; // 등급 : 일반, 여행사, 관리자 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean equals(Object o) {
        if (o instanceof UserDTO) {
            UserDTO u = (UserDTO) o;
            return id == u.id;
        }
        return false;
    }

    public UserDTO() {

    }

    public UserDTO(UserDTO u) {
        id = u.id;
        username = u.username;
        password = u.password;
        nickname = u.nickname;
        category = u.category;
    }
    
}
