import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        // 배열에 평균값 넣기
        int len = score.length;
        int[] answer = new int[len];
        float[] avg = new float[len];
        for(int i = 0; i < len ; i++){
            avg[i] = (float) (score[i][0] + score[i][1]) / 2; 
        }
        
        float[] avgSort = Arrays.copyOf(avg, len);
        Arrays.sort(avgSort);
        for(int i = 0; i < len; i++){
            answer[i] = len - search(avgSort, avg[i]);            
        }

        return answer;
    }
    int search(float[] sortArr, float k){
        for(int i = sortArr.length - 1; i >= 0 ; i--){
            if(sortArr[i] == k){
                return i;
            }
        }
        return -1;
    }
}