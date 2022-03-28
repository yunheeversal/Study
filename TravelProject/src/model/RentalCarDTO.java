package model;
// 4. 렌터카
//렌터카 번호, 차량 등록 번호(=흔히 말하는 번호판 번호), 차종, 색깔
//만약 고객이 해당 렌터카를 예약 했을 경우, 더이상 예약 가능 목록에 보이지 않습니다.

public class RentalCarDTO {
    private int id; // 렌터카 번호
    private String carId; // 차량 등록 번호
    private String carModel; // 차종
    private String carColor; // 색깔
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public String getCarColor() {
        return carColor;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    
    public boolean equals(Object o) {
        if (o instanceof RentalCarDTO) {
            RentalCarDTO r = (RentalCarDTO) o;
            return id == r.id;
        }
        return false;
    }

    public RentalCarDTO(){
        
    }
    public RentalCarDTO(RentalCarDTO r){
        id = r.id;
        carId = r.carId; // 차량 등록 번호
        carModel = r.carModel; // 차종
       carColor = r.carColor; // 색깔
    }
    
    
}
