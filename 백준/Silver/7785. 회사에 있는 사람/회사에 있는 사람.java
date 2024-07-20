import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이것도 비슷해게 Map 사용
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Map<String, String> statusMap = new TreeMap<>(Collections.reverseOrder()); // 키값은 이름이고 밸류는 상태
        List<String> getName = new ArrayList<>(); // 키값은 이름이고 밸류는 상태
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputString = br.readLine().split(" ");
            String name = inputString[0];
            String status = inputString[1];
            statusMap.put(name, status); //map은 키가 있다면 기존 값을 덮어쓰니까 그냥 해도 될 것 같음
        }

        for (String str : statusMap.keySet()) {
            if (statusMap.get(str).equals("enter")) {
                System.out.println(str);
            }
        }

        //getName.sort(Comparator.reverseOrder());

        //for (String str : getName) {
            //System.out.println(str);
        //}
    }
}
