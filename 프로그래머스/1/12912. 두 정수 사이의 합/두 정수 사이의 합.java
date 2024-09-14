class Solution {
    public long solution(int a, int b) {
        if(a > b){
            int temp = b;
            b = a;
            a = temp;
        }
        long answer = b;
        for(int i = a; i < b; i++){
            answer += i;
        }
        
        return answer;
    }
}