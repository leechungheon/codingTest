import java.util.*;
import java.io.*;

class Main
{
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		dp[0]=array[0];
		max = dp[0];
		for(int i=1; i<N; i++) {
			dp[i]=Math.max(array[i], array[i]+dp[i-1]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
