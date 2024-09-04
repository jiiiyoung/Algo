import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<String, Integer> beforeMap = new HashMap<String, Integer>();
        Map<String, Integer> afterMap = new HashMap<String, Integer>();
        
        for(String st : before.split("")){
            beforeMap.put(st, beforeMap.getOrDefault(st, 0) + 1);
        }
        
        for(String st : after.split("")){
            afterMap.put(st, afterMap.getOrDefault(st, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : beforeMap.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value != afterMap.getOrDefault(key, 0)){
                return 0;
            }
        }
        return 1;
    }
}