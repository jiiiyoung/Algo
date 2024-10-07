import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            StringBuilder temp1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder temp2 = new StringBuilder(Integer.toBinaryString(arr2[i]));
            
            temp1.insert(0, "0".repeat(n - temp1.length()));
            temp2.insert(0, "0".repeat(n - temp2.length()));

            for(int j = 0; j < n; j++){
                if( (temp1.charAt(j) == '0') && (temp2.charAt(j) == '0')){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}