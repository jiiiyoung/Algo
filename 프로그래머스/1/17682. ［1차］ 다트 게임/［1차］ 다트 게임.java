import java.util.*;

class Solution {
    public int solution(String dartResult) {
        
        /*
        single double triple
        1. 숫자로 나누기
        2. *이 나오면 현재 점수와 이전 점수 *2
        3. #이 나오면 현재 점수만 -1하기
        */
        
        Map<Character, Integer> bonus = new HashMap<>();
        bonus.put('S', 1);
        bonus.put('D', 2);
        bonus.put('T', 3);
               
        int answer = 0;
        String[] calcurator = dartResult.split("[0-9]");
        
        String[] score = dartResult.replaceAll("[a-zA-Z]", ",").replaceAll("[*#]", "").split(",");
        
        int currentScore = 0;
        int beforeScore = 0;
        
        int[] duStar = new int[3];
        int[] duHash = new int[3];
        String[] dartOption = dartResult.replaceAll("[0-9]", " ").replaceAll("[SDT]", "").split(" ");

        int idx = 1;
        while(idx < dartOption.length){
            if(dartOption.length == 0){
                break;
            }
            if(dartOption[idx].equals("*")){
                duStar[idx-1]++;
                if(idx > 1){
                    duStar[idx-2]++;
                }
            }else if(dartOption[idx].equals("#")){
                duHash[idx-1]++;
            }
            idx++;
        }
        
        int i = 0;
        int j = 0;
        while(j < 3){
            if(calcurator[i].length() == 0){
                i++;
                continue;
            }
            currentScore = Integer.parseInt(score[j]);
            currentScore = (int) Math.pow(currentScore, bonus.get(calcurator[i].charAt(0)));
            if(duHash[j] != 0){
                currentScore *= -1 * duHash[j];
            }
            if(duStar[j] != 0){
                currentScore *= 2 * duStar[j];
            }
            answer += currentScore;
            
            i++;
            j++;
        }
            
        return answer;
    }
}