 	 	import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 1. 자료구조 개수 N 입력
		int N = Integer.parseInt(br.readLine());
		// 2. queuestack 수열의 정보 입력
		int[] queueStacks = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i=0; i<N; i++) {
			queueStacks[i]=Integer.parseInt(st.nextToken());
			if(queueStacks[i]==0)cnt++;
		}
		// 3. 자료구조에 삽입할 초기값 수열 입력
		int[] values = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			values[i]=Integer.parseInt(st1.nextToken());
		}
		// 4. 삽일할 수열의 길이 M
		int M = Integer.parseInt(br.readLine());
		// 5. 삽일할 수열 입력
		int[] insertValues = new int[M];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			insertValues[i]=Integer.parseInt(st2.nextToken());
		}
		
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=N-1; i>=0; i--) {
			if(queueStacks[i]==0) {
				deque.offer(values[i]);
			}
		}
		for(int i=0; i<M; i++) {
			deque.offer(insertValues[i]);
			int nextToken = deque.poll();
			sb.append(nextToken).append(" ");
		}
		System.out.println(sb);
	}
}