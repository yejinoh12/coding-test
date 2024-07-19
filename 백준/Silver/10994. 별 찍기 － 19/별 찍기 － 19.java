import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] star;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int size = 4 * n - 3;
        star = new char[size][size]; //4 * n-3 크기의 별 출력

        for (int i = 0; i < size; i++) { //초기화
            for (int j = 0; j < size; j++) {
                star[i][j] = ' ';
            }
        }

        drawStar(n, 0, 4*n-4); //함수 호출

        for (int i = 0; i < size; i++) { //별 출력
            for (int j = 0; j < size; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }

    public static void drawStar(int n, int start, int end) {

        if (n == 0) return;

        int size = 4 * n - 3;

        for (int i = start; i <= end; i++) {
            star[start][i] = '*';  // 윗부분
            star[end][i] = '*';    // 아랫부분
            star[i][start] = '*';  // 왼쪽부분
            star[i][end] = '*';    // 오른쪽부분
        }

        //멘토님 말씀처럼 n의 크기는 1씩 줄어들고, 시작점은 2씩 늘어나고, 끝점은 2씩 줄어듦
        drawStar(n - 1, start + 2, end - 2);
    }
}