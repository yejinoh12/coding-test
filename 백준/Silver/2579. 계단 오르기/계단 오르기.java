import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        int[] dp = new int[number + 1]; //dp 테이블
        int[] score = new int[number + 1]; //score 배열

        for (int i = 1; i <= number; i++) {
            score[i] = Integer.parseInt(br.readLine()); //score 입력
        }

        dp[1] = score[1]; //dp[1]의 최대값

        if (number >= 2) {

            dp[2] = score[1] + score[2]; //dp[2]의 최대값
        }

        for (int i = 3; i <= number; i++) {
            dp[i] = Math.max(dp[i-3] + score[i-1] + score[i], dp[i-2] + score[i]); //더 큰 값으로 갱신
        }

        System.out.println(dp[number]);
    }
}
