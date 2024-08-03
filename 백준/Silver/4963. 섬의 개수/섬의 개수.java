
import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 접근방법 bfs 8방향 탐색 
 */
public class Main {

    static int graph[][];
    static int v[][];
    static int n, m;
    static int[] dx = new int[]{0, 0, -1, 1, -1, 1, 1, -1};
    static int[] dy = new int[]{-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0) break;

            graph = new int[m][n];
            v = new int[m][n];

            for (int i = 0; i < m; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(str[j]);
                }
            }

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(v[i][j] == 0 && graph[i][j] == 1){
                        cnt++;
                        bfs(i, j);
                    }
                }

            }

            bw.write(cnt + "\n");
        }

        bw.close();
    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        v[x][y] = 1;

        while (!q.isEmpty()) {

            int[] node = q.poll();
            x = node[0];
            y = node[1];

            for (int i = 0; i < 8; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (v[nx][ny] == 1 || graph[nx][ny] == 0) continue;

                q.offer(new int[]{nx, ny});
                v[nx][ny] = 1;

            }
        }
    }
}


