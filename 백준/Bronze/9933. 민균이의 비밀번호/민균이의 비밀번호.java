
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 접근 방법
 * 1. list에 넣기 전에 문자를 reverse
 * 2. 그 값이 자기 자신이거나, 리스트 안에 있으면
 * 3. 그 문자가 정답이 된다.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {

            StringBuilder str = new StringBuilder(br.readLine());
            list.add(str);

            StringBuilder strReverse = new StringBuilder(str);
            strReverse.reverse();

            for(StringBuilder s : list){
                if(s.toString().equals(strReverse.toString())){
                    System.out.println(str.length() + " " + str.charAt(str.length() / 2));
                    break;
                }
            }
        }
    }
}
