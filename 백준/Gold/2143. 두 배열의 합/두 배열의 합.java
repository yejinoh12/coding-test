
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        br.readLine();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> listA = new ArrayList<>();

        br.readLine();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> listB = new ArrayList<>();

        int num = 0;
        for (int i = 0; i < A.length; i++) {
            num = A[i];
            listA.add(A[i]); //자기 자신은 넣어줌
            for (int j = i + 1; j < A.length; j++) {
                num += A[j]; //배열을 하나씩 더해가면서
                listA.add(num); //A 부배열의 합을 더하기
            }
        }

        //B도 A와 똑같이
        for (int i = 0; i < B.length; i++) {
            num = B[i];
            listB.add(B[i]);
            for (int j = i + 1; j < B.length; j++) {
                num += B[j];
                listB.add(num);
            }
        }

        listB.sort(null);

        long count = 0;
        for (int i = 0; i < listA.size(); i++) {

            int target = T - listA.get(i);
            //System.out.println("target : " + target);

            int low = lower_bound(listB, target);
            int high = upper_bound(listB, target);
            if(low != -1 || high != -1) {
                count += (high - low + 1);
            }
        }

        System.out.println(count);

    }

    public static int lower_bound(List<Integer> arr, int target) {

        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr.get(mid) >= target) {
                high = mid - 1;
            } else if (arr.get(mid) < target) {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int upper_bound(List<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr.get(mid) > target) {
                high = mid - 1;
            } else if (arr.get(mid) <= target) {
                low = mid + 1;
            }
        }

        return high;
    }
}
