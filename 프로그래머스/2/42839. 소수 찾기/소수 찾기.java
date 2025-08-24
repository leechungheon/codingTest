import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {

        int[] number = new int[numbers.length()];
        boolean[] used = new boolean[number.length];
        String combineNumStr="";

        //1.하나씩 쪼개기
        for(int i=0; i<numbers.length(); i++){
            number[i]= numbers.charAt(i)-'0';
            System.out.println("number : "+number[i]);
        }
        generateCombineNumbers(combineNumStr, number, used);
        List<Integer> list=new ArrayList<>(set);
        for(int i=0; i<list.size(); i++){
            isPrime(list.get(i));
        }

        return answer;
    }
    public static void generateCombineNumbers(String combineNumStr,int[] number, boolean[] used){
        if(!combineNumStr.isEmpty()){
            set.add(Integer.parseInt(combineNumStr));
        }
        if(combineNumStr.length()==number.length){
            return;
        }
        for(int i=0; i<number.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            generateCombineNumbers(combineNumStr + number[i],number,used);
            used[i] = false; // 백트래킹
        }
    }
    public static void isPrime(int a){
        if(a==1)return;
        if(a==2){
            answer++;
            return;
        }
        if(a%2==0)return;
        for(int i=3; i<a; i+=2){
            if(a%i==0)return;
        }
        System.out.println(a);
        answer++;
    }
}