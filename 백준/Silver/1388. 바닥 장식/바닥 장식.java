
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 탐색 시 조건이 두개
 */
public class Main {

    static int n, m;
    static char[][] graph;
    static int[][] vNext;
    static int[][] vDown;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        vNext = new int[n][m];
        vDown = new int[n][m];

        for(int i = 0; i < n; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                graph[i][j] = ch[j];
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(graph[i][j] == '-' && vNext[i][j] == 0) {
                    //System.out.println("next: " + i + "," + j);
                    //System.out.println("---------------------");
                    next(i,j);
                    count ++;

                }if(graph[i][j] == '|' && vDown[i][j] == 0){
                    //System.out.println("down: " + i + "," + j);
                    //System.out.println("---------------------");
                    down(i,j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void next(int x, int y){

        vNext[x][y] = 1;
        int nextY = y + 1;
        if(nextY >= m || vNext[x][nextY] == 1 || graph[x][nextY] != '-') return;
        next(x, nextY);

    }

    static void down(int x, int y){

        vDown[x][y] = 1;
        int downX = x + 1;
        if(downX >= n || vDown[downX][y] == 1 || graph[downX][y] != '|') return;
        down(downX, y);

    }
}
