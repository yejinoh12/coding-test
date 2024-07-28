
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
    static int count;
    static int num[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = input[0]; //숫자의 범위, 동시에 깊이가 된다. 모든 조합을 봐야하기 때문에
        target = input[1]; //깊이가 된다.
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(0, 0);
        
        /**
         * target이 0인경우, 공집합의 0도 count에 포함시키므로 
         * 0인 경우 1을 제거한다. 
         */
        if(target == 0) count--;
        System.out.println(count);

    }

    public static void dfs(int depth, int sum) {

        if (depth == N) {
            if (sum == target) {
                count++;
            }
            return;
        }

        //선택하는 경우
        dfs(depth + 1, sum + num[depth]);

        //선택하지 않는 경우
        dfs(depth + 1, sum);


    }


}

