class Solution {
    public int[] solution(int n, int s) {//2,9
        int[] answer = {};
        if(n>s){
            answer=new int[1];
            answer[0]=-1;
            return answer;
        }
        int rest=s%n;
        int time=s/n;
        answer=new int[n];
        for(int i=0; i<n; i++){
            answer[i]=time;
        }
        for(int j=0; j<rest; j++){
            answer[n-1-j]++;
        }
        return answer;
    }
}