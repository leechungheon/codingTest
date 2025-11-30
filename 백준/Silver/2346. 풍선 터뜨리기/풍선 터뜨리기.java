 	 	import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] balloons = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<int[]> deque = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			balloons[i]=Integer.parseInt(st.nextToken());
			int[] save = {balloons[i],i+1};
			deque.offerLast(save);
		}
		int[] answers = new int[N];
		while(!deque.isEmpty()) {
			int[] save = deque.pollFirst();
			sb.append(save[1]).append(" ");
			if(deque.isEmpty())break;
			// 음수 이동
			if(save[0]<0) {
				int time = -1*save[0];
				for(int i=0; i<time; i++) {
					int[] balloon = deque.pollLast();
					deque.offerFirst(balloon);
				}
			}
			// 양수 이동
			if(save[0]>=0) {
				for(int i=0; i<save[0]-1; i++) {
					int[] balloon = deque.pollFirst();
					deque.offerLast(balloon);
				}
			}
		}
		System.out.println(sb);
	}
}