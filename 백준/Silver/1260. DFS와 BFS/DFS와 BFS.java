
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] graph;
    static int[] v;

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = input[0];
        M = input[1];
        graph = new int[N][N];
        v = new int[N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x - 1][y - 1] = 1;
            graph[y - 1][x - 1] = 1;
        }

        //dfs(0);
        stackDfs(input[2] - 1);
        System.out.println();

        //방문여부 초기화
        v = new int[N];
        bfs(input[2] - 1);

        /*System.out.println("----인접행렬-----");
        for (int i[] : graph) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }*/
    }

    /**
     * 재귀를 사용한 dfs
     * 1. 노드를 방문 처리한다.
     * 2. 반복문으로 정점을 방문한다.
     * 3. 노드들을 방문하다 노드들이 정점을 가지고 있다면 정점을 먼저 탐색한다.
     * 3-1. graph[node][i] == true 일 경우, graph[i]를 먼저 탐색한다.
     */

    static void dfs(int node) {

        v[node] = 1;                                            //노드를 방문 처리 한다.
        System.out.print(node + 1 + " ");

        for (int i = 0; i < N; i++) {                             //방문 시작
            if (v[i] == 0 && graph[node][i] == 1) {               //노드를 방문하지 않았다면,
                dfs(i);                                         //노드를
            }
        }
    }

    /**
     * 스택을 사용한 dfs
     * 1. 처음 호출된 노드를 스택에 push 한다.
     * 2. 스택이 빌 때까지 다음과 같은 과정을 반복한다.
     * 2-1. 스택의 탑의 pop 한다.
     * 2-2. pop한 노드를 방문 처리 한다.
     * 2-3. 숫자가 작은 순서대로 방문하므로 역순으로 반복문을 돌린다.
     * 2-4. 아직 방문 되지 않았고, 노드가 깊이를 가지는 경우(graph[node][i] == true) 스택에 push 한다.
     * 2-4-1. 스택은 나중에 들어온게 먼저 나가게 되므로 현재 까진
     * 스택에 쌓여 있던 노드 보다 push 된 자식 노드가 먼저 pop 되게 된다.
     */

    static void stackDfs(int node) {

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(node);

        while (!stack.isEmpty()) {

            node = stack.pop();

            if (v[node] == 0) {

                /**
                 * bfs는 큐에 node를 넣는 시점에 방문처리를 해도 무방하지만
                 * dfs는 자식노드가 스택에 계속 쌓일 수 있으므로 pop 하는 시점에 방문처리를 해야한다.
                 */

                v[node] = 1;
                System.out.print(node + 1 + " ");

                for (int i = N - 1; i >= 0; i--) {
                    if (v[i] == 0 && graph[node][i] == 1) {
                        stack.push(i);
                        //v[node] = 1;
                    }
                }
            }
        }
    }

    /**
     * queue를 사용한 bfs
     * 1. 호출된 노드를 방문처리하고, 큐에 넣는다
     * 2. 다음과 같은 과정을 큐가 빌때까지 반복한다.
     * 2-1. 노드를 poll 한다.
     * 2-2. 노드가 아직 방문되지 않았고, 깊이를 가지면 큐에 넣고, 방문처리를 한다.
     * 2-2-1. 큐에 넣게 되면 현재 큐에 있는 노드들이 우선적으로 검사되고, 나중에 자식 노드가 검사된다.
     */

    static void bfs(int node) {

        Queue<Integer> q = new LinkedList<>();
        v[node] = 1;
        q.offer(node);

        while (!q.isEmpty()) {

            node = q.poll();
            System.out.print(node + 1 + " ");

            for (int i = 0; i < N; i++) {
                if (v[i] == 0 && graph[node][i] == 1) {
                    q.offer(i);
                    v[i] = 1;
                }
            }
        }

        System.out.println();

    }
}
