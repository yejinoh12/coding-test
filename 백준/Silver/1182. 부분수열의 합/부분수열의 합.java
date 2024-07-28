
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 부분 수열 : 연속되지 않아도 됨
 */
public class Main {

    static int N, target;
    static int count = 0;
    static int sum = 0;
    static int num[];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = input[0]; //숫자의 범위, 동시에 깊이가 된다. 모든 조합을 봐야하기 때문에.
        target = input[1]; //깊이가 된다.
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0, 0);
        System.out.println(count);

    }

    public static void dfs(int depth, int start) {

        if (depth == N) {
            return;
        }

        for (int i = start; i < N; i++) {

            sum += num[i];
            if (sum == target) {
                count++;
            }

            dfs(depth + 1, i + 1);
            sum -= num[i];
        }

    }
}

