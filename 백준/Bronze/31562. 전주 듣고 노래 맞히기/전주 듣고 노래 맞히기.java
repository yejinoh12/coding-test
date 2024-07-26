
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * map<노래, 코드>와 문제 코드를 비교하기
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<String, String> songs = new LinkedHashMap<>();
        List<String> quiz = new ArrayList<>();
        int n = input[0];
        int m = input[1];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            songs.put(str[1], str[2] + str[3] + str[4]); //노래와 코드를 맵으로 저장
        }

        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            quiz.add(str[0] + str[1] + str[2]); //문제로 내진 코드를 저장
        }

        int count = 0;
        for (int i = 0; i < m; i++) {

            String songName = " ";
            count = 0;
            for (String str : songs.keySet()) { //map에 있는 노래인지 검사
                if (songs.get(str).equals(quiz.get(i))) {
                    songName = str;
                    count++; //있으면 카운트
                    if (count == 2) break;
                }
            }

            //System.out.println(quiz.get(i) + ": " + count);

            if (count == 0) {
                System.out.println("!"); //없는 경우
            } else if (count == 1) {
                System.out.println(songName); //하나 있는 경우
            } else {
                System.out.println("?"); //여러개 있는 경우
            }
        }
    }
}
