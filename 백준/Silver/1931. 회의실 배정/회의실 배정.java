
import java.io.*;
import java.util.*;

/**
 * 그리디 : 눈앞의 이익만 우선 추구, 드물게 최적해 보장
 * 그리디로 최적해가 보장 되는 예 : MST, 회의실 배정 문제
 *
 * 회의실 배정 문제 : 종료 시간을 기준으로 정렬 -> 시간이 겹치면 제외 시키기
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];

        for(int i  = 0 ; i < n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, new Compare());

        int availableRoom = 1;
        int endTime = meetings[0][1]; //끝난 시간이 4라면 5가 시작인 회의를 찾아야함
        for(int i = 1; i < n; i++) {
            if (meetings[i][0] >= endTime) {
                endTime = meetings[i][1];
                availableRoom++;
            }
        }

        bw.write(availableRoom +  " ");
        bw.flush();
        bw.close();

    }

    static class Compare implements Comparator<int[]>{

        @Override
        public int compare(int[] a, int[] b){
            if(a[1] == b[1]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        }
    }

}
