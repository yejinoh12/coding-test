
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            int m = Integer.parseInt(br.readLine());

            for (int j = 0; j < m; j++) {
                String[] input = br.readLine().split(" ");
                map.put(input[1], map.getOrDefault(input[1], 0) + 1);
            }
            
            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1);
            map.clear();
        }


    }
}
