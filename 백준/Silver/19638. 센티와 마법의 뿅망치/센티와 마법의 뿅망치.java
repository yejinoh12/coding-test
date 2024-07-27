import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 접근방법
 * 최대힙에 두명 거인을 저장하고/뿅만치 수만큼 반복문 돌면서/최대힙에서 꺼낸뒤 2로 나누고 다시 넣어주기
 * [10] [32, 16] -> [10] [16,16] -> [10][16,8] -> [10][8,8] (3번)
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        int myHeight = input[1]; //샌디의 키

        for (int i = 0; i < input[0]; i++) {
            q.offer(Integer.parseInt(br.readLine())); // 1이 아닌 경우 거인키 입력
        }

        if (myHeight > q.peek()) { //샌디의 키가 거인의 최대 키보다 큰경우
            print("YES", 0);
            return;
        }

        for (int i = 0; i < input[2]; i++) { //뿅만치 수만큼 거인키를 줄여주기

            int giantHeight = q.poll(); //가장 큰 거인키
            q.offer(giantHeight/ 2); //2로 나눠서 다시 넣어주기

            if(giantHeight == 1){ //가장 큰 거인키가 1이면 더이상 줄어들 수 없음
                print("NO", i + 1);
                break;
            }

            if (myHeight > q.peek()) { //샌디의 키가 더 커진 경우
                print("YES", i + 1);
                break;
            }

            if (i == input[2] - 1 && myHeight <= q.peek()) { //마지막 까지 샌디가 작거나 거인과 같은 경우
                print("NO", q.peek());

            }
        }
    }

    static void print(String str, int n) {
        System.out.println(str);
        System.out.println(n);
    }
}
