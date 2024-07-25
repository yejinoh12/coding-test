
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stack.addFirst(Integer.parseInt(br.readLine())); //맨 앞 부터 검사하기 위해 addFirst
        }

        int max = 0;
        int result = 0;

        /**
         * 1. 보이는 방향에서 가장 가까운 막대기 부터 검사
         * 2. 막대기가 max 값보다 낮다면 보이지 않음 , max 값을 갱신함
         */

        while (!stack.isEmpty()) {

            int top = stack.pop(); //빼낸 숫자
            //System.out.println("max = " + max);
            //System.out.println("top = " + top);

            if (max < top) { //빼낸 숫자가 max 보다 큰 경우
                result++;
                max = top;
            }
        }

        System.out.println(result);

    }
}
