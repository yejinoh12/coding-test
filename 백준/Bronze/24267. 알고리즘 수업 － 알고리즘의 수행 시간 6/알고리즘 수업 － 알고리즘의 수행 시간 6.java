import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long sum = 0;
        int tmp = n - 2;
        for (int i = 0; i < n - 2; i++) {
            sum += (long) (i + 1) * tmp--;
        }

        System.out.println(sum);
        //System.out.println(dp(n));
        System.out.println("3");

    }    }