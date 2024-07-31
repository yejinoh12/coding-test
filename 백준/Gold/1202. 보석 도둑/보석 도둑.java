import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 상덕이가 가지고 있는 가방 k 개, c 무게 까지 담을 수 있음
 * 보석점에 있는 보석 개수 n 개, 무게 m, 가격 v
 * ** 가방에는 한개의 보석만 넣을 수 있음
 *
 * 보석의 가치를 기준으로 내름차순 정렬하고, 가치가 같다면 무게도 오름 차순 정렬 해야함
 * 무거운 가방부터 검사
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
        Integer[] myBag = new Integer[K]; //가방이 담을 수 있는 무게

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //무게
            arr[i][1] = Integer.parseInt(st.nextToken()); //가치
        }

        for (int i = 0; i < K; i++) { //상근이 가방이 담을 수 있는 최대 무게
            myBag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, new Compare());  //O(nlogn)
        Arrays.sort(myBag); //O(longk)

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        long value = 0;
        int index = 0;

        for (int bag : myBag) { //내가 가진 가방을 반복문에 넣고,

            while (index < N && arr[index][0] <= bag) { //만약 가방이 가게에 있는 보석의 무게랑 같거나 작다면 (가방에 넣을 수 있다면)
                maxHeap.add(arr[index][1]); //힙에 가치를 넣고
                //System.out.println(arr[index][1]);
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

    static class Compare implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[1] == a[1]) {
                return Integer.compare(a[0], b[0]); //오름차순
            }
            return Integer.compare(a[1], b[1]); //오름차순
        }
    }
}
