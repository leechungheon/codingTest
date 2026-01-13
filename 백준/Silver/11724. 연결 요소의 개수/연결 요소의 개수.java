import java.util.*;
import java.io.*;

class Main {
	static int N = 0;
	static int M = 0;
	static int sum = 0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	int[][] adj = new int[N+1][N+1];
    	boolean[] visited = new boolean[N+1];
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		adj[x][y] = 1;
    		adj[y][x] = 1;
    	}
    	
    	for(int i=1; i<=N; i++) {
    		if(!visited[i]) {
				visited[i] = true;
				bfs(adj, visited, i);
				sum ++;
			}
    	}
    	System.out.println(sum);
    }
    public static void bfs(int[][] adj, boolean[] visited, int node) {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(node);
    	while(!q.isEmpty()) {
    		node = q.poll();
    		for(int i=1; i<N+1; i++) {
    			if(adj[node][i]==1 && !visited[i]) {
    				q.add(i);
    				visited[i] = true;
    			}
    		}
    	}
    }
}