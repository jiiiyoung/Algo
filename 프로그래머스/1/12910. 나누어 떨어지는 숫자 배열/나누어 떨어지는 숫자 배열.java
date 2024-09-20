import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {

        int[] multiple = Arrays.stream(arr).filter(num -> num % divisor == 0).toArray();
        
        
        if(multiple.length == 0){
            int[] answer = {-1};
            return answer;
        }
        
        Arrays.sort(multiple);
        return multiple;
    }
}