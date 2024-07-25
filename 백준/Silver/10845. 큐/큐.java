
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> queue = new ArrayDeque<>();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            String[] str = br.readLine().split(" ");

            String method = str[0]; //함수 이름
            int param = 0;

            if (str.length == 2) param = Integer.parseInt(str[1]); //스트링이 2개이면 들어오면 매개변수 추가

            switch (method) {

                case "push":
                    queue.offer(param);
                    break;

                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.pop());
                    break;
                    
                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;

                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.peekFirst());
                    break;

                case "back":
                    System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
                    break;
            }
        }
    }

}
