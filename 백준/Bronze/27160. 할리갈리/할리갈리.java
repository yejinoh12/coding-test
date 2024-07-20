import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 접근 방법 : map<String, Integer> 자료구조를 이용해서 과일, 개수를 넣고
 * 숫자가 추가될 때마다 개수를 갱신, 갱신 된 숫자가 5 이면 YES, 아니면 NO
 */
public class Main {

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> card = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //카드의 수

        for(int i = 0; i < n; i++){
            String[] inputString = br.readLine().split(" ");
            String fruit = inputString[0];
            Integer number = Integer.parseInt(inputString[1]);
            card.put(fruit, card.getOrDefault(fruit, 0) + number);
        }

        int count = 0;
        for(Integer i : card.values()){
            if(i == 5){
                count ++;
            }
        }
        System.out.println(count >= 1 ? "YES"  : "NO");
        
    }
}
