import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int count = 0;
            double sum = 0.0;

            for (int k = 1; k <= input[0]; k++) {
                sum += input[k];
            }

            double average = sum / input[0];

            for (int k = 1; k < input[0] + 1; k++) {
                if (input[k] > average) {
                    count++;
                }
            }
            
            System.out.printf("%.3f%%", (double) count / input[0] * 100);
            System.out.println();

        }
        br.close();
    }

}
