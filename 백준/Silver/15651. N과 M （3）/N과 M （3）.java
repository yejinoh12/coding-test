import java.io.*;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        arr = new int[M];

        backTracking(0);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    static void backTracking(int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {

            arr[depth] = i + 1;
            backTracking(depth + 1);

        }
    }
}

