import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 접근 방법
 * 문자가 바뀌는 인덱스는 테스트케이스의 배수임을 이용
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine()); //테스트 케이스의 수 입력받기
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < testCase; i++) {

            String[] str = bf.readLine().split(" "); //문자열을 받고

            int count = Integer.parseInt(str[0]); //str[0] -> 테스트 케이스의 반복 횟수
            char[] charArray = str[1].toCharArray(); //str[1] -> 반복할 문자열(스트링을 char 배열로 바꿈)

            char[] newCharArray = new char[charArray.length * count]; //정답을 담을 char 배열 만들기

            int index = 0;
            for (int j = 0; j < newCharArray.length; j++) {

                if (j % count == 0 && j != 0) { //j가 0이 아니고, count의 배수이면 ch의 인덱스를 증가시킴
                    index += 1;
                }

                newCharArray[j] = charArray[index];
            }

            result.add(String.valueOf(newCharArray));

        }

        for(String str : result){
            System.out.println(str);
        }

    }
}
