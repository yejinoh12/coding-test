import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] time = new int[number]; 
        int[] pay = new int[number];

        //입력받기
        for (int i = 0; i < number; i++) {
            String[] str = br.readLine().split(" ");
            time[i] = Integer.parseInt(str[0]);
            pay[i] = Integer.parseInt(str[1]);
        }

        int[] dp = new int[number + 1];

        for (int i = number - 1; i >= 0; i--) { //뒤에서부터 비교

            if (i + time[i] <= number) { //퇴사일을 넘지 않는다면
                //상담을 할 경우와 하지 않을 경우 비교
                dp[i] = Math.max(dp[i + time[i]] + pay[i], dp[i + 1]);
            } else { //퇴사일을 넘는 경우
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);
    }
}
