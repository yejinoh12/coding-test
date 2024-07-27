
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>(); //최소힙

        int input;
        for (int i = 0; i < n; i++) {

            input = Integer.parseInt(br.readLine());

            if (input == 0) {
                System.out.println(q.isEmpty() ? 0 : q.poll());
                continue;
            }

            q.offer(input);

        }

    }
}
