class Solution {
    public int solution(int chicken) {
        // chicken은 시킨 마리 수
        // coupon은 10마리당 한장, 그리고 한마리를 시키면 service + 1 됨 
        int coupon = chicken;
        int service = 0;
        int answer = 0;
        while(coupon >= 10){
            service = coupon / 10;
            coupon = service + coupon % 10;
            answer += service;
        }
        
        return answer;
    }
}