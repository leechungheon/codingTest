import java.util.*;
import java.io.*;

class Main
{
	static int[][][] dp = new int[51][51][51];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==-1 && b==-1 && c==-1)break;
			int result = w(a,b,c);
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	public static int w(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0)return 1;
		if(dp[a][b][c]==0) {
			if(a>20 || b>20 || c>20) {
				dp[20][20][20] = w(20,20,20);
				return dp[20][20][20];
			}
			if(a<b && b<c) {
				dp[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
				return dp[a][b][c];
			}
			dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
			return dp[a][b][c];
		}
		return dp[a][b][c];
	}
}
