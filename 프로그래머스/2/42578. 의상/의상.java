import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> kindOfClothes = new ArrayList<>();
        for(int i=0; i<clothes.length; i++){
            String category=clothes[i][1];
            if(map.containsKey(category)){
                map.put(category,map.get(category)+1);
            }else{
                map.put(category,2);
                kindOfClothes.add(category);
            }
        }
        for(int i=0; i<kindOfClothes.size(); i++){
            answer*=map.get(kindOfClothes.get(i));
        }
        answer--;

        return answer;
    }
}