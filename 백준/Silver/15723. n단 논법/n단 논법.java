
import java.io.*;

/** 
 * 접근 방법 - 인접행렬
 * TestEx 1) a->d (0,3)
 1. graph[0] 검사 0->1(a->b)
 2. graph[1] 검사 1->2(b->c)
 3. graph[2] 검사 2->3(c->d)
 4  d를 찾았으므로 a->d true */

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

            graph[x - 97][y - 97] = 1; // 양방향아님 
        }

        /**
         * 변수 max 역할 : 숫자중에서 가장 큰 숫자의 인덱스(아스키코드 - 97) 까지 확인하기 위해서 사용 
         * 가장 큰 숫자가 'z' = 25 라면 --> for(int i = 0; i < 26; i++)
         */

        max -= 97;
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

        if (start == find) {
            return 'T';
        }

        for (int i = 0; i <= max; i++) {
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
