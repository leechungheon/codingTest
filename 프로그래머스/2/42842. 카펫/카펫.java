class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int blocks=brown+yellow;
        int sero,garo;
        for(int i=3; i<=blocks/2; i++){
            if(blocks%i==0){
                sero=i;
                garo=blocks/i;
                if((garo-2)*(sero-2)==yellow){
                    answer[0]=sero;
                    answer[1]=garo;
                }
            }
        }
        return answer;
    }
}