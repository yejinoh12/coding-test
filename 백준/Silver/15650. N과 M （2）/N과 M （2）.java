

//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//고른 수열은 오름차순이어야 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr;
    static ArrayList<Integer> ans = new ArrayList<>();
    static boolean[] v; //방문여부

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        arr = new int[N];
        v = new boolean[N];

        backTracking(0,0);

    }

    public static void backTracking(int idx, int depth){

        //종료 조건
        if(depth == M){
            for(int i = 0; i < M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;

        }

        for (int i = idx; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                arr[depth] = i + 1;
                backTracking(i + 1, depth + 1);
                v[i] = false;
            }
        }
    }
}
