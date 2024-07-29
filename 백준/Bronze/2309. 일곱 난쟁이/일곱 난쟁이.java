
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int[] ans = new int[7];
    static int[] arr = new int[9];
    static int sum;
    static int count;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        dfs(0, 0);
    }

    public static void dfs(int depth, int start) {

        if (depth == 7) {
            if (sum == 100 && count == 0) {
                count++;
                for(int i : ans){
                    System.out.println(i);
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {

            ans[depth] = arr[i];

            sum += arr[i];
            dfs(depth + 1, i + 1);
            sum -= arr[i];

        }
    }
}
