
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

        if (arr[0] == 1) { //앞자리가 1인 경우

            int[] ticket = new int[(int) arr[N - 1] + 1]; //최대값 + 1 크기의 배열을 만들기

            for (int i = 0; i < arr.length; i++){
                ticket[(int) arr[i]] = 1; //arr의 값에 해당하는 티켓 인덱스에 1을 넣어주기
            }

            int k = 0;
            int count = 0;
            while (k < ticket.length - 1) {
                if (ticket[++k] == 0) { //0이 나오면 출력하고
                    count++;
                    System.out.println(k);
                    break;
                }
            }

            if (count == 0) System.out.println(arr[N-1] + 1);

        } else {
            System.out.println(1);
        }
    }
}
