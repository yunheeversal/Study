package controller;
// 4. 렌터카

//렌터카 번호, 차량 등록 번호(=흔히 말하는 번호판 번호), 차종, 색깔
//만약 고객이 해당 렌터카를 예약 했을 경우, 더이상 예약 가능 목록에 보이지 않습니다.

import java.util.ArrayList;

import model.RentalCarDTO;

public class RentalCarController {
    private ArrayList<RentalCarDTO> list;
    private int nextId;

    public RentalCarController() {
        list = new ArrayList<>();
        nextId = 1;
        for (int i = 1; i <= 4; i++) {
            RentalCarDTO r = new RentalCarDTO();
            r.setCarId("허12345");
            r.setCarModel("벤츠 S" + i);
            r.setCarColor("검정");

            add(r);
        }
    }
    
    public ArrayList<RentalCarDTO> selectAll() {
        ArrayList<RentalCarDTO> temp = new ArrayList<>();
        for (RentalCarDTO r : list) {
            temp.add(new RentalCarDTO(r));
        }
        return temp;
    }

    public void add(RentalCarDTO r) {
        r.setId(nextId++);
        list.add(r);
    }

    public RentalCarDTO selectOne(int id) {
        for (RentalCarDTO r : list) {
            if (r.getId() == id) {
                return new RentalCarDTO(r);
            }
        }
        return null;
    }

    public void update(RentalCarDTO r) {
        int index = list.indexOf(r);
        list.set(index, r);
    }

    public void delete(int id) {
        RentalCarDTO r = new RentalCarDTO();
        r.setId(id);

        list.remove(r);
    }

}
