class Solution {
    public int solution(int number, int limit, int power) {
        int result = 1;
        for(int i = 2; i <= number; i++){
            int temp = divisor(i);
            if(temp > limit){
                temp = power;
            }
            result += temp;
        }
        
        
        return result;
    }
    
    int divisor(int num){
        int ret = 2;
        
        for(int i = 2; i <= num / 2; i++){
            ret += (num % i == 0) ? 1 : 0;
        }
        
        return ret;
    }
}