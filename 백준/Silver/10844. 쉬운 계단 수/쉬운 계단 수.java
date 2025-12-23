import java.util.*;
import java.io.*;

class Main
{
	public static void main(String[] args) throws Exception{
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		for(int i = 1; i <= 9; i++) {
		    dp[1][i] = 1;
		}
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0)dp[i][0] = dp[i-1][1]% 1000000000;
				if(j==9)dp[i][9] = dp[i-1][8]% 1000000000;
				if(j!=0 && j!=9) {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])% 1000000000;
				}
			}
		}
		
		int total=0;
		for(int i=0; i<=9; i++) {
			total=(total+dp[N][i])% 1000000000;
		}
		System.out.println(total);
	}
}
