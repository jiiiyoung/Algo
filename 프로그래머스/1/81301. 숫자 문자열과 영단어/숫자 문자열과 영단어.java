import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> numbers = new HashMap<>();
        numbers.put("zero", "0");
        numbers.put("one", "1");
        numbers.put("two", "2");
        numbers.put("three", "3");
        numbers.put("four", "4");
        numbers.put("five", "5");
        numbers.put("six", "6");
        numbers.put("seven", "7");
        numbers.put("eight", "8");
        numbers.put("nine", "9");
        
        for(String key : numbers.keySet()){
            s = s.replaceAll(key, numbers.get(key));
        }

        return Integer.parseInt(s);
    }
}