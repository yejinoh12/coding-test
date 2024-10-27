
import java.io.*;
import java.util.Arrays;

public class Main {

    static int N, S, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        S = input[1];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        backTracking(0, 0);
        
        if (S == 0) ans--;

        bw.write(ans + "");
        bw.flush();
        bw.close();

    }

    public static void backTracking(int depth, int sum) {

        if (depth == N) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        backTracking(depth + 1, sum + arr[depth]);
        backTracking(depth + 1, sum);

    }
}
