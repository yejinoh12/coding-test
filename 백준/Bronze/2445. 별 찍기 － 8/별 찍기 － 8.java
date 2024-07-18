import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] star = new char[n * 2];

        for (int i = 0; i < n * 2; i++) {
            star[i] = ' ';
        }

        int low = 0;
        int high = 2 * n - 1;

        for (int i = 0; i < n; i++) {
            star[low++] = '*';
            star[high--] = '*';
            System.out.println(star);
        }

        int midToLow = (low + high) / 2;
        int midToHigh = (low + high) / 2 + 1;

        for (int i = 0; i < n - 1; i++) {
            star[midToLow--] = ' ';
            star[midToHigh++] = ' ';
            System.out.println(star);
        }

        System.out.println();
    }


}