
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N = 6;
    static int[] ans = new int[N];

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[0] == 0) break;
            dfs(0, input[0], input,0);
            System.out.println();
        }

        //int[] a = new int[]{7,1,2,3,4,5,6,7};
        //dfs(0, 7, a, 0);
    }

    public static void dfs(int depth, int num, int arr[], int start){

        if(depth == N){
            for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for( int i = start; i < num; i++ ){

            ans[depth] = arr[i + 1];
            dfs(depth + 1, num, arr, i +  1);
        }
    }
}
