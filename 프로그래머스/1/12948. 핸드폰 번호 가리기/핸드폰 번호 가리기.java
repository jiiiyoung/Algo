class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        int len = phone_number.length();
        for(int i = 0; i < len; i++){
            if(len-4 > i){
                answer.append("*");
            }else{
                answer.append(phone_number.charAt(i));
            }
        }
        
        
        return answer.toString();
    }
}