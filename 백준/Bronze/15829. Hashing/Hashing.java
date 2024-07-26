
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] input = br.readLine().toCharArray();

        // 'a' = 97
        long tmp = 0;
        for (int i = 0; i < input.length; i++) {
            tmp += (input[i] - 96) * (int) Math.pow(31, i);
        }
        System.out.print(tmp);
    }
}