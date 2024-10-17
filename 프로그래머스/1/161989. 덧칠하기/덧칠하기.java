class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        int endpoint = section[0] + m - 1;
        for(int current : section){
            if(current > endpoint){
                answer++;
                endpoint = current + m - 1;
            }
        }
        
        return answer;
    }
}