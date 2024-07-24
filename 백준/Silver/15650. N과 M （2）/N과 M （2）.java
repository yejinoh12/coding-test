import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int n, m;
    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        m = input[1];

        dfs(0);

        for (List<Integer> i : answer) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int k) {

        if (k == m) {

            int matchCount = 0;
            boolean findSame = false;
            for (int i = 0; i < answer.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    matchCount = 0;
                    for (int z = 0; z < list.size(); z++) {
                        if (answer.get(i).contains(list.get(z))){
                            if (++matchCount == m) {
                                findSame = true;
                                break;
                            }
                        }
                    }
                }
            }

            if (!findSame) answer.add(new ArrayList<>(list));

            return;
        }

        for (int i = 1; i <= n; i++) {

            if (list.contains(i)) continue;

            list.add(i);
            dfs(k + 1);
            list.remove(list.size() - 1);

        }

    }

}