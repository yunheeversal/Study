package model;

// 8. 방 예약 기록
//방 예약 번호, 방 번호, 예약 시작일, 예약 종료일
public class HotelRecordDTO {
    private int id; // 방 예약 번호
    private int RoomId; // 방 번호
    private String bookStart; // 예약 시작일
    private String bookEnd; // 예약 종료일
    private int userId; // 회원 번호

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return RoomId;
    }

    public void setRoomId(int roomId) {
        RoomId = roomId;
    }

    public String getBookStart() {
        return bookStart;
    }

    public void setBookStart(String bookStart) {
        this.bookStart = bookStart;
    }

    public String getBookEnd() {
        return bookEnd;
    }

    public void setBookEnd(String bookEnd) {
        this.bookEnd = bookEnd;
    }

    public HotelRecordDTO() {

    }

    public HotelRecordDTO(HotelRecordDTO h) {
        id = h.id;
        RoomId = h.RoomId;
        bookStart = h.bookStart;
        bookEnd = h.bookEnd;
        userId = h.userId;
    }

}
