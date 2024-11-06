import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> field = new HashMap<>();
        List<int[]> answer = new ArrayList<>();
        String[] fieldName = {"code", "date", "maximum", "remain"};
        for(int i = 0; i < 4; i++){
            field.put(fieldName[i], i);
        }
        int idx = field.get(ext);
        for(int i = 0; i < data.length ; i++){
            if(data[i][idx] < val_ext){
                answer.add(data[i]);
            }
        }
        
        int[][] result = new int[answer.size()][4];
        
        for(int i = 0; i < answer.size() ; i++){
            result[i] = answer.get(i);
        }
        
        Arrays.sort(result, (o1, o2) -> o1[field.get(sort_by)] - o2[field.get(sort_by)]);
        
        return result;
    }
}