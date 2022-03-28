package model;

// 7. 방
//방 번호(=id), 호텔 번호, 방 위치(###호), 가격
//단, 예약 가능 목록만 보여줄 수 있도록 합니다.
public class HotelRoomDTO {
    private int id; // 방 번호
    private int hotelId; // 호텔 번호
    private int roomLocation; // 방 위치 (int로 하고 나중에 "호" 붙이는 방법으로)
    private int roomPrice; // 가격

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(int roomLocation) {
        this.roomLocation = roomLocation;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public boolean equals(Object o) {
        if (o instanceof HotelRoomDTO) {
            HotelRoomDTO h = (HotelRoomDTO) o;
            return id == h.id;
        }
        return false;
    }

    public HotelRoomDTO() {

    }

    public HotelRoomDTO(HotelRoomDTO h) {
        id = h.id;
        hotelId = h.hotelId; 
        roomLocation = h.roomLocation;
        roomPrice = h.roomPrice;
    }

}
