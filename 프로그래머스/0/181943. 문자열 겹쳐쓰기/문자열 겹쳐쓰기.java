class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder result = new StringBuilder();
        
        for(int k = 0; k < my_string.length(); k++){
            if(k >= s && k - s < overwrite_string.length() ){
                result.append(overwrite_string.charAt(k-s));
            }else{
                result.append(my_string.charAt(k));
            }
        }
        
        return result.toString();
            
        
    }
}