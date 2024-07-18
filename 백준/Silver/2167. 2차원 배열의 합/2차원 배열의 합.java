import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //2차원 배열의 크기 입력
        int n = num[0]; //행
        int m = num[1]; //열

        int[][] array = new int[n][m]; //입력 받을 배열 선언

        for (int i = 0; i < n; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                array[i][j] = tmp[j]; //배열 저장
            }
        }

        int k = Integer.parseInt(br.readLine()); //k개의 줄 입력
        int[] resultArr = new int[k]; //k개의 줄에 대한 정답을 담을 배열 선언

        for (int i = 0; i < k; i++) {

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int row = input[2] - input[0] + 1; //탐색할 행의 수
            int col = input[3] - input[1] + 1; //탐색할 열의 수

            int startRow = input[0] - 1;
            int startCol = input[1] - 1;

            for (int j = 0; j < row; j++) {
                for (int z = 0; z < col; z++) {
                    resultArr[i] += array[startRow][startCol++];
                }

                startRow ++ ;
                startCol = input[1] - 1;
            }

        }

        for (int i : resultArr) {
            System.out.println(i);
        }

    }
}
