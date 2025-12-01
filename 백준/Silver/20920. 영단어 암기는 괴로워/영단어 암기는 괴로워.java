import java.util.*;
import java.io.*;
import java.math.*;


class Main
{
	static class Node implements Comparable<Node>{
		String word;
		int time;
		
		public Node(String word, int time) {
			this.word=word;
			this.time=time;
		}
		
		@Override
		public int compareTo(Node other) {
			// 1. 자주 나온 단어
			// 2. 단어의 길이가 긴 것
			// 3. 알바펫 사전 순으로 앞에 있는 것
			if(this.time!=other.time) {
				return other.time-this.time;
			}
			if(this.word.length()!=other.word.length()) {
				return other.word.length()-this.word.length();
			}
			return this.word.compareTo(other.word);
		}
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 1. 단어의 개수 N, 최소 길이 M 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Map<String, Integer> map = new HashMap<>();
		
		// 해시맵에 key: 단어, value: 횟수 저장
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			if(word.length()>=M) {
				int num = map.getOrDefault(word, 0);
				map.put(word, num+1);
			}
		}
		// 해시맵의 요소들을 우선순위큐에 저장
		for(String word: map.keySet()) {
			int time = map.get(word);
			pq.add(new Node(word,time));
		}
		int size = pq.size();
		for(int i=0; i<size; i++) {
			sb.append(pq.poll().word).append("\n");
		}
		System.out.println(sb);
	}
}