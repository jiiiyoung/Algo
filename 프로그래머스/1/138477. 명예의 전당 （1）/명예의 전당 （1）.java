import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        Integer[] arr = new Integer[score.length];
        Arrays.fill(arr, 0);
        int[] answer = new int[score.length];
        int idx = 0;
        for(int i = 0; i < score.length;i++ ){
            if(i < k){
                arr[i] = score[i];
                Arrays.sort(arr, (o1, o2) -> o2 - o1);
                answer[i] = arr[idx++];
            }else{
                arr[i] = score[i];
                Arrays.sort(arr, (o1, o2) -> o2 - o1);
                answer[i] = arr[k-1];
            }
            
        }
        
        return answer;
    }
}