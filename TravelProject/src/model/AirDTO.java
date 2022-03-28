package model;
//2. 항공권
//항공권 번호, 출발지, 출발 시간, 도착지, 도착 시간, 좌석
//단, 이미 예매가 완료된 항공권은 리스트에서 보이지 않습니다.

public class AirDTO {
    private int id; // 항공권 번호
    private String departure;// 출발지
    private String departureTime;// 출발 시간
    private String arrival; // 도착지
    private String arrivalTime; // 도착 시간
    private String seat; // 좌선 A1, A2 이런식이니까 일단 String으로 ! 
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDeparture() {
        return departure;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getArrival() {
        return arrival;
    }
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }
    
    public boolean equals(Object o) {
        if (o instanceof AirDTO) {
            AirDTO a = (AirDTO) o;
            return id == a.id;
        }
        return false;
    }
    
    public AirDTO() {
        
    }

    public AirDTO(AirDTO a) {
        id = a.id;
        departure = a.departure;
        departureTime = a.departureTime;
        arrival = a.arrival;
        arrivalTime = a.arrivalTime;
        seat = a.seat;

    }

    
}
