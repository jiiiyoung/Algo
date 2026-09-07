class Solution {
    public int solution(int num1, int num2) {
        boolean valid = !(num1 <= 0 || num1 > 100 || num2 <= 0 || num2 > 100);
        
        if (valid) {
            return num1 % num2;
        }

        return -1;
    }
}