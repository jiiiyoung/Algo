class Solution {
    public int solution(int num1, int num2) {
        boolean valid = !(num1 < -50000 || num1 > 50000 ||num2 < -50000 || num2 > 50000);
        
        if(valid){
            return num1 - num2;
        }
        return -1;
        
    }
}