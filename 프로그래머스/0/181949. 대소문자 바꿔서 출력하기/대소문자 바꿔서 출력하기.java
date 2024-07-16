import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String a = sc.next();
        char[] charArr = a.toCharArray();
        //System.out.println(charArr);

      //아스키 문자 a = 65, A = 97
        for(int i = 0; i < charArr.length; i++){
           if(charArr[i] < 97){
             charArr[i] += 32;
           } else{
             charArr[i] -= 32;
           }
        }

        for(char c : charArr){
            System.out.print(c);
        }
    }

}