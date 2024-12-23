
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int n;
    public static int m;
    public static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        dfs(0, 1);

        for (List<Integer> i : ans) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int depth, int start) {

        if (depth == m) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {

            list.add(i);
            dfs(depth + 1, i);
            list.remove(list.size() - 1);

        }
    }
}
