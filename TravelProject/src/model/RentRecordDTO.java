package model;
// 5. 렌터카 대여 기록
//렌터카 대여 번호, 회원 번호, 렌터카 번호, 렌트 시작일, 렌트 종료일
//만약 관리자일 경우, 아직 반납이 안된 렌터카들의 목록을 찾을 수 있습니다.

public class RentRecordDTO {
    
    private int id; // 렌터카 대여 번호
    private int userId; // 회원 번호  - 유저 회원 번호
    private String carId; // 렌터카 번호  - 렌터카와 동일 
    private String rentStart; // 렌트 시작일 
    private String rentEnd; // 렌트 종료일
    private int reservation; // 예약 유무 0,1 로 디폴트가 0, 예약 완료가 1
    private int rentalCarId; 
    
    public int getRentalCarId() {
        return rentalCarId;
    }
    public void setRentalCarId(int rentalCarId) {
        this.rentalCarId = rentalCarId;
    }
    public int getReservation() {
        return reservation;
    }
    public void setReservation(int reservation) {
        this.reservation = reservation;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }
    public String getRentStart() {
        return rentStart;
    }
    public void setRentStart(String rentStart) {
        this.rentStart = rentStart;
    }
    public String getRentEnd() {
        return rentEnd;
    }
    public void setRentEnd(String rentEnd) {
        this.rentEnd = rentEnd;
    }
    
    public boolean equals(Object o) {
        if (o instanceof RentRecordDTO) {
            RentRecordDTO r = (RentRecordDTO) o;
            return id == r.id;
        }
        return false;
    }
    
    public RentRecordDTO() {
        
    }
    public RentRecordDTO(RentRecordDTO r) {
        id = r.id;
        userId = r.userId; // 회원 번호  - 유저 회원 번호
       carId = r.carId; // 렌터카 번호  - 렌터카와 동일 
       rentStart = r.rentStart; // 렌트 시작일 
       rentEnd = r.rentEnd;
       reservation = r.reservation;
       rentalCarId = r.rentalCarId;
    }
    
    
}
