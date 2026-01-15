import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int K;
	static int time;
	static Queue<Integer> nq;
	static int[] timeArr = new int[100001];
	static boolean find = false;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	if (N == K) {
            System.out.println(0);
            return;
        }
    	// K보다 커지면 무조건 마이너스 연산만 수행
    	Queue<Integer> q = new LinkedList<>();
    	q.add(N);
    	timeArr[N]=1;
    	while(true) {
    		q=bfs(q);
    		time++;
    		if(find)break;
    	}
    	
    	System.out.println(time);
    }
    public static Queue<Integer> bfs(Queue<Integer> q){
    	nq = new LinkedList<>();
    	while(!q.isEmpty()) {
    		int num = q.poll();
    		int[] nexts = {num - 1, num + 1, num * 2};

            for (int next : nexts) {
                if (next >= 0 && next <= 100000 && timeArr[next] == 0) {
                    if (next == K) {
                        find = true;
                        return nq;
                    }
                    timeArr[next] = 1;
                    nq.add(next);
                }
            }
    		
    	}
    	return nq;
    }
}