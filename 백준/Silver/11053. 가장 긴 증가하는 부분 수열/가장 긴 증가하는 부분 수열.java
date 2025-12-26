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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			int idx = 1;
			dp[i] = 1;
			while(true) {
				if(i-idx<0)break;
				if(arr[i-idx]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[i-idx]+1);
				}
				idx++;
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			pq.offer(dp[i]);
		}
		System.out.println(pq.poll());
	}
}
