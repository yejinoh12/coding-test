
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 접근 방법 : bfs - 배열 크기 설정이 애매해서 리스트로 구현
 * 1. 먼저 m개의 픽셀씩 더한다.
 * 2. 픽셀을 3으로 나눈다.
 * 3. 픽셀이 t보다 낮으면 0, 크면 255
 * 4. 이어진 부분을 구한다. = dfs 호출 횟수
 * <p>
 * 런타임 에러 (IndexOutOfBounds)
 */

public class Main {

    static int n, m;
    static int[][] visited, graph;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new int[n][m];
        graph = new int[n][m];

        //입력
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");

            int k = 0;
            int z = 0;
            int value = 0;
            while (k < str.length) {
                value += Integer.parseInt(str[k]);
                if ((k + 1) % 3 == 0) {
                    graph[i][z++] = value;
                    value = 0;
                }
                k++;
            }
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] / 3 >= t) {
                    graph[i][j] = 255;
                } else {
                    graph[i][j] = 0;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 255 && visited[i][j] == 0) {
                    //System.out.println(i + " ," + j);
                    bfs(i, j);
                    result++;
                }
            }
        }

        //print();

        System.out.println(result);

    }

    static void bfs(int x, int y) {

        Deque<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{x, y});
        visited[x][y] = 1;

        while (!q.isEmpty()) {

            int[] node = q.poll();
            x = node[0];
            y = node[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (graph[nx][ny] == graph[x][y] && visited[nx][ny] == 0) {

                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
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
