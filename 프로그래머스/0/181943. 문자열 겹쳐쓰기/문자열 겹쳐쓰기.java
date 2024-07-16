import java.lang.String;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        String tmp1 = my_string.substring(0, s);
        String tmp2 = my_string.substring(tmp1.length() + overwrite_string.length());
        String answer = tmp1 + overwrite_string + tmp2;
        return answer;
    }
}