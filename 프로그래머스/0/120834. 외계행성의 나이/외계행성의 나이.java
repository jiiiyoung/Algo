import java.util.*;

class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder(); 
        String ageS = String.valueOf(age);
        for(char ageC : ageS.toCharArray()){
            char ascii = toAscii(ageC);
            sb.append(String.valueOf(ascii));
        }
        return sb.toString();
    }
    public char toAscii(char c){
        char zero = '0';
        int i = Integer.valueOf(c);
        char result =  (char)(i - (int)zero + 97);
        return result;
    }
}
