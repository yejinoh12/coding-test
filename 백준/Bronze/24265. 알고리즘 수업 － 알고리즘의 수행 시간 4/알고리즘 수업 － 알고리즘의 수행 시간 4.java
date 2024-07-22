import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 최고차항의 차수 출력
 */
public class Main {

    public static long count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        long result = MenOfPassion(n);
        System.out.println(result);
        System.out.println("2");

    }

    public static long MenOfPassion(int n) {

        long[] dp = new long[n];

        if (n == 0) return 0; //0이면 0 리턴

        dp[0] = n - 1; //0번째 인덱스에는 n-1이 들어감
        int k = n - 1; //1씩 줄여나갈 변수

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + --k; //이전 원소 값과 --k를 더함 
        }

        return dp[n - 1];
    }
}
