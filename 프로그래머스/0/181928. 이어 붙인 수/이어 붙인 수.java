class Solution {
    public int solution(int[] num_list) {
        String odd = "";
        String even = "";

        for (int n : num_list){
            if (n % 2 == 1){
                odd += String.valueOf(n);
            }else{
                even += String.valueOf(n);
            }
        }
        
        
        return Integer.valueOf(odd) + Integer.valueOf(even);
    }
}