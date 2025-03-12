import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); //오름차순 정렬
        int max = citations[citations.length-1]; //최대값

        for(int index=0; index<=max; index++){ //index H
            int up = 0;
            for(int j=0; j<citations.length; j++){ //index 비교
                if(citations[j] >= index){ //H번 이상 인용된 논문 수
                    up++;
                }
            }

            if(up >= index){ //H번 이상 인용된 논문 수가 H번 이상이고 나머지 논문 수가 H번 이하일 때
                answer = Math.max(answer, index);
            }
        }
        return answer;
    }
}