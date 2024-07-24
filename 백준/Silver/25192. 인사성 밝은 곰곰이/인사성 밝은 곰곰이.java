import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * map 사용
 * enter이 나오면 map 전체 내용을 지우기
 * getOrDefault로 밸류값이 1이상인 사람만 카운팅
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        int num = Integer.parseInt(br.readLine());
        String[] str = new String[num + 1];
        int count = 0;

        for (int i = 0; i < num; i++) { //사람을 입력받음
            String s = br.readLine();
            str[i] = s;
        }

        str[num] = "ENTER"; //배열의 마지막에 enter 추가


        for (int i = 1; i <= num; i++) { //처음 enter는 무시하고 i = 1부터 시작

            if (str[i].equals("ENTER")) { //입력값이 enter 이면
                for (int j : map.values()) {
                    if (j >= 1) count++; //맵에서 1이상인 사람들을 카운팅
                }
                map.clear(); //맵 비우기
            } else {
                map.put(str[i], map.getOrDefault(str[i], 0) + 1); //Enter가 아니면 맵에 <사람이름, 횟수> 저장
            }
        }

        System.out.println(count);
    }
}
