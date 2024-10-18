import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};
        
        for(String babble : babbling){
            for(int i = 0; i < word.length; i++){
                babble = babble.replaceAll(word[i], String.valueOf(i));
            }

            if(stringIsDigit(babble)){
                answer++;
                char temp = babble.charAt(0);
            
                for(int i = 1; i < babble.length(); i++){
                    if(babble.charAt(i) == temp){
                        answer--;
                        break;
                    }
                    temp = babble.charAt(i);
                }
            }
        }
        
        return answer;
    }
    
    boolean stringIsDigit(String str){
        for(char digit : str.toCharArray()){
            if(!Character.isDigit(digit)){
                return false;
            }
        }
        return true;
    }
}