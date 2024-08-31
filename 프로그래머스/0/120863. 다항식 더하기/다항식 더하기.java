import java.util.*;

class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int c = 0;
        for(String term : polynomial.split(" [+] ")){
            int len = term.length();
            if(term.charAt(len-1) == 'x'){
                x += (len == 1) ? 1 : Integer.parseInt(term.substring(0, len-1));
            }else{
                c += Integer.parseInt(term);
            }
        }
        StringBuilder result = new StringBuilder();
        if(x == 1){
            result.append("x");
        }else if(x > 1){
            result.append(x + "x");
        }
        
        if(c != 0){
            if(result.length() == 0){
                result.append(c);
            }else{
                result.append(" + " + c);
            }
        }
        return result.toString();
        }
}