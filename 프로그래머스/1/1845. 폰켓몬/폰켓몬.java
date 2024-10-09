import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        
        for(int num : nums){
            hash.add(num);
        }
        int answer = nums.length / 2 ;
        
        if(answer > hash.size()){
            answer = hash.size();
        }

        return answer;
    }
}