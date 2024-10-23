import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        /*
         - 실패율 : 현재 스테이지 개수 / 현재 스테이지 이상인 개수
         - 스테이지에 도달한 유저가 없는 경우 실패율은 0 
        */
        
        // 스테이지 별 실패율<stage, failrate>
        List<Double[]> stageFail = new ArrayList<>();
        
        // 0부터 N+1까지의 스테이지의 실패율
        Double[] fail = new Double[N + 2];
        
        // 현재 스테이지 개수
        int[] stageCnt = new int[N + 2];
        // 현재 스테이지 이상인 개수
        int[] stageUpper = new int[N + 2];
        
        for(int stage : stages){
            stageCnt[stage]++; // 현재 스테이지 개수 세기
        }
        
        int sum = 0;
        for(int i = stageCnt.length - 1; i >= 0; i--){
            sum += stageCnt[i];
            stageUpper[i] = sum;
        }
        
        for(int i = 0; i < N+2 ; i++){
            if(stageUpper[i] == 0){
                fail[i] = 0.0;                
            }else{
                fail[i] = (double) stageCnt[i] / stageUpper[i];
            }
        }
        

        for(int i = 1; i <= N; i++){
            stageFail.add(new Double[]{(double) i, fail[i]});
        }
        
        Collections.sort(stageFail, (o1, o2) ->{
            int result = Double.compare(o2[1], o1[1]);
            if(result == 0){
                result = Double.compare(o1[0], o2[0]);    
            }
            return result;
        });

        int[] answer = new int[N];
        
        for(int i = 0; i < N; i++){
            answer[i] = (int) Math.round(stageFail.get(i)[0]);
        }
        return answer;
    }
}