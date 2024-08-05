
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 검정(1) : 전류 차단 물질, 흰색(0) : 전류가 통하는 물질
 * <p>
 * 접근 방법 bfs
 * 1. 1일 경우만 큐에 넣기
 * 2. 4방향탐색
 */
public class Main {

    static int n, m;
    static int[][] v, graph;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = new int[n][m];
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            if (graph[0][i] == 0 && v[0][i] == 0) {
                if(bfs(0, i)){
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }

    static boolean bfs(int x, int y) {

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        v[x][y] = 1;

        while (!q.isEmpty()) {

            int[] node = q.poll();
            x = node[0];
            y = node[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (graph[nx][ny] == 0 && v[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                        v[nx][ny] = 1;
                        if(nx == n - 1) return true;
                    }
                }
            }
        }
        return false;
    }
}
