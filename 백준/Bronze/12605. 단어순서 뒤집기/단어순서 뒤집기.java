import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= num; i++) {

            String[] strings = br.readLine().split(" ");
            System.out.printf("Case #%d: ", i);

            for(int j = strings.length- 1; j >= 0; j--){
                System.out.print(strings[j] + " ");
            }

            System.out.println();
        }
    }
}
