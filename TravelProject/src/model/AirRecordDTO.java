package model;

//3. 항공권 예매 기록
//예매 번호, 항공권 번호, 예매 회원 번호, 예매일
// 항공권과 연결 !!


public class AirRecordDTO {
    private int id; // 예매 번호
    private int ticketId; // 항공권 번호
    private int userId; // 회원 번호
    private String reservationDate; // 예매일

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
    
    public boolean equals(Object o) {
        if (o instanceof AirRecordDTO) {
            AirRecordDTO a = (AirRecordDTO) o;
            return id == a.id;
        }
        return false;
    }

    public AirRecordDTO() {

    }

    public AirRecordDTO(AirRecordDTO a) {
        id= a.id;
        ticketId = a.ticketId;
        userId = a.userId;
        reservationDate =a.reservationDate;
    }

}
