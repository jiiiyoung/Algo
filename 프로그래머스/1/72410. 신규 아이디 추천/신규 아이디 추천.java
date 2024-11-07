class Solution {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        new_id = new_id.toLowerCase().replaceAll("[^a-z0-9_.-]", "");
        
        boolean dot = false;
        for(char ch : new_id.toCharArray()){
            if(dot && ch == '.'){
                continue;
            }else if(ch == '.'){
                dot = true;
            }else{
                dot = false;
            }
            answer.append(ch);
        }
        
        if(answer.charAt(0) == '.'){
           answer = new StringBuilder(answer.substring(1));
        }

        answer = new StringBuilder(checkLastDot(answer.toString()));

        if(answer.length() == 0){
            answer.append("a");
        }
        
        if(answer.length() > 15){
            answer = new StringBuilder(answer.substring(0, 15));
            answer = new StringBuilder(checkLastDot(answer.toString()));
        }
        
        while(answer.length() < 3){            
                answer.append(answer.charAt(answer.length() - 1));
        }
        
        
        
        
        
        return answer.toString();
    }
    
    String checkLastDot(String str){
        if(str.length() != 0 && str.charAt(str.length() - 1) == '.'){
            return str.substring(0, str.length() - 1);
        }
        return str;
    }
}