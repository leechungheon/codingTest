class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1]=1; //home
        for(int i=0; i<m+1; i++){
            dp[0][i]=0;
        }
        for(int i=0; i<n+1; i++){
            dp[i][0]=0;
        }

        boolean[][] isPuddle = new boolean[n+1][m+1];
        for(int i=0; i<puddles.length; i++){
            isPuddle[puddles[i][1]][puddles[i][0]]=true;
        }
        //dp
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(!isPuddle[i][j]){
                    if(!isPuddle[i][j-1])dp[i][j]+=dp[i][j-1];
                    if(!isPuddle[i-1][j])dp[i][j]+=dp[i-1][j];
                    dp[i][j]%=1000000007;
                }else{
                    dp[i][j]=0;
                }
            }
        }
        answer=dp[n][m];
        
        return answer;
    }
}