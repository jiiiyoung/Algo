import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> participants = new HashMap<>();
        
        for(String people : participant){
            participants.put(people, participants.getOrDefault(people, 0) + 1);
        }
        
        for(String completionPeople : completion){
            participants.put(completionPeople, participants.get(completionPeople) -1);
        }
        
        String answer = "";
        for(Map.Entry<String, Integer> entry : participants.entrySet()){
        if(entry.getValue() != 0){
            answer = entry.getKey();
        }
    }
        
        return answer;
    }
}