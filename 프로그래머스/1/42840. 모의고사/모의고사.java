import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] people1 = {1, 2, 3, 4, 5};
        int[] people2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] people3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        Map<Integer, Integer> score = new HashMap<>();
        
        for(int i = 0; i < answers.length; i++){
            if(people1[i % 5] == answers[i]){
                score.put(1, score.getOrDefault(1, 0) + 1);
            }
            if(people2[i % 8] == answers[i]){
                score.put(2, score.getOrDefault(2, 0) + 1);
            }
            if(people3[i % 10] == answers[i]){
                score.put(3, score.getOrDefault(3, 0) + 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Integer max = 0;
        for(Map.Entry<Integer, Integer> entry : score.entrySet()){
            if(entry.getValue().compareTo(max) == 1){
                max = entry.getValue();
                sb.setLength(0);
                sb.append(entry.getKey());
            }else if(max.equals(entry.getValue()) ){
                sb.append(entry.getKey());
            }
        }
        int[] answer = new int[sb.length()];
        int i = 0;
        for(String str : sb.toString().split("")){
            answer[i++] = Integer.parseInt(str); 
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}