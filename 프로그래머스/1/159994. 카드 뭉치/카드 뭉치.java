class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int j = 0;
        boolean flag = true;
        for(String word : goal){
            if((i < cards1.length) && cards1[i].equals(word)){
                i++;
            }else if((j < cards2.length) && cards2[j].equals(word)){
                j++;
            }else{
                flag = false;
                break;
            }
        }        
        String answer = (flag) ? "Yes" : "No";
        return answer;
    }
}