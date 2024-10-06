import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        /*
        n번째 숫자를 key로 해서 TreeMap에 저장
        거기에 저장한 값은, ArrayList로 저장,
        ArrayList를 꺼낼 때 정렬해서!
        */
        Map<Character, List<String>> arr = new TreeMap<>(); 
        
        for(String str : strings){
            char key = str.charAt(n);
            
            if(arr.containsKey(key)){
                List<String> value = arr.get(key);
                value.add(str);
                arr.put(key, value);
            }else{
                List<String> value = new ArrayList<>();
                value.add(str);
                arr.put(key, value);
            }
            
        }
        List<String> answer = new ArrayList<>();
        for(Map.Entry<Character, List<String>> entry : arr.entrySet()){
            List<String> temp = entry.getValue();
            temp.sort((a, b) -> {
                return a.compareTo(b);
            });
            answer.addAll(temp);

        }

        
        return answer.toArray(new String[answer.size()]);
    }
}