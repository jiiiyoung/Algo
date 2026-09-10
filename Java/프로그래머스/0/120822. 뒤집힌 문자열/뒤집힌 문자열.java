class Solution {
    public String solution(String my_string) {
        int i = 0;
        int len = my_string.length();
        
        String[] answer = new String[len];
        for(String s : my_string.split("")){
            answer[len - i - 1] = s;
            i++;
        }
        
        return String.join("", answer);
    }
}