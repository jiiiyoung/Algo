class Solution {
    public String solution(int a, int b) {
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weeks = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int days = b;
        for(int i = 1; i < a; i++){
            days += month[i-1];
        }
        
        String answer = weeks[(days - 1) % 7];
        
        
        return answer;
    }
}