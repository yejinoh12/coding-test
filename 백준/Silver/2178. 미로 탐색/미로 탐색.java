
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] graph;
    static int[][] v; //방문 여부 체크
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        v = new int[N][M];

        for (int i = 0; i < N; i++) {
            int[] s = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s[j];
            }
        }

        System.out.println(bfs(0, 0));

    }

    public static int bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});         //큐에 호출된 좌표를 넣어주고
        v[x][y] = 1;                    //방문 처리

        while (!q.isEmpty()) {          //큐가 빌 때까지 반복

            int[] now = q.poll();       //큐에서 하나를 꺼내고
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++){
                int nextX = nowX + dx[i]; //row
                int nextY = nowY + dy[i]; //column

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue; //범위를 벗어나는 경우
                if(v[nextX][nextY] == 1 || graph[nextX][nextY] == 0) continue; //방문했거나, 0인 경우 경우

                q.offer(new int[]{nextX, nextY}); //큐에 좌표를 넣고
                graph[nextX][nextY] = graph[nowX][nowY] + 1;         //방문횟수를 누적해 간다.
                v[nextX][nextY] = 1;              //방문했음을 체크한다.
            }
        }

        return graph[N-1][M-1];
    }
}
