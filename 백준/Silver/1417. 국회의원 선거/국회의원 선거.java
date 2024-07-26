
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1. 다솜이 보다 작은 값은 영향을 미치지 않음, 다솜이 보다 큰 값만 비교 -> 다솜이의 값이 최소값이 됨
 * 2. 다솜이 득표수와 현재 max 값을 계속 비교 , 다솜이가 커질 때까지 max-- 해주고, 다솜이++ 해줌
 * 예제 2번 [10] [10,10,10] -> [11] [10,10,9]
 * 예제 4번 [5] [10, 8, 7] -> [6] [9, 8, 7] -> [7] [8, 8, 7] -> [8] [8, 7, 7] -> [9] [7, 7, 7]
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        List<Integer> score = new ArrayList<>();

        int myScore = Integer.parseInt(br.readLine()); // 다솜이
        for (int i = 0; i < num - 1; i++) {
            int tmp = Integer.parseInt(br.readLine()); //다른 사람들 값
            if (tmp >= myScore) score.add(tmp);
        }

        score.sort(Comparator.reverseOrder()); //내림 차순 정렬 score.get(0)을 항상 max 값으로 만들기 위해서

        int count = 0;
        while (!score.isEmpty() && myScore <= score.get(0)) { //다솜이의 값이 작다면 계속 반복
            count++; //반복횟수 증가
            myScore++; //다솜이 값 증가
            score.set(0, score.get(0) - 1); //max 감소
            score.sort(Comparator.reverseOrder()); //다시 내림차순 정렬
        }

        System.out.println(count);
    }
}
