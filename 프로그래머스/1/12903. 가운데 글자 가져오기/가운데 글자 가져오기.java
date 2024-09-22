class Solution {
    public String solution(String s) {
        
        int len = s.length();
        StringBuilder answer = new StringBuilder();
        if(len % 2 == 0){
            answer.append(s.charAt(len / 2 - 1));
        }
        answer.append(s.charAt(len / 2));
        
        return answer.toString();
    }
}