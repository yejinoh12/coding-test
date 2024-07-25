
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int n, m;
    public static int[] number;
    public static List<Integer> list = new ArrayList<>();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = arr[0];
        m = arr[1];

        number = new int[n];

        int[] inputNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(inputNum);

        for (int i = 0; i < n; i++) {
            number[i] = inputNum[i];
        }

        dfs(0);
        bw.close();

    }

    public static void dfs(int depth) throws IOException{

        if (depth == m) {
            for(int i : list){
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {

            list.add(number[i]);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }
    }

}
