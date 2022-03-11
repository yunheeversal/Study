package march0304;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
   
        int ab1 = a*((b%100)%10);
        int ab2 = a*((b%100)/10);
        int ab3 = a*(b/100);
        int answer = a*b;
        
        System.out.println(ab1);
        System.out.println(ab2);
        System.out.println(ab3);
        System.out.println(answer);
        
        
        
    }

}
