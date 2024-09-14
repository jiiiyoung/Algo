import java.util.*;

class Solution {
    public boolean solution(int x) {
        
        int sum = 0;
        boolean answer = false;
        
        for(String str : String.valueOf(x).split("")){
            sum += Integer.parseInt(str);
        }
        
        if(x % sum == 0){
            answer = true;
        }
        
        return answer;
    }
}