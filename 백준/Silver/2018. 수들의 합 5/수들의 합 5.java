import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            array[i] = i + 1;
        }

        int count = 1; //자기 자신은 항상 포함

        for (int i = 0; i < n - 1; i++) {

            int sum = 0;

            for (int j = i; j < n - 1; j++) {
                sum += array[j];
                if(sum == n){
                    count++;
                    break;
                }
                if(sum > n){
                    break;
                }
            }
        }

        System.out.println(count);
    }
}