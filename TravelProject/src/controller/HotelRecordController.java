package controller;

import java.util.ArrayList;
import java.util.Calendar;

import model.HotelRecordDTO;
// 8. 방 예약 기록
//방 예약 번호, 방 번호, 예약 시작일, 예약 종료일
public class HotelRecordController {
    private ArrayList<HotelRecordDTO> list;
    private int nextId;
    
    public HotelRecordController() {
        list = new ArrayList<>();
        nextId = 1;
    }
    
    public void add(HotelRecordDTO h) {
        h.setId(nextId++);
        list.add(h);
    }
    
    public ArrayList<HotelRecordDTO> selectAll(){
        ArrayList<HotelRecordDTO> temp = new ArrayList<>();
        for(HotelRecordDTO h : list) {
            temp.add(new HotelRecordDTO(h));
        }
        return temp;
    }
    
    
    public HotelRecordDTO selectOne(int id) {
        for(HotelRecordDTO h : list) {
            if(h.getId() == id) {
                return new HotelRecordDTO(h);
            }
        }
        return null;
    }
    
    public void update(HotelRecordDTO h) {
        int index = list.indexOf(h);
        list.set(index, h);
    }
    
    // 방 취소할 때 같이 취소 되도록 만드는 메서드
    public void deleteByRoomId(int roomId) {
        for(int i = 0; i<list.size(); i++) {
            HotelRecordDTO h = list.get(i);
            if(h.getRoomId()== roomId) {
                list.remove(i);
                i= -1;
            }
        }
    }
     
    
    
}
