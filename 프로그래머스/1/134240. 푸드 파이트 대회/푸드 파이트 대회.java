class Solution {
    public String solution(int[] food) {
        
        StringBuilder foodFight = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            int r = food[i] / 2;
            foodFight.append(String.valueOf(i).repeat(r));
        }
        StringBuilder answer = new StringBuilder();
        answer.append(foodFight);
        answer.append("0" + foodFight.reverse());
        return answer.toString();
    }
}