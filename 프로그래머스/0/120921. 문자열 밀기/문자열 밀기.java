class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        if(A.equals(B)){
            answer = 0;
        }else{
            for(int i = 0; i < A.length(); i++){
                A = rotation(A);
                if(A.equals(B)){
                    answer = i + 1;
                    break;
                }
            }
        }
        
        
        
        
        return answer;
    }
    
    String rotation(String str){
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        sb.append(String.valueOf(str.charAt(len -1)));
        for(int i = 0; i < len-1; i++){
            sb.append(String.valueOf(str.charAt(i)));
        }
        return sb.toString();
    }
    
}