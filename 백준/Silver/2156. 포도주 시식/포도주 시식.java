import java.util.*;
import java.io.*;

class Main
{
	static int n;
	static int[] wine;
	public static void main(String[] args) throws Exception{
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		wine = new int[n];
		int[] dp = new int[n];
		for(int i=0; i<n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		// logic
		
		dp[0]=wine[0];
		if(n>1)dp[1]=wine[0]+wine[1];
		
		for(int i=2; i<n; i++) {
			int max1 = Math.max(dp[i-1], dp[i-2]+wine[i]);
			if(i==2) {
				max1 = Math.max(max1, wine[i-1]+wine[i]);
			}else {
				max1 = Math.max(max1, dp[i-3]+wine[i-1]+wine[i]);
			}
			dp[i] = max1;
		}
		System.out.println(dp[n-1]);
	}
}
