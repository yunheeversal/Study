package controller;
import java.util.ArrayList;

//2. 항공권
//항공권 번호, 출발지, 출발 시간, 도착지, 도착 시간, 좌석
//단, 이미 예매가 완료된 항공권은 리스트에서 보이지 않습니다.
import model.AirDTO;

public class AirController {
    private ArrayList<AirDTO> list;
    private int nextId;
    
    public AirController() {
        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i <= 4; i++) {
            AirDTO a = new AirDTO();
            a.setArrival("몰디브");
            a.setArrivalTime((i + 9) + ":00 ~ " + (i + 11) + ":30");
            a.setDeparture("한국");
            a.setDepartureTime((i + 5) + ":00 ~ " + (i + 7) + ":30");
            a.setSeat("A%d열\n"+i);
            add(a);
        }
    }
    public void add(AirDTO a) {
        a.setId(nextId++);

        list.add(a);
    }
    
    public ArrayList<AirDTO> selectAll() {
        ArrayList<AirDTO> temp = new ArrayList<>();
        for (AirDTO a : list) {
                temp.add(new AirDTO(a));
        }
        return temp;
    }
    
    // 예매가 완료된 항공권은 리스트에 보이지 않게 하기..!! 
    // 선택지로 해서 예매 된 것은 따로 보이게 하는 것으로?
    
    // 예매 완료된 항공권 리스트 -> 어떻게 만들면 좋을까? 
    public void bookingComplete() {
        
    }
    
    
    public AirDTO selectOne(int id) {
        for(AirDTO a : list) {
            if(a.getId() == id) {
                return new AirDTO(a);
            }
        }
        return null;
    }
    
    public void update(AirDTO a) {
        int index = list.indexOf(a);
        list.set(index, a);
    }
    
    public void delete(int id) {
        AirDTO a = new AirDTO();
        a.setId(id);
        
        list.remove(a);
    }
    
    
    
}
