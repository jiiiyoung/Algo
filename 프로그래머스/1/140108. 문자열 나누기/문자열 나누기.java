class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int standardCnt = 0;
        int anotherCnt = 0;
        boolean equal = false;
        char standard = s.charAt(0);
        for(char ch : s.toCharArray()){
            if(equal){
                standard = ch;
                standardCnt++;
                equal = false;
                continue;
            }
            if(standard == ch){
                standardCnt++;
            }else{
                anotherCnt++;
            }
            if(standardCnt == anotherCnt){
                answer++;
                standardCnt = 0;
                anotherCnt = 0;
                equal = true;
            }   
        }
        
        if(standardCnt != anotherCnt){
            answer++;
        }
        return answer;
    }
}