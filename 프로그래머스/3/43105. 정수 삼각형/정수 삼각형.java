import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }
        for(int i=0; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                dp[i][j]=triangle[i][j];
            }
        }
        //왼쪽과 오른쪽 변부터 계산
        for(int i=1; i<triangle.length; i++){
            dp[i][0]+=dp[i-1][0];
            dp[i][triangle[i].length-1]+=dp[i-1][triangle[i-1].length-1];
        }
        //왼쪽과 오른쪽 변을 제외한 나머지 계산
        for(int i=1; i<triangle.length; i++){
            for(int j=1; j<triangle[i].length-1; j++){
                dp[i][j]+=Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
        }
        for(int i=0; i<triangle[triangle.length-1].length; i++){
            answer=Math.max(answer,dp[triangle.length-1][i]);
        }
        return answer;
    }
}