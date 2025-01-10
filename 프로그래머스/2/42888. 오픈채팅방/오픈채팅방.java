import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        String[] answer = new String[record.length];
        String[][] splitRecord=new String[record.length][3];
        Map<String, String> map=new HashMap<>();

        //"Enter uid1234 Muzi"
        for(int i=0; i<record.length; i++){
            splitRecord[i]=record[i].split(" ");
        }

        for(int i=0; i< splitRecord.length; i++){
            if(!splitRecord[i][0].equals("Leave")){
                map.put(splitRecord[i][1],splitRecord[i][2]);
            }
        }
        int j=0;
        for(int i=0; i< splitRecord.length; i++){
            if(!splitRecord[i][0].equals("Change")){ //닉네임 변경이 아니라면
                if(splitRecord[i][0].equals("Enter")){ //Enter
                    result.add(map.get(splitRecord[i][1]) + "님이 들어왔습니다.");
                    //answer[j]=map.get(splitRecord[i][1])+"님이"+" "+"들어왔습니다.";
                }else{ //Leave
                    result.add(map.get(splitRecord[i][1]) + "님이 나갔습니다.");
                    //answer[j]=map.get(splitRecord[i][1])+"님이"+" "+"나갔습니다.";
                }
                //j++;
            }
        }
        return result.toArray(new String[0]);
    }
}