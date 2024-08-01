
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int[][] v;
    static int[][] graph;
    static int row, col;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new int[row][col];
        v = new int[row][col];

        for (int i = 0; i < row; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (str[j] == '.') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(graph[i][j] == 1 && v[i][j] == 0){
                    bfs(i,j);
                }
            }
        }

        System.out.println(count);

    }

    public static void bfs(int x, int y){

        count ++;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        v[x][y] = 1;

        while(!q.isEmpty()){

            int[] xy = q.poll();
            int nowX = xy[0];
            int nowY = xy[1];

            for(int i = 0; i < 4; i++){

                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
                if(v[nextX][nextY] == 1 || graph[nextX][nextY] == 0) continue;

                q.offer(new int[]{nextX, nextY});
                v[nextX][nextY] = 1;
                //System.out.println(nextX + " " +  nextY);

            }
        }
    }
}
