import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);//오름차순 정렬
        int left=0;
        int right=people.length-1;
        //1234
        while(left<=right){
            //포인터가 같은 사람을 가리키는 경우 (마지막)
            if(left==right){
                answer++;
                break;
            }
            //두 사람의 몸무게 합이 limit 이하라면
            if(people[left]+people[right]<=limit){
                left++;
                right--;
            }
            else{
                right--;
            }
            answer++;
        }
        return answer;
    }
}