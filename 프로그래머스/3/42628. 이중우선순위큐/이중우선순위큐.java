import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        char[] operationsArr=new char[operations.length];
        int[] numbersArr=new int[operations.length];
        List<Integer> list = new ArrayList<>();
        //1. 문자열 숫자와 연산기호 분리
        for(int i=0; i< operations.length; i++){
            operationsArr[i]=operations[i].charAt(0); //insert와 delete 저장
            numbersArr[i]=Integer.parseInt(operations[i].substring(2)); //숫자 저장

            if(operationsArr[i]=='I'){
                list.add(numbersArr[i]);
                list.sort(Comparator.reverseOrder()); //내림차순 정렬
            }
            else if(operationsArr[i]=='D' && !list.isEmpty()){
                if(numbersArr[i]==1)list.remove(0);
                if(numbersArr[i]==-1)list.remove(list.size()-1);
            }else{
                continue;
            }
        }

        //3. 리스트가 비어있을 경우 0으로 처리
        if (list.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = list.get(0);
            answer[1] = list.get(list.size() - 1);
        }

        return answer;
    }
}