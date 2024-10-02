class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < s.length();i++){
            int idx = -1;
            for(int j = 0; j < i; j++){
                if(s.charAt(j) == s.charAt(i)){
                    idx = i - j;
                }
            }
            answer[i] = idx;
            
        }
        return answer;
    }
}