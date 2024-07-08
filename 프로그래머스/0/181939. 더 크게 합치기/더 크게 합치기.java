class Solution {
    public int solution(int a, int b) {
        
        int plus1 = Integer.parseInt("" + a + b);
        int plus2 = Integer.parseInt("" + b + a);

        int answer = (plus1 > plus2) ? plus1 : plus2;
        
        return answer;
    }
}