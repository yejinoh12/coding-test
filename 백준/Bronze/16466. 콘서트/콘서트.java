
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 접근 방법
 * 1이 있는 경우와 없는 경우를 나눠서 생각
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //(1 ≤ N ≤ 1,000,000)
        long[] arr = new long[N]; //최대값 : 2^31 - 1
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); //정렬

        if (arr[0] == 1) {

            int cnt = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] > 1) {
                    cnt++;
                    System.out.println(arr[i - 1] + 1);
                    break;
                }
            }

            if(cnt == 0) System.out.println(arr[N - 1] + 1);

        } else {
            System.out.println(1);
        }
    }
}
