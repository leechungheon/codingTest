class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] array=new int[n];
        for(int i=0; i<n ;i++)array[i]=1;
        for(int i=0; i<lost.length; i++)array[lost[i]-1]-=1;
        for(int i=0; i<reserve.length; i++)array[reserve[i]-1]+=1;

        for(int i=0; i<n; i++){
            if(array[i]==0){
                if(i-1>=0 && array[i-1]==2){    //borrowLeft
                    array[i-1]=1;
                    array[i]=1;
                }else if(i+1<n && array[i+1]==2){
                    array[i+1]=1;
                    array[i]=1;
                }
            }
        }
        for(int i:array)if(i>0)answer+=1;
        return answer;
    }
}