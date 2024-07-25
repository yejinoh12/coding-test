
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static int n, m;

    public static boolean[] visited;
    public static int[] number;
    public static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = arr[0];
        m = arr[1];
        visited = new boolean[n];
        number = new int[n];

        int[] inputNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(inputNum);

        for (int i = 0; i < n; i++) {
            number[i] = inputNum[i];
        }

        dfs(0);

        for (List<Integer> i : ans) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    public static void dfs(int depth) {

        if (depth == m) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                visited[i] = true;
                list.add(number[i]);
                dfs(depth + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
