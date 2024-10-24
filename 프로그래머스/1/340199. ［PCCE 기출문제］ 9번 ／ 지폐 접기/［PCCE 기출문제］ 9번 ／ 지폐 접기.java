class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(!check(wallet, bill)){
            if(rotation(wallet, bill)){
                break;
            }
            
            if(bill[0] > bill[1]){
                bill[0] = bill[0] / 2;
            }else{
                bill[1] = bill[1] / 2;
            }
            answer++;
            
            
        }
        
        return answer;
    }
    
    boolean rotation(int[] wallet, int[] bill){
        if(wallet[0] < bill[1] || wallet[1] < bill[0]){
            return false;
        }
        return true;
    }
    
    boolean check(int[] wallet, int[] bill){
        if(wallet[0] < bill[0] || wallet[1] < bill[1]){
            return false;
        }
        return true;
    }
}