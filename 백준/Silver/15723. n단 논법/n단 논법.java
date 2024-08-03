
import java.io.*;
import java.util.HashSet;
import java.util.Set;

//0100
//0010
//0001
// TestEx 1) a->d  //a=0,b=1 ...
// 1. graph[0]에서 1인 곳을 찾음 -> a->b true -> graph[1]로 이동
// 2. graph[1]에서 1인 곳을 찾음 -> b->c true -> graph[2]로 이동
// 3. graph[2]에서 1인 곳을 찾음 -> c->d true -> d를 찾았으므로 a->d는 true

//a는 b이면서 c 일 수 없으나
//a와 b가 동시에 c 일 수 있다??

//a->b , a->c (X)
//a->b , b->c (O)
public class Main {

    static int[][] graph = new int[30][30];
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int x = str[0].charAt(0);
            int y = str[2].charAt(0);

            if(max < x) max = x;
            if(max < y) max = y;

            graph[x - 97][y - 97] = 1;
        }

        max -= 96;
        //System.out.println(max);
        //print();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            int x = str[0].charAt(0);
            int y = str[2].charAt(0);

            bw.write(test(x - 97, y - 97) + "\n");

        }

        bw.flush();
        bw.close();
    }

    public static char test(int start, int find) {

        //System.out.println(start);
        if (start == find) {
            return 'T';
        }

        for (int i = 0; i < max; i++) {
            if (graph[start][i] == 1) {
                if(test(i, find) == 'T') return 'T';
            }
        }
        return 'F';
    }

    static void print() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
