class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        int[] len = new int[2];
        for(int i = 0; i < sizes.length; i++){
            w = Math.max(sizes[i][0], sizes[i][1]);                 h = Math.min(sizes[i][0], sizes[i][1]);

            if(w > len[0]){
                len[0] = w;
            }
            if(h > len[1]){
                len[1] = h;
            }
        }
        
        return len[0] * len[1];
    }
}