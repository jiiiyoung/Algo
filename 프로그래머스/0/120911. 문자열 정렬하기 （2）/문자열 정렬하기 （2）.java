import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for(char c : my_string.toCharArray()){
            sb.append(String.valueOf(Character.toLowerCase(c)));
        }
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        String answer = new String(arr);
        return answer;
    }
}