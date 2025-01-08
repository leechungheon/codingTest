class Solution {
    public String solution(int n, int t, int m, int p) {
        //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.
        StringBuilder answer= new StringBuilder();
        StringBuilder s = new StringBuilder();
        int point=p-1;
        int i=0;
        while(answer.length()<t) {
            //인원 수 만큼 한싸이클 추가
            for(int j=0; j<m; j++) {
                s.append(Integer.toString(i, n).toUpperCase());
                i++;
            }
            answer.append(s.charAt(point));
            point+=m;
        }

        return answer.toString();
    }
}