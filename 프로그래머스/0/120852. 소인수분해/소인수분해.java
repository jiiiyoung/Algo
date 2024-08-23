import java.util.*;

class Solution {
    public int[] solution(int n) {
        boolean[] isPrime = eratosthenes(n);
        List<Integer> factor = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(isPrime[i] == true && n % i == 0){
                factor.add(i);
            }
        }
        int[] answer = factor.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    public boolean[] eratosthenes(int n){
        boolean[] check = new boolean[n+1];
        Arrays.fill(check, true);
        
        for(int i = 2; i <= n; i++){
            if(check[i] == false){
                continue;
            }
            for(int j = 2 * i; j <= n + 1; j += i){
                if(n % i != 0){
                    break;
                }
                check[j] = false;

            }
        }
        return check;
    }
}