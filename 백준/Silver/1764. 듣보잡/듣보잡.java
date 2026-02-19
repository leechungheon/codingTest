import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		int size = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] st2 = new String[M];
		Map<String, Integer> hashMap = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			hashMap.put(br.readLine(), 1);
		}
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(hashMap.getOrDefault(str,0)==1) {
				size++;
				pq.add(str);
			}
		}
		
		for(int i=0; i<size; i++) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(size);
		System.out.println(sb);
	}
}
