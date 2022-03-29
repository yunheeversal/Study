package controller;
import java.util.ArrayList;
import java.util.Calendar;

//3. 항공권 예매 기록
//예매 번호, 항공권 번호, 예매 회원 번호, 예매일
import model.AirRecordDTO;
public class AirRecordController {
    private ArrayList<AirRecordDTO> list;
    private int nextId;
    
    public AirRecordController() {
        list = new ArrayList<>();
        nextId = 1;
        
    }
    
    public void add(AirRecordDTO a) {
        a.setId(nextId++);
        a.setReservationDate(Calendar.getInstance());
        list.add(a);
    }
    
    public ArrayList<AirRecordDTO> selectAll(){
        ArrayList<AirRecordDTO> temp = new ArrayList<>();
        for(AirRecordDTO a : list) {
            temp.add(new AirRecordDTO(a));
        }
        return temp;
    }
    
    
    public AirRecordDTO selectOne(int id) {
        for(AirRecordDTO a : list) {
            if(a.getId() == id) {
                return new AirRecordDTO(a);
            }
        }
        return null;
    }
    
    public void update(AirRecordDTO a) {
        int index = list.indexOf(a);
        list.set(index, a);
    }
    
    public void delete(int id) {
        AirRecordDTO a = new AirRecordDTO();
        a.setId(id);

        list.remove(a);
    }
    
    // 항공권 취소할 때 같이 취소 되도록 만드는 메서드
    public void deleteByTicketId(int ticketId) {
        for(int i = 0; i<list.size(); i++) {
            AirRecordDTO a = list.get(i);
            if(a.getTicketId()== ticketId) {
                list.remove(i);
                i= -1;
            }
        }
    }
    // 회원 탈퇴할 때 같이 취소 되도록 만드는 메서드
    public void deleteByUserId(int userId) {
        for(int i = 0; i<list.size(); i++) {
            AirRecordDTO a = list.get(i);
            if(a.getUserId() == userId) {
                list.remove(i);
                i= -1;
            }
        }
    }
    
}
