class Solution {
    static int result = 0;
    static int[] prime = new int[1000 * 3 - 1];

    public int solution(int[] nums) {

        boolean[] visit = new boolean[nums.length];

        dfs(nums, visit, 0, 0, 0);
        
        return result;
    }
    
    void dfs(int[] nums, boolean[] visit, int level, int sum, int idx){
        if(level == 3){
            if(prime[sum] == 0){
                result += check(sum);
            }else if(prime[sum] == 1){
                result += 1;
            }
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visit[i] == true){
                return;
            }
            visit[i] = true;
            dfs(nums, visit, level + 1, sum + nums[i], i);
            visit[i] = false;
        }
        return;
    }
    
    int check(int sum){
        if(prime[sum] == 0){ // -1인 경우 0을 보내기 때문
            for(int i = 2; i <= Math.sqrt(sum); i++){
                if(sum % i == 0){
                    prime[sum] = -1;
                    return 0;
                }
            }
            prime[sum] = 1;
            return 1;
        }
        return 0;
    }
}