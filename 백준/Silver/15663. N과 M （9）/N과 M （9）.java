
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int n, m;
    public static int[] num; //입력 받을 숫자 배열
    public static int[] ans; //정답 배열
    public static boolean[] v; //방문 여부 체크 배열
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //초기화
        n = arr[0];
        m = arr[1];

        num = new int[n];
        ans = new int[m];
        v = new boolean[n];

        int[] inputNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(inputNum); //정렬

        for (int i = 0; i < n; i++) {
            num[i] = inputNum[i];
        }

        dfs(0); //함수 호출
        bw.close();

    }

    public static void dfs(int depth) throws IOException {

        if (depth == m) {

            for (int i : ans) {
                bw.write(i + " ");
            }
            bw.write("\n");

            return;
        }

        /**
         * 깊이가 한단계 깊어질 때마다 prev 초기화
         */

        int prev = -1;

        //System.out.println(depth + " " + prev);

        for (int i = 0; i < n; i++) {

            if (!v[i] && prev != num[i]) {

                prev = num[i];
                v[i] = true;
                ans[depth] = num[i];

                dfs(depth + 1);

                v[i] = false;
            }
        }
    }
}
