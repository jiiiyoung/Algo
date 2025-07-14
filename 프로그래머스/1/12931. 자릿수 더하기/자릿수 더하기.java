import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String strInt = n + "";
        
        for(char ch: strInt.toCharArray()){
            answer += Integer.parseInt(String.valueOf(ch));
        }


        return answer;
    }
}