
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] input = br.readLine().toCharArray();

        // 'a' = 97
        long result = 0;
        long pow = 1;
        for (int i = 0; i < input.length; i++) {
            result += (input[i] - 96) * pow;
            pow = (pow % 1234567891) * 31;
        }
        
        System.out.print(result % 1234567891);
    }
}