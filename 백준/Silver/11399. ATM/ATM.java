

//아이디어
//오름차순 정렬한 뒤 자신이 걸리는 수와 대기 시간(앞 사람들의 처리시간)을 모두 더하기

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int[] waitingArr = new int[N];
        int processing = 0;
        int waiting = 0;

        // 0 1 3 6 9 -> 19 (누적대기시간)
        // 1 2 3 3 4 -> 13 (처리시간)

        for (int i = 0; i < N; i++) {

            if (i != 0) {

                waiting += arr[i - 1];
                waitingArr[i - 1] = waiting;
            }

            processing += arr[i];

        }
        int ans = 0;
        for (int i = 0; i < waitingArr.length; i++) {
            ans += waitingArr[i];
        }

        bw.write(ans + processing + "");
        bw.flush();
        bw.close();

    }
}
