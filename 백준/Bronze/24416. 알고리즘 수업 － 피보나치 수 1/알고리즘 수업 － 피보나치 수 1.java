import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int rec_fib_count = 0;
    static int dp_fib_count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        rec_fib(n);
        System.out.println(rec_fib_count);

        dp_fib(n);
        System.out.println(dp_fib_count);
    }

    public static int rec_fib(int n) {
        if (n == 1 || n == 2) {
            ++ rec_fib_count;
            return 1;
        } else {
            return (rec_fib(n - 1) +rec_fib(n - 2));
        }
    }

    public static void dp_fib(int n) {

        int[] f = new int[n + 1];

        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            ++ dp_fib_count;
            f[i] = f[i - 1] + f[i - 2];
        }

        //return f[n];
    }
}
