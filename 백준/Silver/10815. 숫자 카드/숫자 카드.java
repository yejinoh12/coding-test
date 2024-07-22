import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> cards = new HashSet<>();

        int n = Integer.parseInt(br.readLine()); //원래 가지고 있는 카드
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i : array){
            cards.add(i);
        }

        int m = Integer.parseInt(br.readLine()); //상근이가 가지고 있는 카드
        int[] myCards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < myCards.length; i++) {
            if (cards.contains(myCards[i])) { //있으면 1
                System.out.print("1 ");
            } else { //없으면 0
                System.out.print("0 ");
            }
        }
    }
}
