import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
                
        int[][] direct = {{1, -1, 0, 0},
                          {0, 0, -1, 1}};
        for(int i = 0; i < 4; i++ ){
            int dy = h + direct[0][i];
            int dx = w + direct[1][i];
            
            if(dx < 0 || dy < 0 || dy >= board.length || dx >= board[0].length){
                continue;
            }
            if(color.equals(board[dy][dx])){
                answer++;
            }
            
        }
        
        return answer;
    }
}