
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static int n, m;
    static int[][] graph, visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        graph = new int[n][m];
        visited = new int[n][m];

        //입력
        for (int i = 0; i < n; i++) {
            input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                graph[i][j] = input[j];
            }
        }

        bfs(0, 0);

        bw.write(graph[n - 1][m - 1] + "");
        bw.flush();
        bw.close();

    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = 1;

        while (!q.isEmpty()) {

            int[] node = q.poll();
            x = node[0];
            y = node[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (visited[nx][ny] == 1 || graph[nx][ny] == 0) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = 1;

                //해당 좌표에 도달하기 위해 필요한 최소 이동 횟수
                graph[nx][ny] = graph[x][y] + 1;
            }
        }
    }

    //출력 테스트
    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
