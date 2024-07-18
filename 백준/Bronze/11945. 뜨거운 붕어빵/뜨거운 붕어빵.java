import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = num[0];
        int m = num[1];

        char[][] result = new char[n][m];

        for (int i = 0; i < n; i++) {
            int k = m;
            char[] ch = br.readLine().toCharArray(); //붕어빵 모양 입력받음
            for (int j = 0; j < m; j++) {
                //모양을 반전 시켜 result 에 넣기
                result[i][j] = ch[--k];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}