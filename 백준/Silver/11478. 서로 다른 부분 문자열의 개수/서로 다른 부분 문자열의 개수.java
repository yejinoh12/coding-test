import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 이중 포문을 돌면서 문자열을 계속 연결해가고, 연결된 문자열을 set에 넣기..??
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Set<String> words = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();


        for(int i = 0; i < str.length(); i++){
            String string = "";
            char c = str.charAt(i); // 기준 문자열 str.charAt(i) 을 기준으로 문자열을 더해나간다.
            string += c;
            words.add(string);
            for(int j = i + 1; j < str.length(); j++){

                string += str.charAt(j);
                words.add(string);

            }
        }

        System.out.println(words.size());

    }
}
