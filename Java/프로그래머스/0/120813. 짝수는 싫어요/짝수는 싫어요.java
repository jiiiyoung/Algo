import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        
        
        return IntStream.rangeClosed(1, n).filter(k -> k % 2 == 1).toArray();
        
        
    }
}