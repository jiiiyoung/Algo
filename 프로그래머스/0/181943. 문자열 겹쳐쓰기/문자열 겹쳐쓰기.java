class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        for(int i = 0; i < s;i++){
            answer += my_string.toCharArray()[i];
        }
        
        for(int i = 0; i < overwrite_string.length(); i++){
            answer += overwrite_string.toCharArray()[i];
        }
        int start = s + overwrite_string.length();
        for(int i =start; i < my_string.length() ;i++){
            answer += my_string.toCharArray()[i];
        }
        
        return answer;
    }
}