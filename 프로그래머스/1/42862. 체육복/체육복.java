import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Map<Integer, Integer> clothes = new TreeMap<>();
        
        Arrays.sort(lost);
        
        for(int cloth : reserve){
            clothes.put(cloth, clothes.getOrDefault(cloth, 0) + 1);
        }


        for(int i = 0; i < lost.length ; i++){    
            int temp = clothes.getOrDefault(lost[i], 0);
            if(temp != 0){
                clothes.put(lost[i], temp - 1);
                lost[i] = -1;
            }
            
        }
        for(int lostNumber : lost){
            if(lostNumber == -1){
                continue;
            }
            int temp = clothes.getOrDefault(lostNumber - 1, 0);
            if(temp != 0){
                clothes.put(lostNumber -1, temp - 1);
            }else{
                clothes.put(lostNumber + 1, clothes.getOrDefault(lostNumber + 1, 0) - 1);
            }
        }
        
        
        for(Integer value : clothes.values()){
            if(value < 0){
                answer += value;
            }
        }
        
        return answer;
    }
}