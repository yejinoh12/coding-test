
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){

            int N = Integer.parseInt(br.readLine());

            String[] name = new String[N];
            int[] value = new int[N];

            int max = 0;
            int maxIndex = 0;

            for(int j = 0; j < N; j++){
                String[] str = br.readLine().split(" ");
                name[j] = str[0];
                value[j] = Integer.parseInt(str[1]);

                if(value[j] > max){
                    max = value[j];
                    maxIndex = j;
                }
            }

            System.out.println(name[maxIndex]);

        }
    }
}
