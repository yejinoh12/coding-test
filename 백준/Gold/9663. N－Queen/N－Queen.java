
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int N;
    public static boolean[] v1; //행체크
    public static boolean[] v2; //대각선 체크 1 ( / )
    public static boolean[] v3; //대각선 체크 2 ( \ )
    //public static List<Integer> ans;
    public static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        count = 0;
        v1 = new boolean[N];
        v2 = new boolean[N * 2 - 1];
        v3 = new boolean[N * 2 - 1];
        //ans = new ArrayList<>();

        nQueen(0);
        bw.write(count + "");
        bw.close();

    }

    public static void nQueen(int n) {

        if(n == N){
            /*for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();*/
            count+=1;
            return;
        }



        for (int i = 0; i < N; i++) {

            if (!v1[i] && !v2[n + i] && !v3[n - i + N - 1]) {

                v1[i] = true;
                v2[n + i] = true;
                v3[n - i + N - 1] = true;

                //ans.add(i);
                nQueen(n + 1);
                //ans.remove(ans.size() - 1);

                v1[i] = false;
                v2[n + i] = false;
                v3[n - i + N - 1] = false;

            }
        }
    }
}

