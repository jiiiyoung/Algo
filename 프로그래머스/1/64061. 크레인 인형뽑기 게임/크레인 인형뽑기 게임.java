import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        //
        Stack<Integer> stack = new Stack<>();
        
        for(int move : moves){
            for(int i = 0; i < board.length; i++){
                if( board[i][move-1] == 0){
                    continue;
                }

                if(stack.size() != 0){
                    int temp = stack.pop();
                    if(temp == board[i][move-1]){
                        answer += 2;
                    }else{
                        stack.push(temp);
                        stack.push(board[i][move-1]);
                    }
                }else{
                    stack.push(board[i][move-1]);
                }
                board[i][move-1] = 0;
                break;
            }
        }
        
        return answer;
    }
}