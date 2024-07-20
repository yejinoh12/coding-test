import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 처음 접근 : " " 을 기준으로 단어를 split 해서 length 구하기 --> 앞공백이 있을 경우 실패
 * 2번째 접근: 먼저 trim()으로 공백을 제거하고 split --> 실패
 * 3번째 접근: 문자열이 공백으로 시작하거나 끝날 수 있는 경우 조건문 추가
 */
public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();

        inputString = inputString.trim(); //앞 뒤 공백 제거

        String[] s = inputString.split(" "); //문자열 split

        int result = 0;
        for(String str : s){
            //System.out.println(" <" + str + ">");
            if (str.isBlank()){
                result = 0;
            }else{
                result = s.length;
            }
        }

        System.out.println(result); //길이 출력
    }
}
