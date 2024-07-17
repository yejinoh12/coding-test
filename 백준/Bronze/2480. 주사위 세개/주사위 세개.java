import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] array = bf.readLine().split(" ");
        ArrayList<Integer> dice = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dice.add(Integer.parseInt(array[i]));
        }

        dice.sort(null); //정렬

        int result = 0;

        if (dice.get(1).equals(dice.get(0)) || dice.get(1).equals(dice.get(2))) { //중간자리, 앞자리 또는 중간자리 , 뒷자리가 같다면

            if (dice.get(0).equals(dice.get(2))) { //앞자리와 뒷자리 비교
                result = 10000 + dice.get(0) * 1000; //모두 일치하는 경우
            } else {
                result = 1000 + dice.get(1) * 100; //한번만 일치하는 경우
            }
        } else {
            result = Collections.max(dice) * 100; //모두 일치하지 않는 경우
        }

        System.out.println(result);
    }
}