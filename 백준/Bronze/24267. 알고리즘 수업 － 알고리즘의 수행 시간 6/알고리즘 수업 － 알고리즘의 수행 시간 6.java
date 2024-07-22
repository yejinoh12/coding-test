import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //MenOfPassion(n);
        System.out.println(dp(n));
        System.out.println("3");

    }

    public static long dp(int n) {
        
        if(n <= 1) return 0;

        long[] array = new long[n - 2];


        for (int i = 0; i < n - 2; i++) {
            array[i] = i + 1;
        }

        long sum = 0;
        int k = 1;
        for(int i = array.length - 1 ; i >= 0; i--){
            sum += array[i] * k++;
        }

        return sum;
    }

    public static void MenOfPassion(int n) {
        int ic = 0;
        int jc = 0;
        int kc = 0;

        for (int i = 0; i < n - 2; i++) { // n- 2
            ic++;
            for (int j = i + 1; j < n - 1; j++) {
                jc++;
                for (int k = j + 1; k < n; k++) {
                    kc++;
                }
            }
        }

        //5일 때 3, 6, 10 // 10일 때 8, 36, 120 //20일때 18, 171, 1140
        System.out.println("ic = " + ic);
        System.out.println("jc = " + jc);
        System.out.println("kc = " + kc);
    }
}
