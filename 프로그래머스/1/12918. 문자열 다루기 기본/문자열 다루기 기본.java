class Solution {
    public boolean solution(String s) {
        
        boolean answer = false;
        
        if(s.length() == 4 || s.length() == 6){
            s = s.replaceAll("[0-9]", "");
            if(s.length() == 0){
                answer = true;
            }
        }
        
        return answer;
    }
}