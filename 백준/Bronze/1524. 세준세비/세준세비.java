
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 접근 방법 : 최소힙, peek() 해서 더 착은 쪽을 제거, 한쪽이 비었다면 패배
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){

            Queue<Integer> S = new PriorityQueue<>(); //세준이
            Queue<Integer> B = new PriorityQueue<>(); //세비

            br.readLine();
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] M = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j : N){
                S.add(j);
            }

            for(int k : M){
                B.add(k);
            }

            while (true){ //둘 중 하나가 빌 때까지.

                if(S.peek() >= B.peek()){ //세비의 병사가 더 약하면
                    B.poll();
                    if(B.isEmpty()) {
                        System.out.println("S");
                        break;
                    }
                }else if(S.peek() < B.peek()){ //세준이의 병사가 더 약하면
                    S.poll();
                    if(S.isEmpty()) {
                        System.out.println("B");
                        break;
                    }
                }
            }
        }
    }
}
