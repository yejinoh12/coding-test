

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);

        Integer before = null;

        for (int i = 0; i < input.length; i++) {

            //처음
            if (before == null) {
                before = input[i];
                continue;
            }

            //중간
            if (input[i] != before) {
                map.put(before, map.get(before)+1);
                before = input[i];
            }

            //마지막
            if(i == input.length-1){
                map.put(before, map.get(before)+1);
            }
        }

        System.out.println(Math.min(map.get(0), map.get(1)));
    }
}
