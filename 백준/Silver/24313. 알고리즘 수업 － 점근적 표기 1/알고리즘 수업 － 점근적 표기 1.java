import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//f(n) ≤ c × g(n)

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a1 = input[0];
        int a0 = input[1];
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        
        if (a1 * n0 + a0 <= c * n0 && a1 <= c) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
