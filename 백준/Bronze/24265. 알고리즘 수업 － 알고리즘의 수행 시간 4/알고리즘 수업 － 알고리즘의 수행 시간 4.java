/**
 * 이상하게 푼것 같아서 수정...
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(bf.readLine());

        System.out.println(n * (n-1) / 2);
        System.out.println("2");
    }
}
