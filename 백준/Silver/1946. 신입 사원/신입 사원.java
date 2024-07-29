
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int[] resume = new int[N];
            int[] interview = new int[N];

            List<Person> list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                String[] str = br.readLine().split(" ");

                resume[j] = Integer.parseInt(str[0]);       //서류 점수
                interview[j] = Integer.parseInt(str[1]);    //면접 점수

                list.add(new Person(resume[j], interview[j]));
            }

            list.sort(null);

//            for (Person person : list) {
//                System.out.println(person);
//            }

            int count = 1;
            int key = list.get(0).iScore;
            for(int j = 1; j < list.size(); j++){
                if(key > list.get(j).iScore){
                    count++;
                    key = list.get(j).iScore;
                }

            }

            bw.write(count + "\n");

        }

        bw.flush();
        bw.close();
    }

    public static class Person implements Comparable<Person> {
        int rScore;
        int iScore;

        public Person(int rScore, int iScore) {
            this.rScore = rScore;
            this.iScore = iScore;
        }

        @Override
        public int compareTo(Person o) {
            return this.rScore - o.rScore;
        }

        @Override
        public String toString() {
            return rScore + ", " + iScore;
        }
    }
}
