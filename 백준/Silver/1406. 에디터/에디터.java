
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * stringBuilder 시간초과 --> dequeue 사용
 */
public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputString = br.readLine().split("");
        int num = Integer.parseInt(br.readLine()); //반복횟수

        Deque<Character> editor = new ArrayDeque<>(); //추가, 삭제가 모두 뒤에서 이루어짐 (addLast, pollLast)
        Deque<Character> waiting = new ArrayDeque<>(); //추가, 삭제가 모두 앞에서 이루어짐(addFirst, pollFirst)

        for(String i : inputString){
            editor.addLast(i.charAt(0));
        }

        for (int i = 0; i < num; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();

            switch (method) {

                case "L": // editing 마지막 요소를 waiting 앞 쪽에 넣어줌
                    if(!editor.isEmpty()) waiting.addFirst(editor.pollLast());
                    break;

                case "D": //waiting에서 기다리고 있는 요소를 앞에서 부터 꺼내서 editing 뒤에 추가
                    if (!waiting.isEmpty()) editor.addLast(waiting.pollFirst());
                    break;

                case "B": //editing 마지막 숫자 삭제
                    if(!editor.isEmpty()) editor.pollLast();
                    break;

                case "P": // editing 마지막에 숫자 추가
                    editor.addLast(st.nextToken().charAt(0));
                    break;
            }
        }

        for(char i  : waiting){
            editor.addLast(i);
        }

        for(char i : editor){
            bw.write(i);
        }

        bw.close();

    }
}


