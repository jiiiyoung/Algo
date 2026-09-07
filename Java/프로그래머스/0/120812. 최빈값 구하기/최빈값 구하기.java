import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> counting = new HashMap<>();
        
        for(int i = 0; i < array.length; i++){
            int key = array[i];
            int value = counting.getOrDefault(key, 0) + 1;

            counting.put(key, value);
        }
        
        int maxValue = 0;
        int maxKey = 0;
        for(Map.Entry<Integer, Integer> entry : counting.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            
            if (value > maxValue){
                maxKey = key;
                maxValue = value;
            }
        }
        
        int duplicationCnt = 0;
        for(Integer value : counting.values()){
            if (maxValue == value){
                duplicationCnt++;
            }
        }
        
        return duplicationCnt > 1 ? -1 : maxKey;
    }
}