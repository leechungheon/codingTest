
import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] answer = new int[N];
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		int cnt=0;
		while(!q.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				int n = q.poll();
				q.offer(n);
			}
			
			answer[cnt]=q.poll();
			cnt++;
		}
		sb.append("<");
		for(int i=0; i<N-1; i++) {
			sb.append(answer[i]+", ");
		}
		sb.append(answer[N-1]).append(">");
		System.out.println(sb);
	}
}
