import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        String[] answer = new String[players.length];
        Map<String, Integer> findIndex = new HashMap<>();
        Map<Integer, String> order = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            findIndex.put(players[i], i);
            order.put(i, players[i]);
        }
        
        for(String calling : callings){
            Integer idx = findIndex.get(calling);
            findIndex.put(calling, idx - 1);
            String beforePlayer = order.get(idx - 1);
            order.put(idx - 1, calling);
            order.put(idx, beforePlayer);
            findIndex.put(beforePlayer, idx);
        }

        for(int i = 0; i < players.length; i++){
            answer[i] = order.get(i);
        }
        
        return answer;
    }
}