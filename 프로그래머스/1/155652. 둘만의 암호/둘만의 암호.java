import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            answer.append(trans(ch, skip, index));
        }

        return answer.toString();
    }
    
    String trans(char ch, String skip, int index){
        int current = 0;
        while(current < index){
            ch += 1;
            if(ch > 'z'){
            ch -= 26;
            }   
            if(skip.contains(String.valueOf(ch))){
                continue;
            }
            
            current++;
        }
        
        return String.valueOf(ch);
    }
}