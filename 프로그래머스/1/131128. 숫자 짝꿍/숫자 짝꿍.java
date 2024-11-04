import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> pair1 = new TreeMap<>();
        Map<String, Integer> pair2 = new TreeMap<>();
        StringBuilder answer = new StringBuilder();
        
        for(String x : X.split("")){
            pair1.put(x, pair1.getOrDefault(x, 0) + 1);
        }
        for(String y : Y.split("")){
            pair2.put(y, pair2.getOrDefault(y, 0) + 1);
        }
                
        boolean zeroOnly = false;
        for(Map.Entry<String, Integer> entry : pair1.entrySet()){
            Integer pairValue = pair2.getOrDefault(entry.getKey(), 0);
            Integer repeatCount = Math.min(pairValue, entry.getValue());
            
            if(repeatCount != 0){
                zeroOnly = (entry.getKey().equals("0")) ? true : false;
            }
            
            answer.append(entry.getKey().repeat(repeatCount));
        }
        
        if(zeroOnly){
            return "0";
        }
        
        if(answer.length() == 0){
            return "-1";
        }
        
        
        answer.reverse();
        return answer.toString();
    }
}