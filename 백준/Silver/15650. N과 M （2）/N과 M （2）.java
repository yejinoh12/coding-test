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

        dfs(1, 0 );

        for (List<Integer> i : answer) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int depth, int selectedCount) {

        if(depth > n){
            if (selectedCount == m) {
                answer.add(new ArrayList<>(list));
            }
            return;
        }

        // 현재 숫자를 선택하는 경우
        list.add(depth);
        dfs(depth + 1, selectedCount + 1);
        list.remove(list.size() - 1);

        // 현재 숫자를 선택하지 않는 경우
        dfs(depth + 1, selectedCount);
    }
}