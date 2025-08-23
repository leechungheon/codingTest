class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int largest=0;
        int []smallArr=new int[sizes.length];
        for(int i=0; i<sizes.length; i++){
            for(int j=0; j<sizes[i].length; j++){
                if(largest<=sizes[i][j])largest=sizes[i][j];
            }
        }
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]>=sizes[i][1]){
                smallArr[i]=sizes[i][1];
            }else{
                smallArr[i]=sizes[i][0];
            }
        }
        int largestSmallArr=0;
        for(int i=0; i<smallArr.length; i++){
            if(smallArr[i]>=largestSmallArr)largestSmallArr=smallArr[i];
        }
        answer=largest*largestSmallArr;
        return answer;
    }
}