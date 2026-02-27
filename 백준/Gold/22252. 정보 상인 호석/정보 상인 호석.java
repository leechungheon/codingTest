import java.util.*;
import java.io.*;
class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int query = Integer.parseInt(br.readLine());
		HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
		
		long answer = 0;
		
		for(int i=0; i<query; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			String gorilla = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			
			if(type==1) {
				// map에 있는 key값인지 확인
				if(map.containsKey(gorilla)) { // 있으면 큐에 값 추가
					PriorityQueue<Integer> pq = map.get(gorilla);	
					for(int j=0; j<k; j++) {
						pq.add(Integer.parseInt(st.nextToken()));
					}
				}else {// 없으면 새롭게 우선순위 큐 생성하여 저장
					map.put(gorilla, new PriorityQueue<>(Collections.reverseOrder()));
					PriorityQueue<Integer> pq = map.get(gorilla);
					for(int j=0; j<k; j++) {
						pq.add(Integer.parseInt(st.nextToken()));
					}
				}
			}else {
				// map에서 우선순위 큐 꺼내어서 poll
				if(map.containsKey(gorilla)) {
					PriorityQueue<Integer> pq = map.get(gorilla);
				for(int j=0; j<k; j++) {
					if(!pq.isEmpty()) {
						answer += pq.poll();
						}
					}
				}
			}
		}
		System.out.print(answer);
	}
}