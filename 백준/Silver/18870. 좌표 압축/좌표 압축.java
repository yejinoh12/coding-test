import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        List<Integer> sortingList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int index = 0;
        while (st.hasMoreTokens()) { //O(n)
            arr[index] = Integer.parseInt(st.nextToken());
            sortingList.add(arr[index++]);
        }

        sortingList.sort(null); //평균, 최악 O(nlogn)

        int currentIndex = 0;
        for(int i : sortingList){ //O(n)
            if(!map.containsKey(i)) map.put(i, currentIndex++); //map.containsKey O(1)
        }

        for(int i : arr){ //O(n)
            bw.write(map.get(i) + " ");
        }
        
        bw.close();
    }
}
