
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 접근 방법 - bfs
 * 1. 4방향 탐색
 * 2. X가 아닌 경우에만 큐에 넣고
 * 3. P가 나왔다면 count++
 */
public class Main {

    static char[][] graph;
    static int[][] v;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int n, m, count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        v = new int[n + 1][m + 1];

        int nowX = 0;
        int nowY = 0;

        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (ch[j] == 'I') {
                    nowX = i;
                    nowY = j;
                }
                graph[i][j] = ch[j];
            }
        }

        //System.out.println(nowX + "," + nowY);
        bfs(nowX, nowY);
        System.out.println(count == 0 ? "TT" : count);

    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        v[x][y] = 1;

        while (!q.isEmpty()) {

            int[] node = q.poll();
            x = node[0];
            y = node[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny] == 1) continue;

                if (graph[nx][ny] != 'X') {
                    q.offer(new int[]{nx, ny});
                    v[nx][ny] = 1;
                }

                if (graph[nx][ny] == 'P') {
                    count++;
                }

            }
        }
    }
}
