package homework;

import java.util.Random;
import java.util.Scanner;
import util.ArrayUtil;
import util.ScannerUtil;

// ArrayUtil을 사용하여
// 동적할당이 적용된 컴퓨터 로또 번호 추첨기를 만드시오
// 심화) 다양한 메소드를 만들어서 사용자가 여러 게임을 하는 경우도 대비하시오. (몇 개 맞췄는지도 나와야함)
public class Ex03Lotto02 {
    // 전역 상수
    // 1. 로또의 최소 숫자
    public static final int LOTTO_MIN = 1;
    // 2. 로또의 최대 숫자
    public static final int LOTTO_MAX = 45;
    // 3. 뽑을 숫자의 총 갯수
    public static final int MAX_LENGTH = 6;
    
    // 전역 변수
    // 1. 컴퓨터의 숫자를 저장할 int 1차원 배열 선언과 초기화
    public static int[] computerNumbers;
    // 2. 사용자의 게임들을 담을 int 2차원배열 -> 심화 단계 !
    public static int[][] userNumbers;
    // 3. 입력에서 사용할 Scanner 클래스 변수
    public static Scanner scanner;


    public static void main(String[] args) {
        // 0. 입력에서 사용할 scanner 전역변수 초기화
        scanner = new Scanner(System.in);
        // 1. computerNumbers를 길이가 0인 배열로 초기화 한다.
        computerNumbers = new int[0]; // int array를 쓰면 크기가 자유자재로 늘어날테니.

        // 2. computerNumbers에 중복되지 않는 랜덤숫자를 메소드를 사용하여 추가한다.
        computerNumbers = insertRandomNum(); // computerNumbers에 중복되지 않는 랜덤숫자를 저장한다.
        // 3. computerNumbers의 저장된 값을 메소드를 사용하여 오름차순 정렬한다.
        sort(computerNumbers);
        
        // 4. 사용자로부터 총 몇게임을 할지 입력받아서 2차원 배열의 길이를 지정한다.
        int gameSize = ScannerUtil.nextInt(scanner, "총 몇게임을 하시겠습니까?");
        userNumbers = new int[gameSize][0];
        
        // 5. 각 게임마다 자동/ 수동 입력 받아 각각 다른 메소드를 실행시킨다.
        //   각 배열을 정렬한다
         setMode();
        
         // 6. 메소드를 사용하여 결과를 출력한다. 
         printResult();
         
        // 6. computerNumbers의 저장된 값을 출력한다.
        printArray(computerNumbers);
        
        // 7. 사용자 2차원 배열의 각 배열을 출력하고 총 맞은 갯수를 출력한다. 
        

    }

    // 배열에 MAX_LENGTH 만큼 랜덤 숫자를 추가하는 insertRandomNum()
    public static int[] insertRandomNum() { // 직접 컴퓨터번호 넣으면 사용자 배열 추가할때 이 메서드를 그대로 사용할 수 없으니까.
        // while문을 사용하여
        // 특정 배열의 크기가 MAX_LENGTH보다 작을 동안
        // 중복되지 않는 숫자를 해당 배열에 추가한다.

        // 랜덤 숫자를 담을 int 배열 선언 및 크기를 0으로 초기화 한다.
        int[] array = new int[0];
        // 랜덤 숫자를 뽑을 때 사용할 Random 클래스 변수
        Random random = new Random();

        while (ArrayUtil.size(array) < MAX_LENGTH) {
            // int temp에 1~45 사이의 랜덤 숫자 지정
            int temp = random.nextInt(LOTTO_MAX) + LOTTO_MIN;

            // 만약 array에 temp가 존재하지 않는다면
            // array에 temp를 추가 (D. 해당 배열에 특정 값이 존재하는지 확인해 주는 contains(int[], int)를 사용해서!)
            if (!ArrayUtil.contains(array, temp)) {
                array = ArrayUtil.add(array, temp); // 새로운 주소값이 들어갈텐데 컴퓨터 넘버 안의 내용은 바뀌는게 없을테니까.. 그저 값을 읽기만 하니까?
                                                    // 그래서 타입을 void 에서 int[]로 남겨서 반환값을 만들어야 한다.
            }
        }
        return array;
    }

