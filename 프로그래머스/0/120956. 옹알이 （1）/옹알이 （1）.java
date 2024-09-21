class Solution {
    public int solution(String[] babbling) {
        String[] kaArr = {"aya", "ye", "woo", "ma"};
        int cnt = 0;
        for(String bab : babbling){
            for(String ka : kaArr){
                bab = bab.replace(ka, ",");
            }
            bab = bab.replace(",", "");
            if(bab.length() == 0){
                cnt++;
            }            
        }
        return cnt;
    }
}