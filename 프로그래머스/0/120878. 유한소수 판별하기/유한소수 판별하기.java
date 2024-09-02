class Solution {
    public int solution(int a, int b) {
        int gcd = getGCD(a, b);
        int denom = b / gcd;
        if(primeCheck(denom)){
            return 1;
        }
        return 2;
    }
    int getGCD(int x, int y){
        if(x > y){
            int temp = x;
            x = y;
            y = temp;
        }
        while(x != 0){
            int rep = y % x;
            y = x;
            x = rep;
        }
        return y;
    }
    boolean primeCheck(int k){
        int rep = 0;
        while(rep == 0 && k != 1){
            if(k % 2 == 0){
                k /= 2;
            }else if(k % 5 == 0){
                k /= 5;
            }else{
                rep = k;
            }
        }
        if(rep == 0){
            return true;
        }
        return false;
    
    }
}