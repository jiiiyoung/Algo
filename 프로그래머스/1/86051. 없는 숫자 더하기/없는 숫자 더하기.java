import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for(int i = 0; i < 10; i++){
            boolean flag = false;
            for(int j = 0; j < numbers.length;j++){
                if(numbers[j] == i){
                    flag = true;
                }
            }
            if(!flag){
                answer += i;
            }
            
        }
        return answer;
    }
}