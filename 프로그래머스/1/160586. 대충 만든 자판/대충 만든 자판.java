import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        /*
        targets을 먼저 key로 하고 중복값은 value를 +1 한다.
        String.indexOf(target)으로 keymap에서 찾아서 value와 곱한 후 answer에 더한다.
        */
        int LEN = targets.length;

        int[] answer = new int[LEN];
        
        for(int i = 0; i < LEN; i++){
            Map<Character, Integer> targetCnt = new HashMap<>();           
            String target = targets[i];
            
            // 타겟의 글자 수 세기
            for(char ch : target.toCharArray()){
                targetCnt.put(ch, targetCnt.getOrDefault(ch, 0) + 1);
            }
            
            // 글자 포함 세기
            int count = 0;
            for(Map.Entry<Character, Integer> entry : targetCnt.entrySet()){
                int temp = search(entry.getKey(), keymap);
                if(temp == -1){
                    count = -1;
                    break;
                }else{
                    count += temp * entry.getValue();
                }
            }
            
            answer[i] = count;
        }
                
        return answer;
    }
    int search(Character ch, String[] keymap){
        int min = 100;
        boolean flag = false;
        for(int i = 0; i < keymap.length ; i++){
            int index = keymap[i].indexOf(ch);
            if(index != -1){
                min = Math.min(min, index);
                flag = true;
            }
        }
        if(flag){
            return min + 1;
        }
        return -1;
    }
}