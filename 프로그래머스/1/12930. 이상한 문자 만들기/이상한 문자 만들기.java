class Solution {
    public String solution(String s) {
        
        StringBuilder answer = new StringBuilder();
        int k = 0;
        for(String str : s.split("")){
            if(str.equals(" ")){
                answer.append(str);
                k = 0;
            }else if(k++ % 2 == 0){
                answer.append(str.toUpperCase());
            }else{
                answer.append(str.toLowerCase());
            }

        }
        return answer.toString();
    }
}