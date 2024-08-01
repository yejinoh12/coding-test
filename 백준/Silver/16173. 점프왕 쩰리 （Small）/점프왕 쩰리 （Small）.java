
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 조건
 * 1. 내부에서만 움직일 수 있음
 * 2. 출발점 (0,0)
 * 3. 이동 가능 방향 : 오른쪽, 아래
 * 4. 승리 조건 : (n,m) 에 도달
 * 5. 칸에 적힌 숫자만큼 움직 일 수 있음
 *
 * 접근 방법
 * 방향은 오른쪽이란 아래 2군데만 갈 수 있고, 점프 가능한 만큼만 이동 가능
 *
 */
public class Main {

    static int n, win;
    static int[][] graph;
    static int[][] v;
    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        v = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" "); //N (2 ≤ N ≤ 3)
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        //bfs(0, 0);
        dfs(0,0);
        System.out.println(win == 1 ? "HaruHaru" : "Hing");
    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        v[x][y] = 1;

        while (!q.isEmpty()) {

            int[] node = q.poll();

            x = node[0];
            y = node[1];

            if (x == n - 1 && y == n - 1) win = 1;

            for (int i = 0; i < 2; i++) {

                /**
                 * 방향은 두 방향이고, 현재 발판의 수만큼 이동해야함
                 */

                int[] dx = {0, graph[x][y]};
                int[] dy = {graph[x][y], 0};

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= n || ny >= n || v[nx][ny] == 1) continue;

                q.offer(new int[]{nx, ny});
                v[nx][ny] = 1;
            }
        }
    }

    static void dfs(int x, int y){

        if (x >= n || y >= n || v[x][y] == 1) return;   //종료 조건

        if (x == n - 1 && y == n - 1) {                 //승리 조건
            win = 1;
            return;
        }

        v[x][y] = 1;    //방문 처리

        int[] dx = {0, graph[x][y]};
        int[] dy = {graph[x][y], 0};

        for(int i = 0; i < 2; i ++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny);
        }
    }
}
