import java.util.*;
import java.io.*;

class Main
{
	static int n;
	static int[] wine;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] dpAsc = new int[n];
		int[] dpDesc = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// logic
		for(int i=0; i<n; i++) {
			int idx = 1;
			dpAsc[i] = 1;
			while(true) {
				if(i-idx<0)break;
				if(arr[i-idx]<arr[i]) {
					dpAsc[i] = Math.max(dpAsc[i], dpAsc[i-idx]+1);
				}
				idx++;
			}
		}
		for(int i=n-1; i>=0; i--) {
			int idx = 1;
			dpDesc[i] = 1;
			while(true) {
				if(i+idx>=n)break;
				if(arr[i+idx]<arr[i]) {
					dpDesc[i] = Math.max(dpDesc[i], dpDesc[i+idx]+1);
				}
				idx++;
			}
		}
		for(int i=0; i<n; i++) {
			PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> right = new PriorityQueue<>(Collections.reverseOrder());
			for(int j=0; j<i; j++) { // 바이토닉 수열 중심의 왼쪽
				if(arr[j]<arr[i])left.offer(dpAsc[j]);
			}
			for(int j=n-1; j>i; j--) {
				if(arr[j]<arr[i])right.offer(dpDesc[j]);
			}
			int leftTop=0;
			int rightTop=0;
			if(!left.isEmpty())leftTop=left.poll();
			if(!right.isEmpty())rightTop=right.poll();
			max = Math.max(max, leftTop+rightTop);
		}
		System.out.println(max+1);
	}
}
