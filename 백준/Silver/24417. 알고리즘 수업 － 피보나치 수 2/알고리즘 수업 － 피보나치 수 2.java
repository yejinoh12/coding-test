import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(dp_fib(n) + " ");
        System.out.print(count % 1_000_000_007);
    }


    public static int dp_fib(int n) {

        int[] f = new int[n + 1];

        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            count++ ;
            f[i] = (f[i - 1] + f[i - 2])  % 1_000_000_007 ;
        }

        return f[n];
    }

}
