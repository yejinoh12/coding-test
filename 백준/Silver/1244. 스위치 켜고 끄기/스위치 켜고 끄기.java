import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(br.readLine()); //스취위 개수
        int[] switchStatus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //스위치 상태

        int studentCount = Integer.parseInt(br.readLine()); //학생수
        int[][] switchChange = new int[studentCount][2]; //성별과 입력 번호를 넣을 2차원 배열 선언

        for (int i = 0; i < studentCount; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 2; j++) {
                switchChange[i][j] = tmp[j]; //성별과 입력 번호 입력
            }
        }

        /**
         * 남학생일 경우 : 스위치가 자기가 받은 수의 배수일 경우 상태를 바꿈
         * 여학생일 경우 : 좌우 대칭인 부분만 스위치 변경(항상 홀수)
         */

        for (int i = 0; i < studentCount; i++) {

            int sex = switchChange[i][0]; //성별을 받아오기
            int number = switchChange[i][1]; //누른 스위치를 받아오기

            if (sex == 1) { //남학생의 경우

                for (int j = 0; j < switchCount; j++) {

                    //수가 배수일 경우
                    if ((j + 1) % number == 0) { // index [0, 1, 2, 3, 4, 5, 6, 7] -> j+1 [1, 2, 3, 4, 5, 6, 7, 8]

                        if (switchStatus[j] == 0) { // 상태가 0 이라면 1로 바꾸기
                            switchStatus[j] = 1;
                        } else if (switchStatus[j] == 1) { //상태가 1이라면 0으로 바꾸기
                            switchStatus[j] = 0;
                        }
                    }
                }

            } else if (sex == 2) { //여학생의 경우
                
                //탐색 불가능한 경우 : 인덱스 가 0 이거나, 마지막일 경우 
                if (number <= 1 || number == switchStatus.length) { 
                    switchStatus[number - 1] = toggle((switchStatus[number - 1]));
                    continue;
                }

                int low = number - 2; //이전 값 탐색을 위한 변수 //number가 3이면 low = 1
                int high = number; //이후 값 탐색을 위한 변수 //high = 3

                // 자기 자신 값 바꾸기
                switchStatus[number - 1] = toggle(switchStatus[number - 1]);

                //대칭 부분 값 바꾸기
                while (switchStatus[low] == switchStatus[high]) { //low와 high가 같을 동안만 루프를 돌고, 상태를 변경

                    switchStatus[low] = toggle(switchStatus[low]);
                    switchStatus[high] = toggle(switchStatus[high]);

                    low--;
                    high++;

                    if (low == -1 || high == switchStatus.length) break;
                }

            }

        }

        for (int i = 0; i < switchCount; i++) {
            if(i != 0 && i % 20 == 0) System.out.println();
            System.out.print(switchStatus[i] + " ");
        }

    }

    public static int toggle(int n) {
        if (n == 0) {
            n = 1;
        } else if (n == 1) {
            n = 0;
        }
        return n;
    }
}
