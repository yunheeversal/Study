package miniproject;


public class MovieUserDTO {
    // 필드
    // 회원번호 
    private int id;
    // 로그인 아이디
    private String username;
    // 비밀번호
    private String password;
    // 닉네임
    private String nickname;
    // 등급
    private int userRank;
    
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
    public int getUserRank() {
        return userRank;
    }
    public void setUserRank(int rank) {
        this.userRank = rank;
    }
    
    
    
    // equals() 오버라이드
    public boolean equlas(Object o) {
        if(o instanceof MovieUserDTO) { 
            MovieUserDTO u = (MovieUserDTO)o;  
            return id == u.id;
        }
        return false;
    }
    
    // 생성자
    public MovieUserDTO() {
        
    }
    
    public MovieUserDTO(MovieUserDTO u) {
        this.id = u.id;
        username = u.username;
        password = u.password ;
        nickname = u.nickname;
        userRank = u.userRank;
    }
    
    
}
