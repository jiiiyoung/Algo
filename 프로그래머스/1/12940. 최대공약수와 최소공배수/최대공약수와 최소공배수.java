class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n < m){
            int temp = n;
            n = m;
            m = temp;
        }
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m, answer[0]);
        
        return answer;
    }
    int gcd(int a, int b){
        int c = 1;
        while(b != 0){
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    int lcm(int a, int b, int gcd){
        int temp1 = a / gcd;
        int temp2 = b / gcd;
        return gcd * temp1 * temp2;
    }
}