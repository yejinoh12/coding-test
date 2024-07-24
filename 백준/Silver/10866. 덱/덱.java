import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            String[] str = br.readLine().split(" ");

            String method = str[0];
            int param = 0;
            if (str.length == 2) param = Integer.parseInt(str[1]);

            switch (method) {

                case "push_front":
                    dq.addFirst(param);
                    break;

                case "push_back":
                    dq.addLast(param);
                    break;

                case "pop_front": {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.pollFirst());
                    }
                    break;
                }

                case "pop_back": {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.pollLast());
                    }
                    break;
                }

                case "size":
                    System.out.println(dq.size());
                    break;

                case "empty": {
                    if (dq.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                }

                case "front": {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.getFirst());
                    }
                    break;
                }

                case "back": {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.getLast());
                    }
                    break;

                }
            }
        }

    }
}
