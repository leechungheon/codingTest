import java.util.*;
import java.io.*;
class Main
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][10];
        
        for(int i=0; i<10; i++) {
        	dp[1][i] = 1;
        }
        
        for(int i=2; i<=N; i++) {
        	for(int j=0; j<=9; j++) {
        		if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10007;
        	}
        }
        
        for(int i=0; i<=9; i++) {
        	answer+=dp[N][i] % 10007;
        }
        System.out.print(answer % 10007);
	}
}