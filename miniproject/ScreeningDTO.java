package miniproject;

import java.util.Calendar;
import miniproject.TheaterDTO;

public class ScreeningDTO {
    private TheaterDTO  t;
   // 필드
    // 상영정보 번호
    private int screeningNum;
    // 영화 번호
    private int movieNum;
    // 극장 번호
    private int theaterNum;
    // 상영 시간 
    private Calendar screeningDate;
    
    public int getScreeningNum() {
        return screeningNum;
    }
    public void setScreeningNum(int screeningNum) {
        this.screeningNum = screeningNum;
    }
    public int getMovieNum() {
        return movieNum;
    }
    public void setMovieNum(int movieNum) {
        this.movieNum = movieNum;
    }
    public int getTheaterNum() {
        return theaterNum;
    }
    public void setTheaterNum(int theaterNum) {
        this.theaterNum = theaterNum;
    }
    public Calendar getScreeningDate() {
        return screeningDate;
    }
    public void setScreeningDate(Calendar screeningDate) {
        this.screeningDate = screeningDate;
    }
    
    
    // equals() 오버라이드
    public boolean equlas(Object o) {
        if(o instanceof ScreeningDTO) {// instanceof로 형변환 가능 여부 확인 
            ScreeningDTO s = (ScreeningDTO)o; // User타입으로 o를 덮어씌운다. 
            return screeningNum == s.screeningNum;
        }
        return false;
    }
    
    
    // 생성자
    
    public ScreeningDTO () {
        
    }
    
    public ScreeningDTO (ScreeningDTO s) {
        this.screeningNum = s.screeningNum;
//        movieNum = s.movieNum;
//        theaterNum = s.theaterNum;
        screeningDate = s.screeningDate;
    }
    
    
    
}
