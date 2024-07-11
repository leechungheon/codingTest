import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id=modify1(new_id);     // 소문자로 변환
        new_id=modify2(new_id);     // 타문자 제거
        new_id=modify3(new_id);   // 연속된 마침표 단일치환
        new_id=modify4(new_id);   // 처음, 끝 마침표 제거
        new_id=modify5(new_id);   // 빈문자열 a 대입
        new_id=modify6(new_id);   // 16자 이상 제거
        new_id=modify7(new_id);   // 3자 이상 늘리기
        answer=new_id;
        return answer;
    }
    public String modify1(String new_id){
        new_id=new_id.toLowerCase();
        return new_id;
    }
    public String modify2(String new_id) {
        char[] array = new_id.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (!(array[i] >= 'a' && array[i] <= 'z') &&
                    !(array[i] >= '0' && array[i] <= '9') &&
                    array[i] != '-' && array[i] != '.' && array[i] != '_') {
                array[i] = ' ';
            }
        }
        StringBuilder new_id2 = new StringBuilder();
        for (char c : array) {
            if (c != ' ') {
                new_id2.append(c);
            }
        }
        return new_id2.toString();
    }
    public String modify3(String new_id){
        String new_id2="";
        for(int i=0; i<new_id.length(); i++){
            if(i!=0 && new_id.charAt(i-1)=='.' && new_id.charAt(i)=='.'){

            }else{
                new_id2+=new_id.charAt(i);
            }
        }
        return new_id2;
    }
    public String modify4(String new_id){
        if(new_id.charAt(0)=='.'){
            if(new_id.length()!=1)new_id=new_id.substring(1);
            else{
                new_id="";
            }
        }
        if(!new_id.isEmpty() && new_id.charAt(new_id.length()-1)=='.'){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        return new_id;
    }
    public String modify5(String new_id){
        if(new_id.isEmpty()){
            new_id="a";
        }
        return new_id;
    }
    public String modify6(String new_id){
        if(new_id.length()>15){
            new_id=new_id.substring(0,15);
        }
        if(new_id.charAt(new_id.length()-1)=='.'){
            new_id=new_id.substring(0,14);
        }
        return new_id;
    }
    public String modify7(String new_id){
        if(new_id.length()<3){
            while(new_id.length()<3){
                new_id+=new_id.charAt(new_id.length()-1);
            }
        }
        return new_id;
    }
}