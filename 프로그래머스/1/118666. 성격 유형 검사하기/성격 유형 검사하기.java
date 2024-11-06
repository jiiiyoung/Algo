import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        
        Map<Character, Integer> type = new HashMap<>();
        Character[] character = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for(Character ch : character){
            type.put(ch, 0);
        }
        
        for(int i = 0; i < choices.length; i++){
            int choice = choices[i];
            char key = survey[i].charAt(0);
            if(choice < 4){
                type.put(key, type.get(key) + 4 - choice);
            }else if(choice > 4){
                key = survey[i].charAt(1);
                type.put (key, type.get(key) + choice - 4);
            }
        }
        
        for(int i = 0; i < 8; i += 2){
            Integer first = type.get(character[i]);
            Integer second = type.get(character[i+1]);
            if(first < second){
                answer.append(character[i + 1]);
            }else{
                answer.append(character[i]);
            }
        }
        
        

        return answer.toString();
    }
}