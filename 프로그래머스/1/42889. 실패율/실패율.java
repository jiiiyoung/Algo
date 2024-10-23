import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        // Double[] = {스테이지, 실패율};
        List<Double[]> failRate = new ArrayList<>();  
        
        // 실패율 계산하기 위해 오름차순으로 정렬
        Arrays.sort(stages);
        
        /*                   i
        1, 2, 2, 2, 3, 3, 4, 6
        1/len, 3/len-1, 2/len-4, 1/len-6, 0/len-7
        현재 숫자와 같은 숫자의 개수 / 현재 숫자 이상인 개수
        */
        int len = stages.length;
        int counting = 0; // 이전 스테이지까지 클리어한 사람 수
        int temp = 0; // 스테이지에 머무르고 있는 사람 수
        int n = stages[0]; // 현재 스테이지
        
        for(int i = 1; i <= len; i++){
            if(stages[i-1] == n){
                temp++;
            }
            if(i == len || stages[i-1] != stages[i]){
                // 실패율 계산하기
                Double rate = (double)temp / (len - counting); 
                System.out.println(n + " " + rate);
                failRate.add(new Double[]{(double) stages[i-1], rate});
                temp = 0;
                counting = i;
                if (i == len) continue;
                n = stages[i];
            }
        }
        
        
        Collections.sort(failRate, (o1, o2) -> {
            // 실패율을 기준으로 내림차순(뒤에가 더 크면 교환)
            int result = Double.compare(o2[1], o1[1]);
            
            if(result == 0){
                // 스테이지 번호를 기준으로 오름차순(앞에가 더 크면 교환)
                result = Double.compare(o1[0], o2[0]);
            }
            
            return result;   
        });

        int[] answer = new int[N];
        int start = failRate.size();

        // 스테이지를 모두 클리어 한 경우는 제외
        if(IntStream.of(stages).anyMatch(num -> num == (N+1))){
            start--;    
        }

        int idx = 0;
        for(int i = 0; i < start; i++){
            // N스테이지까지 실패율 순서로 값 넣기
            if(i < failRate.size() && failRate.get(i)[0] != (N+1)){
                answer[idx++] = Math.round(failRate.get(i)[0]);
            }
            
            // 스테이지에 포함되지 않은 순서는 실패율이 0이므로 오름차순으로 넣기
            int stage = i + 1;
            if(!IntStream.of(stages).anyMatch(num -> num == (stage))){
                answer[start++] = stage;
            }
        }
        
        
        return answer;
    }
}