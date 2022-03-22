package miniproject;


public class MovieDTO {
   // 필드
    // 영화 번호 
    private int movieNum;
    // 영화 제목
    private String title;
    // 영화 줄거리
    private String summary;
    // 영화 등급
    private String rating;
    
    public int getMovieNum() {
        return movieNum;
    }
    public void setMovieNum(int movieNum) {
        this.movieNum = movieNum;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    // equals() 오버라이드 , movieNum이 같은지 ...! 
    public boolean equlas(Object o) {
        if(o instanceof MovieDTO) {
            MovieDTO m = (MovieDTO)o; 
            return movieNum == m.movieNum;
        }
        return false;
    } 
    
    // 생성자
    public MovieDTO() {
        
    }
    
    public MovieDTO(MovieDTO m) {
        movieNum = m.movieNum;
        title = m.title;
        summary = m.summary;
        rating = m.rating;
        
    }
    
    
}
