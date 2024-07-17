import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        int[] number = new int[5];

        int result = 0;
        for (int i = 0; i < 5; i++) {
            number[i] = Integer.parseInt(str[i]) * Integer.parseInt(str[i]);
            result += number[i];
        }

        int average = result % 10;
        System.out.println(average);
    }
}