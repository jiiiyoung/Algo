import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int len = photo.length;
        int[] answer = new int[len];
        
        Map<String, Integer> score = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            score.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < len; i++){
            int sum = 0;
            for(String key : photo[i]){
                sum += score.getOrDefault(key, 0);
            }
            answer[i] = sum;
        }
        
        
        return answer;
    }
}