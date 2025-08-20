import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();

        for(int i : priorities){
            que.add(i);
        }
        //배열의 중요도를 오름차순으로 정리
        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            /*
            현재 꺼낸 문서의 중요도(i)가 현재까지 문서의 수(answer)를
            고려했을 때, 남아있는 문서들 중에서 가장 높은 중요도(priorities[size - answer])와 같은지 확인.
            l 이 offset 이라고 생각하면 편함.
            */
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}