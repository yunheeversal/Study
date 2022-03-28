package controller;
// 5. 렌터카 대여 기록

//렌터카 대여 번호, 회원 번호, 렌터카 번호, 렌트 시작일, 렌트 종료일
//만약 관리자일 경우, 아직 반납이 안된 렌터카들의 목록을 찾을 수 있습니다.

import java.util.ArrayList;

import model.RentRecordDTO;

public class RentRecordController {
    private ArrayList<RentRecordDTO> list;
    private int nextId;

    public RentRecordController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public void add(RentRecordDTO r) {
        r.setId(nextId++);
        list.add(r);
    }

    public ArrayList<RentRecordDTO> selectAll() {
        ArrayList<RentRecordDTO> temp = new ArrayList<>();
        for (RentRecordDTO r : list) {
            temp.add(new RentRecordDTO(r));
        }
        return temp;
    }

    public RentRecordDTO selectOne(int id) {
        for (RentRecordDTO r : list) {
            if (r.getId() == id) {
                return new RentRecordDTO(r);
            }
        }
        return null;
    }
    
    // 아직 반납이 안된 렌터카들의 목록 (관리자, 여행자 직원)

    
    
    
    public void update(RentRecordDTO r) {
        int index = list.indexOf(r);
        list.set(index, r);
    }

    // 차량 삭제될 때 같이 취소 되도록 만드는 메서드
    public void deleteByCarId(int carId) {
        for (int i = 0; i < list.size(); i++) {
            RentRecordDTO r = list.get(i);
            if (r.getCarId() == carId) {
                list.remove(i);
                i = -1;
            }
        }
    }

    // 회원 삭제 될 때 예약 기록 삭제하게 만드는 메서드
    public void deleteByUserId(int userId) {
        for (int i = 0; i < list.size(); i++) {
            RentRecordDTO r = list.get(i);
            if (r.getUserId() == userId) {
                list.remove(i);
                i = -1;
            }
        }
    }

}
