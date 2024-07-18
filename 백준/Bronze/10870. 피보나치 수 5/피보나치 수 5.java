import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(rec(n));
    }

    public static int rec(int n){

        if(n ==0){
            return 0;
        }else if(n == 1){
            return 1;
        }

        return rec(n-1)+rec(n-2);
    }
}
