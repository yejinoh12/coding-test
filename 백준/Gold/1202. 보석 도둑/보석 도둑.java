
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 그리디
 *  [보석 1] 무게 30, 가치 100
 *  [보석 2] 무게 100, 가치 150
 *  가방 무게 100, 40 인 경우 가방 100에 무게 30인 보석을 넣으면 가방 40에 보석을 넣을 수 없게됨
 *
 *  1) 먼저 우선적으로 가방 40이 넣을 수 있는 최대 가치를 넣어줘야함 (가방 오름차순 정렬 필요)
 *  2.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // (1 ≤ N, K ≤ 300,000) O(n * k) 불가
        int N = Integer.parseInt(st.nextToken()); //보석점에 있는 보석의 개수
        int K = Integer.parseInt(st.nextToken()); //상근이의 가방 개수

        int[][] arr = new int[N][2]; //보석의 무게와 가치가 들어감
        int[] myBag = new int[K]; //가방이 담을 수 있는 무게

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //무게
            arr[i][1] = Integer.parseInt(st.nextToken()); //가치
        }

        for (int i = 0; i < K; i++) { //상근이 가방이 담을 수 있는 최대 무게
            myBag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        Arrays.sort(myBag);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        long value = 0;
        int index = 0;

        for (int bag : myBag) { //내가 가진 가방을 반복문에 넣고,

            while (index < N && arr[index][0] <= bag) { // 가방에 넣을 수 있다면
                maxHeap.add(arr[index][1]); //힙에 가치를 넣고
                index++;
            }
            // 최대 가치를 가진 보석을 꺼내어 가방에 추가
            if (!maxHeap.isEmpty()) {
                value += maxHeap.poll();
            }
        }

        System.out.println(value);

        bw.flush();
        bw.close();
    }

}
