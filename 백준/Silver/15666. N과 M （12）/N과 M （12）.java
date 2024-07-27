
import java.io.*;
import java.util.Arrays;

public class Main {

    static int n, m; //숫자 범위와, 길이(깊이)
    static int[] num; //사용자가 입력한 숫자
    static int[] ans; //정답을 담을 배열
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        num = new int[n];
        ans = new int[m];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < input.length; i++) {
            num[i] = input[i];
        }

        Arrays.sort(num); //오름차순 정렬
        dfs(0, 0);
        bw.close();
    }

    public static void dfs(int depth, int start) throws IOException {

        //정답 처리, 종료 부분
        if (depth == m) {
            for (int i : ans) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        int prev = -1;

        for (int i = start; i < n; i++) {

            if (prev != num[i]) {

                prev = num[i];
                ans[depth] = num[i];
                dfs(depth + 1, i);
            }

        }

    }

}
