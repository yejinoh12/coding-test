
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 접근 방법 - dp
 * 1. 무조건 숫자 - 1 을 하기
 * 2. 만약 2로 나눠지면 나누기 (1의 결과와 비교 -> 값 갱신)
 * 3. 만약 3으로 나눠지만 마누기 (2의 결과와 비교 -> 값 갱신)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(makeOne(n)); //함수 호출
    }

    public static int makeOne(int n) {

        int[] dp = new int[n + 1]; //연산의 횟수가 저장되는 dp 배열

        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 1] + 1; //1. 일단 무조건 마이너스를 하고 연산 횟수를 더함

            //2. 2로 나눠떨어지면 나눈 다음, 연산 횟수를 더하고, 1의 값과 비교 -> 최소값으로 갱신
            if (i % 2 == 0) dp[i] = Math.min(dp[i / 2] + 1, dp[i]);

            //3. 3으로 나눠떨어지면 나눈 다음, 연산 횟수를 더하고, 1의 값과 비교 -> 최소값으로 갱신
            if (i % 3 == 0) dp[i] = Math.min(dp[i / 3] + 1, dp[i]);

        }

        return dp[n]; //결과값 반환
    }
}