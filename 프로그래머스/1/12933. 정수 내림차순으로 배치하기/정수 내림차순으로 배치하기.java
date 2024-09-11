import java.util.*;

class Solution {
    public long solution(long n) {
        String[] strArray = String.valueOf(n).split("");
        Arrays.sort(strArray);
        
        StringBuilder sb = new StringBuilder();
        for(String str : strArray){
            sb.insert(0, str);
        }
        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}