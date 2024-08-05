
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * v 늑대 # 울타리 o 양
 * 접근 방법 bfs
 * 1. 울타리가 아니면 반복문 실행
 * 2. dfs 함수에서 #인경우는 큐에 넣지 않음 .vo인 경우만 넣고 v와o의 개수 리턴
 */
public class Main {

    static int n, m;
    static int[][] visited;
    static char[][] graph;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new int[n][m];
        graph = new char[n][m];

        //입력
        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                graph[i][j] = c[j];
            }
        }

        /**
         * bfs는 int[] 를 리턴
         *
         * result[0] --> 양의 수
         * result[1] --> 늑대 수
         *
         * case 1 ) 양의 수가 많으면 변수 o 만 카운트
         * case 2) 늑대 수가 양보다 많거나 같으면 v 만 카운트
         */

        int[] result = new int[2];
        int o = 0;
        int v = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if (graph[i][j] != '#' && visited[i][j] == 0) {
                    result = bfs(i,j);
                    if(result[0] > result[1]){
                        o+=result[0];
                    }else{
                        v+=result[1];
                    }
                }
            }

        }

        System.out.println(o + " " + v);
    }

    static int[] bfs(int x, int y) {

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = 1;

        int[] result = new int[2];

        if(graph[x][y] == 'o'){
            result[0]++;
        }else if(graph[x][y] == 'v'){
            result[1]++;
        }

        while (!q.isEmpty()) {

            int[] node = q.poll();
            x = node[0];
            y = node[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (graph[nx][ny] != '#' && visited[nx][ny] == 0) {

                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = 1;

                        if(graph[nx][ny] == 'o') {
                            result[0]+= 1;
                            //System.out.println("양");

                        }else if(graph[nx][ny] == 'v'){
                            result[1] += 1;
                            //System.out.println("늑대");
                        }
                    }
                }
            }
        }

        return result;
    }
}
