import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map= new HashMap();
        for(int i=0; i<participant.length; i++){
            if(map.get(participant[i])!=null){
                int n=map.get(participant[i])+1;
                map.put(participant[i],n);
            }else{
                map.put(participant[i],1);
            }
        }
        for(int i=0; i<completion.length; i++){
            int n=map.get(completion[i])-1;
            map.put(completion[i], n);
        }
        for(int i=0; i<participant.length; i++){
            if(map.get(participant[i])==1){
                answer=participant[i];
                break;
            }
        }
        return answer;
    }
}