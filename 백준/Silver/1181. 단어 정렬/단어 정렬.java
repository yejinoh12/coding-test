
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> word = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(!word.contains(str)) word.add(str);
        }

        Collections.sort(word, (a, b) -> {
            int lenCompare = Integer.compare(a.length(), b.length());
            if(lenCompare == 0){
                return a.compareTo(b);
            }else{
                return lenCompare;
            }
        });

        for(String str : word){
            System.out.println(str);
        }
    }
}
