package viewer;
// 5. 렌터카 대여 기록

//렌터카 대여 번호, 회원 번호, 렌터카 번호, 렌트 시작일, 렌트 종료일
//만약 관리자일 경우, 아직 반납이 안된 렌터카들의 목록을 찾을 수 있습니다.

import java.util.ArrayList;
import java.util.Scanner;

import model.RentRecordDTO;
import model.RentalCarDTO;
import model.UserDTO;
import util.ScannerUtil;
import controller.RentRecordController;
import controller.RentalCarController;

public class RentRecordViewer {
    private HotelViewer hotelViewer;
    private AirViewer airViewer;
    private RentalCarViewer rentalCarViewer;
    private AirRecordViewer airRecordViewer;
    private HotelRoomViewer hotelRoomViewer;
    private HotelRecordViewer hotelRecordViewer;
    private RentRecordViewer rentRecordViewer;
    private UserDTO logIn;
    private Scanner scanner;
    private UserViewer userViewer;
    private RentRecordController rentRecordController;
    private RentalCarController rentalCarController;

    public RentRecordViewer() {
        rentRecordController = new RentRecordController();
        rentalCarController = new RentalCarController();
    }

    public void setHotelViewer(HotelViewer hotelViewer) {
        this.hotelViewer = hotelViewer;
    }

    public void setAirViewer(AirViewer airViewer) {
        this.airViewer = airViewer;
    }

    public void setAirRecordViewer(AirRecordViewer airRecordViewer) {
        this.airRecordViewer = airRecordViewer;
    }

    public void setHotelRoomViewer(HotelRoomViewer hotelRoomViewer) {
        this.hotelRoomViewer = hotelRoomViewer;
    }

    public void setHotelRecordViewer(HotelRecordViewer hotelRecordViewer) {
        this.hotelRecordViewer = hotelRecordViewer;
    }

    public void setRentalCarViewer(RentalCarViewer rentalCarViewer) {
        this.rentalCarViewer = rentalCarViewer;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void showAdminMenu() {
        String message = "1. 미반납 리스트 2. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                printAllAdmin();
            } else if (userChoice == 2) {
               System.out.println("뒤로 돌아갑니다.");
                break;
            }
        }
    }
    
    public void printListAdmin() {
        ArrayList<RentRecordDTO> list = rentRecordController.selectAll();
        for (RentRecordDTO r : list) {
                System.out.println("\n=======================================");
                System.out.println("회원: " + r.getUserId());
                System.out.println("차량 번호: " + r.getCarId());
                System.out.println("차종: ");
                rentalCarViewer.printCarModel(r.getRentalCarId());
                System.out.println("색깔: ");
                rentalCarViewer.printCarColor(r.getRentalCarId());
                System.out.println("=======================================\n");
        }
    }

    public void printList() {
        ArrayList<RentRecordDTO> list = rentRecordController.selectAll();
        for (RentRecordDTO r : list) {
            if (r.getReservation() == 0) {
                System.out.println("\n=======================================");
                System.out.println("차량 번호: " + r.getCarId());
                System.out.println("차종: ");
                rentalCarViewer.printCarModel(r.getRentalCarId());
                System.out.println("색깔: ");
                rentalCarViewer.printCarColor(r.getRentalCarId());
                System.out.println("=======================================\n");
            } else {
                System.out.println("예약 가능한 차량이 없습니다.");
                rentalCarViewer.showMenu();
                break;
            }
        }

        String message = "예약할 차의 번호(차량번호x)를 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice != 0) {
            add(userChoice);
        }

    }

    // 뭐 더 넣을거 없는지 확인해 보기...
    private void add(int id) {
        RentRecordDTO r = new RentRecordDTO();
        RentalCarDTO r2 = new RentalCarDTO();
        String message;
        r.setReservation(1);
        
        r.setRentalCarId(id);
        r.setUserId(logIn.getId());
        message = "렌트할 차량번호를 입력해주세요.";
        r.setCarId(ScannerUtil.nextLine(scanner, message));
        message = "렌트를 시작할 날짜를 입력해주세요.";
        r.setRentStart(ScannerUtil.nextLine(scanner, message));
        message = "렌트를 반납할 날짜를 입력해주세요.";
        r.setRentEnd(ScannerUtil.nextLine(scanner, message));

        System.out.println("차량 [" + r.getId() + "번] 예약 성공");

        rentRecordController.add(r);
        r2.setId(id);
        r2.setReservation(1);
        rentalCarController.update(r2);
        
        printOne(id);

    }

    private ArrayList<RentRecordDTO> filterByCategory() {
        ArrayList<RentRecordDTO> list = rentRecordController.selectAll();
        ArrayList<RentRecordDTO> result = new ArrayList<>();

        for (RentRecordDTO r : list) {
            if (r.getReservation() == 0) {
                result.add(new RentRecordDTO(r));
            }
        }

        return result;
    }

    private void printAllAdmin() {
        ArrayList<RentRecordDTO> list = rentRecordController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 등록된 예약이 없습니다.");
        } else {
            for (RentRecordDTO r : list) {
                System.out.printf("%d. 차량 번호: %s \n", r.getId(), r.getCarId());

            }
            String message = "상세보기할 렌트 번호나 뒤로가실려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && rentRecordController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }

        }

    }

    private void printOne(int id) {
        RentRecordDTO r = rentRecordController.selectOne(id);

        System.out.println("\n=======================================");
        System.out.println("차량번호:" + r.getCarId());
        System.out.println("렌트일:" + r.getRentEnd());
        System.out.println("반납일:" + r.getRentStart());
        System.out.println("=======================================\n");

        if (logIn.getCategory() == 3) {
            String message = "1. 예약 삭제 2. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                deleteRecordInfo(id);
            } else if (userChoice == 2) {
                rentalCarViewer.showMenu();
            }
        } else {
            String message = "1. 예약 정보 수정 2. 예약 삭제 3. 목록으로 돌아가기";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                updateRecordInfo(id);
            } else if (userChoice == 2) {
                deleteRecordInfo(id);
            } else if (userChoice == 3) {
                rentalCarViewer.showMenu();
            }
        }

    }

    private void updateRecordInfo(int id) {
        RentRecordDTO r = rentRecordController.selectOne(id);

        String message = "변경할 차량 번호를 입력해주세요.";
        r.setCarId(ScannerUtil.nextLine(scanner, message));
        message = "변경할 렌트일을 입력해주세요.";
        r.setRentStart(ScannerUtil.nextLine(scanner, message));
        message = "변경할 반납일을 입력해주세요.";
        r.setRentEnd(ScannerUtil.nextLine(scanner, message));

        rentRecordController.update(r);
    }

    private void deleteRecordInfo(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            rentRecordController.delete(id);
            rentalCarViewer.showMenu();
        } else {
            printOne(id);
        }

    }

//    private ArrayList<RentRecordDTO> filterByCarId(String carId, int category) {
//        ArrayList<RentRecordDTO> list = rentRecordController.selectAll();
//        ArrayList<RentRecordDTO> result = new ArrayList<>();
//
//        for (RentRecordDTO r : list) {
//            if (rentalCarViewer.selectById(r.getCarId())== carId) {
//                result.add(new RentRecordDTO(r));
//            }
//        }
//
//        return result;
//    }

}
