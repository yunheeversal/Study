package main;

import java.util.Scanner;
import viewer.*;

public class TravelMain {

    public static void main(String[] args) {
        UserViewer userViewer = new UserViewer();
        Scanner scanner = new Scanner(System.in);

        userViewer.setScanner(scanner);
        
        userViewer.showIndex();
        
    }

}
