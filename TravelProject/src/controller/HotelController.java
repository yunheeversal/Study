package controller;
import java.util.ArrayList;

// 6. 호텔
//호텔 번호, 호텔 이름, 호텔 위치, 등급(5성, 4성 등등), 호텔 전화번호
import model.HotelDTO;
public class HotelController {
    private ArrayList<HotelDTO> list;
    private int nextId;
    
    public HotelController() {
        list = new ArrayList<>();
        nextId = 1;
        
        for(int i = 1; i <= 4 ; i++) {
            HotelDTO h = new HotelDTO();
            h.setHotelName("호텔" + i);
            h.setHotelGrade(i/3+1);
            h.setHotelAddress("일본 오사카시 요도가와구 나카지마" +i+"-"+(i*2));
            h.setHotelTel("080-"+i*100+"-6789");
            
            add(h);
        }
        
    }
    
    public ArrayList<HotelDTO> selectAll() {
        ArrayList<HotelDTO> temp = new ArrayList<>();
        for (HotelDTO h : list) {
            temp.add(new HotelDTO(h));
        }
        return temp;
    }
    
    public void add(HotelDTO h) {
        h.setId(nextId++);
        list.add(h);
    }
    
    public HotelDTO selectOne(int id) {
        for (HotelDTO h : list) {
            if (h.getId() == id) {
                return new HotelDTO(h);
            }
        }
        return null;
    }

    public void update(HotelDTO h) {
        int index = list.indexOf(h);
        list.set(index, h);
    }

    public void delete(int id) {
        HotelDTO h = new HotelDTO();
        h.setId(id);

        list.remove(h);
    }
    
    
}
