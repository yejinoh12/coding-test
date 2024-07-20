import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        Map<String, Integer> fileMap = new TreeMap<>(); //정렬을 위한 트리맵
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String file = br.readLine();
            int index = file.indexOf("."); //. 이 들어간 인덱스를 찾고
            file = file.substring(index + 1); //인덱스 이후 글자만 추출
            //System.out.println(index);
            fileMap.put(file, fileMap.getOrDefault(file, 0) + 1); //카운트를 세면서 맵에 넣음 
        }

        for(String str : fileMap.keySet()){
            System.out.println(str + " " + fileMap.get(str));
        }
    }
}
