import java.io.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(String str : my_string.split("")){
            int i = 0;
            while (i < n){
                sb.append(str);
                i++;
            }
        }
        
        return sb.toString();
        
        
    }
}