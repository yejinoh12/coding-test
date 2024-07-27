
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder()); //최대힙(내림차순)

        int[] input;
        for (int i = 0; i < n; i++) {

            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (input[0] == 0) { //입력이 0이라면 아이들에게 최대값 선물을 나눠줌
                System.out.println(q.isEmpty() ? -1 : q.poll());
                continue;
            }

            for (int j = 1; j <= input[0]; j++) { //아니라면 선물 충전
                q.offer(input[j]);
            }

        }


    }
}
