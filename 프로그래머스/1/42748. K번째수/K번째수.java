import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        for(int x = 0; x < len; x++){
            int i = commands[x][0] - 1;
            int j = commands[x][1] - 1;
            int k = commands[x][2] - 1;
            int idx = 0;
            int[] temp = new int[j - i + 1];
            for(int y = i; y <= j; y++){
                 temp[idx++] = array[y];
            }
            Arrays.sort(temp);
            answer[x] = temp[k];
        }
        return answer;
    }
}