import java.util.*;

class Solution {
    static List<String> list=new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        char[] words={'A','E','I','O','U'};
        generateWords(words, "");
        Collections.sort(list);

        Map<String, Integer> map=new HashMap<>();
        for(int i=0; i<list.size(); i++){
            map.put(list.get(i),i);
        }
        answer=map.get(word);
        return answer;
    }
    public void generateWords(char[] words, String currentWord){
        if(currentWord.length()>words.length)return;
        list.add(currentWord);
        for(int i=0; i<words.length; i++){
            generateWords(words,currentWord+words[i]);
        }
    }
}