import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int n, m;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = array[0]; //숫자의 범위(4일 경우 숫자의 범위는 1, 2 ,3, 4 중 하나)
        m = array[1]; //숫자의 길이 = 트리의 깊이 (3일 경우 4개의 숫자중에서 3개 선택)

        recursive(0); //함수 최초 호출

    }

    public static void recursive(int k) {

        if (k == m) { //깊이 도달 시 종료
            for (int i : answer) {
                System.out.print(i + " "); //answer 리스트 출력
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {

            if (answer.contains(i + 1)) continue; //answer 리스트를 돌면서 중복값 체크

            answer.add(k, i + 1); //중복값이 없다면 리스트에 추가
            recursive(k + 1); //깊이에 1을 더해 함수 호출

            answer.remove(answer.size() - 1); // k == m 되고 정답 출력 후 다시 돌아온 부분 -> 마지막으로 추가했던 요소를 제거
        }

    }

}

