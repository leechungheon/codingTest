import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(list1.get(list1.size() - 1)!=arr[i]){
                list1.add(arr[i]);
            }
        }
        int[] answer = new int[list1.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=list1.get(i);
        }
        return answer;
    }
}