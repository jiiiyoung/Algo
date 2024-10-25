import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        /*
        1. hashMap<맞은 개수, 등수>
        2. lottos와 win_nums를 정렬해서 비교
        3. lottos가 win_nums보다 크면 win_nums 넘겨서 확인
           반대로 win_nums가 lottos보다 크면 lottos 넘겨서 확인
        4. 숫자를 판단하여서 0의 개수를 빼고 더해 최저 등수와 최고 등수를 찾는다..
        */
        
        Map<Integer, Integer> grade = new HashMap<>();
        
        int count = 6;
        for(int i = 0; i <= 6; i++){
            grade.put(i, count--);
            if(i == 0){
                count++;
            }
        }
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int zero = 0;
        for(int lotto : lottos){
            if(lotto == 0){
                zero++;
            }else{
                break;
            }
        }
        
        int score = 0;
        int lottoStart = zero;
        int winStart = 0;
        while(lottoStart < 6){
            if(winStart == 6){
                lottoStart++;   
            }else if(lottos[lottoStart] == win_nums[winStart]){
                score++;
                lottoStart++;
                winStart++;
            }else if(lottos[lottoStart] > win_nums[winStart]){
                winStart++;
            }else{
                lottoStart++;
            }
        }
        System.out.println(Arrays.toString(lottos));
        System.out.println(Arrays.toString(win_nums));
        System.out.println("lotto : " + lottoStart + " winStart : " + winStart);
        int[] answer = {grade.get(score + zero), grade.get(score)};
        return answer;
    }
}