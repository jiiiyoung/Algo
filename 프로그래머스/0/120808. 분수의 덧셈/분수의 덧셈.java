class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer3 = numer1 * denom2 + numer2 * denom1;
        int denom3 = denom1 * denom2;
        
        /*
         유클리드 호제법
         a / b 를 한 나머지를 c라고 하면
         b / c를 한다. 
         나머지가 0인 마지막 c가 최대공약수
        */
/*      
        int mod = numer3 % denom3;
        int answer = denom3;
        while(mod != 0){
            int temp = mod;
            mod = answer % mod;
            answer = temp;
        }
*/
        int answer = Euclidean(numer3, denom3);
        int[] result = {numer3 / answer, denom3 / answer};
        return result;
    }

public int Euclidean(int a, int b){
    while(b != 0){
        int mod = a % b;
        a = b;
        b = mod;   
    }
    return a;
}
    
}