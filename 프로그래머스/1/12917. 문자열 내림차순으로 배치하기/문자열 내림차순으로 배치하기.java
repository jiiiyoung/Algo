import java.util.*;

class Solution {
    public String solution(String s) {
                
        String[] strArr = s.split("");
        
        Arrays.sort(strArr, (o1, o2) -> o2.charAt(0) - o1.charAt(0) );
        
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < strArr.length; i++){
            answer.append(strArr[i]);
        }
        
        return answer.toString();
    }
}