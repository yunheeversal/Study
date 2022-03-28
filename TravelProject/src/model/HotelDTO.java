package model;
// 6. 호텔
//호텔 번호, 호텔 이름, 호텔 위치, 등급(5성, 4성 등등), 호텔 전화번호

public class HotelDTO {
    private int id; // 호텔 번호
    private String hotelName; //  호텔 이름
    private String hotelAddress; //  호텔 위치
    private int hotelGrade; // 등급
    private String hotelTel; // 호텔 전화번호
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public String getHotelAddress() {
        return hotelAddress;
    }
    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }
    public int getHotelGrade() {
        return hotelGrade;
    }
    public void setHotelGrade(int hotelGrade) {
        this.hotelGrade = hotelGrade;
    }
    public String getHotelTel() {
        return hotelTel;
    }
    public void setHotelTel(String hotelTel) {
        this.hotelTel = hotelTel;
    }
    
    public boolean equals(Object o) {
        if (o instanceof HotelDTO) {
            HotelDTO h = (HotelDTO) o;
            return id == h.id;
        }
        return false;
    }
    
    public HotelDTO() {
        
    }
    public HotelDTO(HotelDTO h) {
        id = h.id;
        hotelName = h.hotelName; //  호텔 이름
        hotelAddress = h.hotelAddress; //  호텔 위치
        hotelGrade = h.hotelGrade; // 등급
        hotelTel =h.hotelTel; // 호텔
        
    }
    
}
