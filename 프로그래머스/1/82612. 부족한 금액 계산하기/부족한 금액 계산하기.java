class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0L;
        long cost = 0L;
        for(long i = 1L; i <= count; i++){
            cost += price * i;
        }
        if(cost > money){
            answer = cost - money;
        }else{
            answer = 0;
        }
        return answer;
    }
}