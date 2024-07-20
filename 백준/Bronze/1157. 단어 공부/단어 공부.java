import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        HashMap<Character, Integer> words = new HashMap<>(); // 키값은 알파벳이 되고, 밸류는 카운티한 숫자가 됨

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputStr = br.readLine().toUpperCase().toCharArray(); //대문자로 바꾸고 char 배열로 바꿈

        for (int i = 0; i < inputStr.length; i++) {
            words.put(inputStr[i], words.getOrDefault(inputStr[i], 0) + 1); // 키값이 있다면 원래 있던 값에 +1, 키값이 없다면 0
        }

        char maxChar = ' '; //정답 캐릭터 변수를 담을 char 변수 선언
        int max = 0; // 갱신해갈 max 변수
        boolean findEqual = false; //동일한 값이 있다면 true

        for (Character c : words.keySet()) {  //맵을 조회
            //System.out.println(c + " - " + words.get(c));
            if (words.get(c) > max) { //조회하는 키의 값이 max 보다 크다면
                max = words.get(c); //max 갱신
                maxChar = c; //maxChar 도 갱신
                findEqual = false;
            } else if (words.get(c) == max) { //동일한 값이 있다면
                findEqual = true; //상태를 true로
            }
        }

        System.out.println(findEqual ? "?" : maxChar); //동일한 값이 있다면 ? 없다면 maxChar
    }
}
