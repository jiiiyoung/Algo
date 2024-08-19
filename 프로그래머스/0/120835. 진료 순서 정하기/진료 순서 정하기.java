import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int len = emergency.length;
        int[] answer = new int[len];
        Map<Integer, Integer> hm = new HashMap<>(); 
        int[] sortArr = Arrays.copyOfRange(emergency, 0, len);
        Arrays.sort(sortArr);
        for(int i = 0; i < len ; i++){
            hm.put(sortArr[i], len - i);
        }
        for(int i = 0; i < len; i++){
            emergency[i] = hm.get(emergency[i]);
        }
        return emergency;
        
    }
}