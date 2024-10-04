import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> sum = new TreeSet<>();
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                sum.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[sum.size()];
        int i = 0;
        for(int s : sum){
            answer[i++] = s;
        }
        
        return answer;
    }
}