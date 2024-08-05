
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[][] visited, graph;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[n][m];
        graph = new int[n][m];

        for (int i = 0; i < k; i++) {
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]) - 1;
            int y = Integer.parseInt(str[1]) - 1;
            graph[x][y] = 1;
            //graph[y][x] = 1;
        }

        //print();

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    max = Math.max(bfs(i, j), max);
                }
            }
        }

        System.out.println(max);

    }

    static int bfs(int x, int y) {

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = 1;
        int size = 1;

        while (!q.isEmpty()) {

            int[] node = q.poll();
            x = node[0];
            y = node[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (graph[nx][ny] == 1 && visited[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = 1;
                        size++;
                    }
                }
            }
        }
        return size;
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
