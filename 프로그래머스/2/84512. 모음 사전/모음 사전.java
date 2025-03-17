import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> wordArray=new ArrayList<>();
    String[] array= {"A","E","I","O","U"};
    public int solution(String word) {
        int answer = 0;
        generateWord(0,"");
        answer=wordArray.indexOf(word);
        answer++;
        return answer;
    }

    public void generateWord(int length, String wd){
        if(length>5)return;
        if(!wd.isEmpty())wordArray.add(wd);
        for(int i=0; i<5; i++){
            generateWord(length+1, wd+array[i]);
        }
    }
}