class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        /*
        분자 = (numer1 * denom2 + numer2 * denom1) / gcd
        분모 = denom1 * denom2 / gcd
        
        만약 분모의 최대공약수가 있다면 해당 값으로 나눠줘야 한다.        
        -> 최대공약수 구하는 방법.
        */
        int numer = (numer1 * denom2 + numer2 * denom1);
        int denom = denom1 * denom2;
    
        int gcdValue = GCD(numer, denom);
        int[] answer = {numer / gcdValue, denom / gcdValue};        
        
        return answer;
    }
    
    public static int GCD(int a, int b){       
        return (b == 0) ? a : GCD(b, a % b);
    }

    
}

