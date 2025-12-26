import java.util.*;
import java.io.*;

class Main
{
	static int n;
	static int[][] line;
	public static void main(String[] args) throws Exception{
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		line = new int[n][2];
		int[] dp = new int[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(line, (o1, o2) -> {
		    return o1[0] - o2[0];
		});
		for(int i=0; i<n; i++) {
			dp[i]=1;
			int offset=1;
			while(true) {
				if(i-offset<0)break;
				if(line[i][1]>line[i-offset][1])dp[i]=Math.max(dp[i], dp[i-offset]+1);
				offset++;
			}
		}
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			pq.offer(dp[i]);
		}
		System.out.println(n-pq.poll());
	}
}
