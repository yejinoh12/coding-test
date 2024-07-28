
import java.io.*;
import java.util.Arrays;

public class Main {

    static int N, M;
    static String[] p;
    static String[] ans;
    static int[] checkV;
    static int[] checkC;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = input[1]; //범위
        M = input[0]; //깊이

        p = br.readLine().split(" ");
        Arrays.sort(p); //사전순 정렬
        ans = new String[M];
        checkV = new int[M];
        checkC = new int[M];

        dfs(0, 0);
        bw.close();

    }

    public static void dfs(int depth, int start) throws IOException {

        if (depth == M) {

            int countV = 0;
            for (int i : checkV) {
                if (i == 1) countV++;
            }
            int countC = 0;
            for (int i : checkC) {
                if (i == 1) countC++;
            }

            if (countV >= 1 && countC >= 2) {
                for (String i : ans) {
                    bw.write(i);
                }
                bw.write("\n");
            }

            return;
        }

        for (int i = start; i < N; i++) {

            if (p[i].equals("a") || p[i].equals("e") || p[i].equals("i") || p[i].equals("o") || p[i].equals("u")) {
                checkV[depth] = 1;
            } else {
                checkC[depth] = 1;
            }

            ans[depth] = p[i];
            dfs(depth + 1, i + 1);
            checkV[depth] = 0;
            checkC[depth] = 0;

        }
    }
}
