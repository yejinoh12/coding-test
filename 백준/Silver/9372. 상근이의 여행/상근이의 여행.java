
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 주어지는 비행 스케줄은 연결 그래프 --> 모든 정점에 대해 항상 경로를 가짐
 * <p>
 * MST : 그래프의 모든 노드를 연결하면서 간선의 총 가중치의 합이 최소인 트리
 * - 노드 수가 V 일 때, 간선의 개수는 V - 1
 * <p>
 * BFS : 모든 가중치가 동일한 그래프에서 최단 경로를 탐색하는 알고리즘
 * <p>
 * 결론 : 나라(정점)에 대한 최소 비행스케줄(간선)은 항상 정점-1
 */

public class Main {

    static int n, m;
    static int[][] graph;       //인접행렬
    static int[] v;             //방문한 나라라면 방문하지 않도록

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new int[n][n];
            v = new int[n];

            for (int j = 0; j < m; j++) {

                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x - 1][y - 1] = 1;
                graph[y - 1][x - 1] = 1; //인접 행렬 표현

            }

            /*for(int k[] : graph){
                for(int h : k){
                    System.out.print(h + " ");
                }
                System.out.println();
            }*/

            System.out.println(bfs(0));


        }
    }

    static int bfs(int node) {

        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;
        q.offer(node);
        v[node] = 1;

        while (!q.isEmpty()) {

            node = q.poll();

            for (int i = 0; i < n; i++) {
                if (v[i] == 0 && graph[node][i] == 1) {
                    q.offer(i);
                    v[i] = 1;
                    count++;
                }
            }
        }

        return count;

    }
}
