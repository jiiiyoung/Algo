class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int power = 1;
        
        for (int n : num_list){
            sum += n;
            power *= n;
        }

        return (power < (int)Math.pow(sum, 2)) ? 1 : 0;
    }
}