
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            String[] str = br.readLine().split(" ");

            String method = str[0]; //함수 이름
            int param = 0;

            if (str.length == 2) param = Integer.parseInt(str[1]); //스트링이 2개이면 들어오면 매개변수 추가

            switch (method) {

                case "push":
                    stack.push(param);
                    break;

                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;

                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }
        }
    }

}


