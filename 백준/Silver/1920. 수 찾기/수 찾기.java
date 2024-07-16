import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int m = sc.nextInt();
        int[] findNum = new int[m];
        for (int i = 0; i < m; i++){
            findNum[i] = sc.nextInt();
        }

        //System.out.println("list = " + list);
        //System.out.println("findNum = " + findNum);

        for(int i=0; i< findNum.length; i++){
            if(Arrays.binarySearch(arr, findNum[i]) >= 0){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
}
