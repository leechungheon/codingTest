import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String[]> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[words.length];
        queue.add(new String[]{begin, "0"});

        while(!queue.isEmpty()){
            String[] str=queue.poll();

            if(str[0].equals(target)){
                return Integer.parseInt(str[1]);
            }
            for(int i=0; i<words.length; i++){
                if(!isVisited[i] && isConvertible(str[0],words[i])){
                    begin=words[i];
                    isVisited[i]=true;
                    int cnt=Integer.parseInt(str[1]);
                    cnt++;
                    String cntStr=String.valueOf(cnt);
                    queue.add(new String[]{begin,cntStr});
                }
            }
        }
        return answer;
    }

    public boolean isConvertible(String begin, String words){
        char[] beginArr=begin.toCharArray();
        char[] wordsArr=words.toCharArray();
        int len=begin.length();
        int cnt=0;
        for(int i=0; i<len; i++){
            if(beginArr[i]!=wordsArr[i])cnt++;
        }
        return cnt == 1;
    }
}