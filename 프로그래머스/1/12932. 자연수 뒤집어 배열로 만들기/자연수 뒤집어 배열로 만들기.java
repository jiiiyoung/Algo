class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int len = str.length();
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++){
            answer[i] = Integer.parseInt(str.split("")[len - i - 1]);
        }
        
        return answer;
    }
}