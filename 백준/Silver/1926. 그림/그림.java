
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 접근방법 - bfs
 * 1. 2차원 배열 반복문 돌리고, 1이 나오면 bfs 함수 호출
 * 2. bfs 함수
 * 2-1 범위에서 벗어나지 않고 인접 노드가 1이면 큐에 넣고 width++
 * 2-2 width return
 * 3. return된 넓이를 비교해서 max 갱신
 */
public class Main {

    static int graph[][];
    static int v[][];
    static int n, m;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        v = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        int maxWidth = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 1 && v[i][j] == 0){
                    cnt++;
                    maxWidth = Math.max(maxWidth, bfs(i,j));
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxWidth);
        //print();
    }

    static int bfs(int x, int y) {

        int width = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        v[x][y] = 1;

        while(!q.isEmpty()){

            int[] node = q.poll();
            x = node[0];
            y = node[1];

            for(int i = 0; i < 4; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(v[nx][ny] == 1 || graph[nx][ny] == 0) continue;

                q.offer(new int[]{nx, ny});
                v[nx][ny] = 1;
                width++;

            }

        }

        return width;
    }


    static void dfs(int x, int y) {


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
