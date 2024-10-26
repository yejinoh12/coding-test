import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0]; //동전의 종류
        int K = input[1]; //동전으로 만들어야 한는 값

        //동전 입력
        ArrayList<Integer> coins = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        //오름차순 정렬되어 있는 동전을 내림차순으로 변경
        Collections.reverse(coins);

        int ans = 0;

       for(int coin : coins){
           ans += K / coin;
           K = K % coin;
           if(K == 0) break;
       }

        System.out.println(ans);
    }
}