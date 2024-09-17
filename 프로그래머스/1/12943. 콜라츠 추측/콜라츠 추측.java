class Solution {
    public int solution(int num) {
        int answer = 0;
        long temp = num;
        while(temp != 1){
            if(answer > 500){
                return -1;
            }
            answer++;
            if(temp % 2 == 0){
                temp /= 2L;
            }else{
                temp = temp * 3L + 1L;
            }
        }
        
        return answer;
    }
}