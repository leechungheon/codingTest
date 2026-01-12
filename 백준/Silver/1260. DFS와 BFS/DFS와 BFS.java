import java.util.*;
import java.io.*;

class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());	
    	int N = Integer.parseInt(st.nextToken());
    	int[][] adj = new int[N+1][N+1];
    	boolean[] visited = new boolean[N+1];
    	int M = Integer.parseInt(st.nextToken());
    	int V = Integer.parseInt(st.nextToken());
    	
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		adj[x][y] = 1;
    		adj[y][x] = 1;
    	}
    	dfs(V, adj, visited);
    	sb.append("\n");
    	Arrays.fill(visited, false);
    	bfs(V, adj, visited);
    	System.out.println(sb);
    }
    public static void dfs(int node, int[][] adj, boolean[] visited) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int i = 1; i < adj.length; i++) {
            if (adj[node][i] == 1 && !visited[i]) {
                dfs(i, adj, visited);
            }
        }
    }
    
    public static void bfs(int node, int[][] adj, boolean[] visited) {
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(node);
    	visited[node]=true;
    	while(!q.isEmpty()) {
    		int n = q.poll();
    		sb.append(n).append(" ");
    		for (int i = 1; i < adj.length; i++) {
                if (adj[n][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i]=true;
                }
            }
    	}
    }
}