class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            
            if(Character.isUpperCase(ch)){
                ch += n;
                if(ch > 'Z'){
                    ch -= 26;
                }                
            }else if(Character.isLowerCase(ch)){
                ch += n;
                if(ch > 'z'){
                    ch -= 26;
                }                
            }
            answer.append(String.valueOf(ch));
            
        }
        
        return answer.toString();
    }
}