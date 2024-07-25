import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray(); //입력받은 수의 각 자리수를 배열로 만들고
        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            list.add(i); //리스트에 추가
        }

        int sum = 0;
        int count = 0;

        for (int i : list) {
            sum += i; //각 자리 수를 모두 더함
        }

        while (sum >= 10) {

            sum = 0;
            count++; //반복문을 돌때마다 카운트

            for (int i : list) {
                sum += i; //각 자리 수를 모두 더함
            }

            String tmp = Integer.toString(sum); //sum 을 int -> String 변환 후
            int[] tmpArr = Arrays.stream(tmp.split("")).mapToInt(Integer::parseInt).toArray(); //각 자리 수 추출

            list.clear(); //기존 리스트를 비우고,

            for (int i : tmpArr) {
                list.add(i); //sum 의 각 자리수를 넣어줌
            }
        }

        System.out.println(count); //반복문을 돈 횟수 출력
        System.out.println(sum % 3 == 0 ? "YES" : "NO"); //3의 배수인지 출력
    }
}