class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int a = i; a <= j; a++){
            answer += check(a, k);
        }
        return answer;
    }
    int check(int x, int k){
        int count = 0;
        for(char c : String.valueOf(x).toCharArray()){
            if(c == '0' + k){
                count++;
            }
        }
        return count;
    }
}