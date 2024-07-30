
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 학생수가 최대였던 순간의 학생수/식당 입구의 맨 뒤에 대기 중인 학생의 번호 출력
 * 대기하는 학생이 여러명이라면 맨 뒤에 줄 서 있는 학생의 번호가 가장 작은 경우 출력
 */
public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int maxQueueSize = 0; //학생수가 최대였던 순간
        int lastStudent = 100_000; //맨뒤에 대기중인 학생의 번호
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){

            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int s = Integer.parseInt(st.nextToken());

            if(s == 1){

                int student = Integer.parseInt(st.nextToken());

                q.addLast(student);

                if(maxQueueSize < q.size()){
                    maxQueueSize = q.size(); //큐 사이즈 갱신
                    lastStudent = student;
                
                }else if(maxQueueSize == q.size()){
                    lastStudent = Math.min(lastStudent, student);
                }

            }else{
                q.pollFirst();
            }
        }

        bw.write(maxQueueSize + " " + lastStudent);
        bw.flush();
        bw.close();
    }

}
