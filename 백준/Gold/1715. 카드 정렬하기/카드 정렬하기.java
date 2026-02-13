import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int answer=0;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		while(pq.size()!=1) {
			int a = pq.poll();
			int b = pq.poll();
			int sum = a+b;
			answer+=sum;
			pq.offer(sum);
		}
		System.out.print(answer);
	}
}
