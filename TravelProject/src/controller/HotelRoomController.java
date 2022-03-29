package controller;
// 7. 방
//방 번호(=id), 호텔 번호, 방 위치(###호), 가격
//단, 예약 가능 목록만 보여줄 수 있도록 합니다.

import java.util.ArrayList;

import model.HotelDTO;
import model.HotelRoomDTO;
public class HotelRoomController {
    private ArrayList<HotelRoomDTO> list;
    private int nextId;
    
    public HotelRoomController() {
        list = new ArrayList<>();
        nextId = 1;
        for(int i = 0; i<=4;i++ ) {
            HotelRoomDTO h  = new HotelRoomDTO();
            h.setHotelId(i+1);
            h.setRoomLocation(i+100);
            h.setRoomPrice((i+1)*100000);
            
            add(h);
        }
        
    }
    
    public void add(HotelRoomDTO h) {
        h.setId(nextId++);
        list.add(h);
    }
    
    public ArrayList<HotelRoomDTO> selectAll(){
        ArrayList<HotelRoomDTO> temp = new ArrayList<>();
        for(HotelRoomDTO h : list) {
            temp.add(new HotelRoomDTO(h));
        }
        return temp;
    }
    
    // 예약 가능한 목록만 만들어주는 기능...
    
    
    public HotelRoomDTO selectOne(int id) {
        for(HotelRoomDTO h : list) {
            if(h.getId() == id) {
                return new HotelRoomDTO(h);
            }
        }
        return null;
    }
    
    public void update(HotelRoomDTO h) {
        int index = list.indexOf(h);
        list.set(index, h);
    }
    
    public void delete(int id) {
        HotelRoomDTO h = new HotelRoomDTO();
        h.setId(id);

        list.remove(h);
    }
    
    
    // 호텔 삭제?될 때 같이 취소 되도록 만드는 메서드
    public void deleteByHotelId(int hotelId) {
        for(int i = 0; i<list.size(); i++) {
            HotelRoomDTO h = list.get(i);
            if(h.getHotelId() == hotelId) {
                list.remove(i);
                i= -1;
            }
        }
    }
    
    
    
    
}
