import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> cards = new HashMap<>();

        int n = Integer.parseInt(br.readLine()); //원래 가지고 있는 카드
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i : array) {
            cards.put(i, cards.getOrDefault(i, 0) + 1); //Map 에 넣기
        }

        int m = Integer.parseInt(br.readLine()); //상근이가 가지고 있는 카드
        int[] myCards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i : myCards) {
            if (cards.containsKey(i)) {
                bw.write(cards.get(i) + " ");
            } else {
                bw.write("0 ");
            }
        }

        bw.close();
    }
}
