
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            String[] words = br.readLine().split(" ");
            Map<String, Integer> map = new HashMap<>();

            int n = input[0];
            int l = input[1];
            int f = input[2];

            for (int j = 0; j < n; j++) {
                String str = words[j].substring(l - f, l);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }

            int result = 0;
            for (int a : map.values()) {
                if(a > 1){
                    result += a / 2;
                }
            }

            bw.write(result + "\n");
        }

        bw.close();
    }
}