    // int 배열에 저장된 값을 오름차순 정렬하는 sort(int[])
    public static void sort(int[] array) {
        for (int i = 0; i < ArrayUtil.size(array) - 1; i++) {
            if (ArrayUtil.get(array, i) > ArrayUtil.get(array, i + 1)) {
                // I. 해당 배열의 특정 인덱스에 새로운 값을 저장하고 원래 있던 값은 리턴하는 set(int[], int, int)
                ArrayUtil.set(array, i + 1, ArrayUtil.set(array, i, ArrayUtil.get(array, i + 1)));

                i = -1;
            }
        }
    }

    // 파라미터로 넘어온 배열을 출력하는 메소드
    public static void printArray(int[] array) {
        for (int i = 0; i < ArrayUtil.size(array); i++) {
            System.out.printf("%2d", ArrayUtil.get(array, i));
            if (i != ArrayUtil.size(array) - 1) {
                System.out.print(", ");

            }

        }

    }

    // 사용자로부터 입력을 받아서 각 게임을 자동으로 할지 수동으로 할지 결정하는 메소드
    public static void setMode() {
        for (int i = 0; i < userNumbers.length; i++) {
            System.out.printf("%d번째 게임\n", i+1);
            String message = "1. 자동 2. 수동";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if(userChoice == 1) {
                // 사용자가 자동을 선택했을 때
                userNumbers[i] = insertRandomNum(); // 랜덤 만드는거 메서드 만들었으니까 ~~ 
                
            }else if(userChoice == 2) {
                // 사용자가 수동을 선택했을 때
                userNumbers[i] = insertNum();
                
            }
            // userNumbers의 i번째 배열을 sort()를 사용하여 정렬한다.
            sort(userNumbers[i]);
            
        }
        
    }
    
    // 사용자가 수동을 선택했을 경우 사용자가 입력한 유효한 숫자를 배열에 저장하는 메소드
    public static int[] insertNum() {
        // 사용자가 입력한 숫자를 저장할 배열
        int[] array = new int[0];
        
        // 지금 몇번째 숫자를 입력할 차례인지
        // 알려줄 때 사용할 count 변수
        int count = 1;
        
        while(ArrayUtil.size(array) < MAX_LENGTH) {
            System.out.println("-----------------");
            System.out.println(count + "번째 숫자");
            System.out.println("-----------------\n");
            String message = count + "번째 숫자를 입력해 주세요.";
            
            int temp = ScannerUtil.nextInt(scanner, message, LOTTO_MIN, LOTTO_MAX);
            
            if(!(ArrayUtil.contains(array, temp))) { // 유효한 숫자일 때만 중복이 아닐때만 count 추가할 수 있도록. 
                array = ArrayUtil.add(array, temp);
                count ++;
            }else {
                System.out.println("해당 숫자는 중복된 숫자입니다. ");
            }
        }
        // 결과값 리턴
       return array;
    }

    // 결과를 출력하는 printResult()
    public static void printResult() {
        // 1. 컴퓨터 배열을 출력
       System.out.println("\n=====================");
       System.out.println("컴퓨터의 숫자");
       System.out.println("======================\n");
       System.out.print("[");
       printArray(computerNumbers);
       System.out.print("]");
        
        // 2. 사용자 배열의 각 배열과 맞은 갯수를 출력 
       System.out.println("\n=====================");
       System.out.println("사용자의 숫자");
       System.out.println("======================\n");
       System.out.print("[");
       for(int i = 0; i < userNumbers.length; i++) {
           System.out.print((i+1) +"번 게임: [");
           printArray(userNumbers[i]);
           System.out.print("] - 총 맞은 갯수: " + countSameNum(computerNumbers,userNumbers[i]));
       }
   
    }
    // 컴퓨터 배열과 사용자 배열을 비교해서 총 맞은 갯수를 리턴하는 countSameNum()
    public static int countSameNum(int[] array1, int[] array2) {
        int count =0;
        
        for(int i = 0; i < ArrayUtil.size(array1); i++) {
            for( int j = 0; j< ArrayUtil.size(array2); j++) {
               if(ArrayUtil.get(array1, i) == ArrayUtil.get(array2, j)) {// 다시 하기 
                count++;
                }
            }
        }
        
        return count;
    }
    
}
