package march0304;

import java.util.Scanner;

public class MainIf1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A, B;
       
        A= scanner.nextInt();
        B= scanner.nextInt();
        scanner.close();
                
        System.out.println(((A>B)?">":(A<B)?"<":"=="));
        
    }

}
