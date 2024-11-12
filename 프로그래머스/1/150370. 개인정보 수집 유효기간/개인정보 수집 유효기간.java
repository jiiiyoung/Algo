import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> type = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < terms.length; i++){
            String key = terms[i].split(" ")[0];
            Integer value = Integer.parseInt(terms[i].split(" ")[1]);
            type.put(key, value);
        }
        
        for(int i = 0; i < privacies.length; i++){
            String expiration = plusDate(privacies[i].substring(0, 10), type.get(privacies[i].substring(11)));
            if(checkExpire(today, expiration)){
                result.add(i + 1);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    boolean checkExpire(String date, String expiration){
        
        int yearDiff = Integer.valueOf(date.substring(0, 4)) - Integer.valueOf(expiration.substring(0, 4));
        int monthDiff = Integer.valueOf(date.substring(5, 7)) - Integer.valueOf(expiration.substring(5, 7));
        int dayDiff = Integer.valueOf(date.substring(8)) - Integer.valueOf(expiration.substring(8));

        if(yearDiff < 0){
            return false;
        }else if(yearDiff == 0 && monthDiff < 0){
            return false;
        }else if(yearDiff == 0 && monthDiff == 0 && dayDiff < 0){
            return false;
        }
        return true;
    }
    
    String plusDate(String date, Integer term){
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8));
        
        month += term;
        if(month > 12){
            year += (month - 1) / 12 ;
            month =  (month % 12 == 0) ? 12 : month % 12;
        }
        String m = "";
        if(month < 10){
            m = "0";
        }
        
        String d = "";
        if(day < 10){
            d = "0";
        }
        return year + "." + m + month + "." + d + day;
    }
}