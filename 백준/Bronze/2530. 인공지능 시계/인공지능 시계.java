import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        int inputSecond = Integer.parseInt(bf.readLine());

        int[] inputTime = new int[3];

        for(int i = 0; i < 3; i++){
            inputTime[i] = Integer.parseInt(str[i]);
        }

        int[] convertTime = new int[3];
        convertTime[0] = inputSecond / 3600;
        convertTime[1] = (inputSecond % 3600) / 60;
        convertTime[2] = (inputSecond % 3600) % 60;


        int secToMin = (convertTime[2] + inputTime[2]) / 60;
        convertTime[2] = (convertTime[2] + inputTime[2]) % 60;

        int minToHour = (convertTime[1] + inputTime[1] + secToMin) / 60 ;
        convertTime[1] = (convertTime[1] + inputTime[1] + secToMin) % 60 ;

        convertTime[0] = (convertTime[0] + inputTime[0] + minToHour) % 24;

        for(int i : convertTime){
            System.out.print(i + " ");
        }
    }
}