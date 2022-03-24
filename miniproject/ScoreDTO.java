package miniproject;

public class ScoreDTO {
   // 필드
    // 평점 번호
    private int scoreNum;
    // 작성 회원 번호 (MovieUserDTO)
    private int id;
    // 영화 번호 (MovieDTO)
    private int movieNum;
    // 평점 (double) 로 !! 5점 만점이니까.
    private double movieScore;
    private double movieScore2;
    // 평론 
    private String movieReview;
    private String movieReview2;
    
    
    public int getScoreNum() {
        return scoreNum;
    }
    public void setScoreNum(int scoreNum) {
        this.scoreNum = scoreNum;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMovieNum() {
        return movieNum;
    }
    public void setMovieNum(int movieNum) {
        this.movieNum = movieNum;
    }
    public double getMovieScore() {
        return movieScore;
    }
    public void setMovieScore(double movieScore) {
        this.movieScore = movieScore;
    }
    public String getMovieReview() {
        return movieReview;
    }
    public void setMovieReview(String movieReview) {
        this.movieReview = movieReview;
    }

    // equals() 오버라이드 scoreNum이 동일한지 
    public boolean equlas(Object o) {
        if(o instanceof ScoreDTO) {
            ScoreDTO s = (ScoreDTO)o; 
            return scoreNum == s.scoreNum;
        }
        return false;
    } 
    
    // 생성자
    public ScoreDTO() {
        
    }
    
    public ScoreDTO(ScoreDTO s) {
        this.id = s.id;
        scoreNum = s.scoreNum;
        movieNum = s.movieNum;
        movieScore = s.movieScore;
        movieReview = s.movieReview;
 
    }
    
}
