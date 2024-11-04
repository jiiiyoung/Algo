class Solution {
    public int solution(int[] ingredient) {
        StringBuilder hamburger = new StringBuilder();
        int answer = 0;
        
        for(int i = 0; i < ingredient.length; i++){
            hamburger.append(String.valueOf(ingredient[i]));
            if(hamburger.length() >= 4){
                String temp = hamburger.substring(hamburger.length() - 4, hamburger.length());
                if(temp.equals("1231")){
                    answer++;
                    hamburger.replace(hamburger.length() - 4, hamburger.length(), "");
                }
            }
        }
        
        return answer;
    }
}