
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int shoppingTime = Integer.parseInt(br.readLine());

        double[] ans = new double[4]; // ans
        Arrays.fill(ans, 25);

        double[] sub = new double[4]; //store
        double[][] graph = new double[4][4];

        int move = Integer.parseInt(br.readLine());

        for (int i = 0; i < move; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char x = st.nextToken().charAt(0);
            char y = st.nextToken().charAt(0);
            double rate = Double.parseDouble(st.nextToken());
            graph[x - 65][y - 65] = rate;
        }

        //print(graph);

        for (int i = 0; i < shoppingTime; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (graph[j][k] != 0.0) {
                        sub[k] += ans[j] * graph[j][k];
                    }
                }
            }

            ans = sub.clone();
            Arrays.fill(sub, 0);
        }

        for (int i = 0; i < 4; i++) {
            System.out.printf("%.2f\n", ans[i]);
        }
    }

    static void print(double[][] graph) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

