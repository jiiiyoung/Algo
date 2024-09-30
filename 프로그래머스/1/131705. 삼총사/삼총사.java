class Solution {
    public int solution(int[] number) {
        int count = 0;
        
        for(int i = 0; i < number.length - 2; i++){
            int check = 0;
            for(int j = i + 1; j < number.length - 1; j++){
                for(int k = j + 1; k < number.length; k++){
                    check = number[i] + number[j] + number[k];
                    
                    if(check == 0){
                        count++;
                    }
                    
                }
            }
        }
        
        return count;
    }
}