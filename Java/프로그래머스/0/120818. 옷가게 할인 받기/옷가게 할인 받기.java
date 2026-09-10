class Solution {
    public int solution(int price) {
        double discount = 0.0; 

        if (price >= 500000) {
            discount = 20.0;
        }else if (price >= 300000){
            discount = 10.0;
        } else if( price >= 100000) {
            discount = 5.0;
        }

        return (int) (price * (1 - discount/100));
           
    }
}