import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static int cnt = 0;
	static int[] dp = new int[1000001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp[1]=1;
		dp[2]=2;
		for(int i=3; i<=N; i++) {
			dp[i]=(dp[i-1]+dp[i-2])%15746;
		}
		System.out.println(dp[N]);
	}
}
