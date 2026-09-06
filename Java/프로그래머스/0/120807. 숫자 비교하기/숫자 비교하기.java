class Solution {
    public int solution(int num1, int num2) {
        boolean valid = !(num1 < 0 || num1 > 10000 || num2 < 0 || num2 > 10000);
        boolean result = num1 == num2;
        
        if (valid) return result ? 1 : -1;
        
        return 0;
    }
}