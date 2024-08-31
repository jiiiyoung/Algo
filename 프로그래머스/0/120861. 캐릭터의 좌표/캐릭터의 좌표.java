import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        Map<String, Integer> keyMap = new HashMap<>();
        // up, down, left, right
        int[][] direct = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        keyMap.put("up", 0);
        keyMap.put("down", 1);
        keyMap.put("left", 2);
        keyMap.put("right", 3);
        
        int[] result = {0, 0};
        for(String str : keyinput){
            int x = result[0] + direct[keyMap.get(str)][0];
            int y = result[1] + direct[keyMap.get(str)][1];
            if( (Math.abs(x) > board[0] / 2) || (Math.abs(y) > board[1] / 2) ){
                continue;
            }
            result[0] = x;
            result[1] = y;

        }
        
        return result;
    }
}