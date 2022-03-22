package miniproject;


public class TheaterDTO {
   // 필드
    // 극장 번호
    private int theaterNum;
    // 극장 이름
    private String theaterName;
    // 극장 위치
    private String theaterLocation;
    // 극장 전화번호 
    private int theaterTel;
    
    public int getTheaterNum() {
        return theaterNum;
    }
    public void setTheaterNum(int theaterNum) {
        this.theaterNum = theaterNum;
    }
    public String getTheaterName() {
        return theaterName;
    }
    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
    public String getTheaterLocation() {
        return theaterLocation;
    }
    public void setTheaterLocation(String theaterLocation) {
        this.theaterLocation = theaterLocation;
    }
    public int getTheaterTel() {
        return theaterTel;
    }
    public void setTheaterTel(int theaterTel) {
        this.theaterTel = theaterTel;
    }

    
    // equals() 오버라이드
    public boolean equlas(Object o) {
        if(o instanceof TheaterDTO) {// instanceof로 형변환 가능 여부 확인 
            TheaterDTO t = (TheaterDTO)o; // User타입으로 o를 덮어씌운다. 
            return theaterNum == t.theaterNum;
        }
        return false;
    }
    
    // 생성자
    public TheaterDTO() {
        
    }
    
    public TheaterDTO(TheaterDTO t) {
        this.theaterNum = t.theaterNum;
        this.theaterName = t.theaterName;
        this.theaterLocation = t.theaterLocation;
        this.theaterTel = t.theaterTel;

    }
    
    
}
