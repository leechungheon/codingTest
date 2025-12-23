import java.util.*;
import java.io.*;

class Main
{
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][N];
		int[][] dp = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				array[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=array[0][0];
		// logic
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<=i; j++) {
				int current = dp[i][j];
				dp[i+1][j] = Math.max(dp[i+1][j], current+array[i+1][j]);
				dp[i+1][j+1] = Math.max(dp[i+1][j+1], current+array[i+1][j+1]);
			}
		}
		
		// output
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[N-1][i]);
		}
		System.out.println(max);
	}
}
