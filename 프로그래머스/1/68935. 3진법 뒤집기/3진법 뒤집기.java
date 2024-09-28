class Solution {
    public int solution(int n) {
        StringBuilder three = new StringBuilder();

        while(n > 0){
            three.insert(0, n % 3);
            n /= 3;
        }
                
        int len = three.length();
        int answer = 0;
        int multi = 1;
        for(String s : three.toString().split("")){
            answer += Integer.parseInt(s) * multi; 
            multi *= 3;
        }
        
        
        return answer;
    }
}