package march0304;

import java.util.Scanner;

public class MainIf5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();        int m = scanner.nextInt();
        int t = scanner.nextInt();
        
        h += t / 60;
        m += t % 60;

        if (m > 59) {
            h += 1;
            m -= 60;

        } 
        if (h > 23) {
            h -= 24;

        } 
            System.out.printf("%d %d\n", h, m);

        

    }

}
