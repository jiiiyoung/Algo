import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        /*
        1, 4, 7이 나오면 왼손으로 하고 위치 입력해두기(배열로)
        3, 6, 9이 나오면 오른손으로 하고 위치 입력해두기
        2, 5, 8, 0이 나오면 왼손 오른손 위치를 계산,, dfs?였나,,?
            -> 점수 계산해서 같으면 hand로 입력하기
            -> 적으면 적은 손으로 하기
        */
        
        // 각 키패드의 정보 저장해두기 hashmap에 저장하기
        Map<String, Integer[]> keypads = new HashMap<>();
        String[] temp = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                keypads.put(temp[ (i * 3) + j], new Integer[]{i, j});
            }
        }
        
        // {행(y), 열(x)}
        Integer[] left = keypads.get("*");
        Integer[] right = keypads.get("#");
        
        StringBuilder answer = new StringBuilder();

        
        for(int number : numbers){
            Integer[] keypad = keypads.get(String.valueOf(number));
            String temp2 = "L";

            if(number == 1 || number == 4 || number == 7){
                temp2 = "L";
            }else if(number == 3 || number == 6 || number == 9){
                temp2 = "R";
            }else{
                int countL = counting(left, keypad);
                int countR = counting(right, keypad);
                if(countL == countR){
                    if(hand.equals("right")){
                        temp2 = "R";
                    }
                }else if(countL > countR){
                    temp2 = "R";
                }
            }
            
            answer.append(temp2);

            if(temp2.equals("R")){
                right = keypad; 
            }else{
                left = keypad;
            }
            
            
        }        
        return answer.toString();
    }
    
    int counting(Integer[] location, Integer[] key){
        
        return Math.abs(location[0] - key[0]) + Math.abs(location[1] - key[1]);
    }
}