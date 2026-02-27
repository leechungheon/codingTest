import java.util.*;
import java.io.*;
class Main
{
	public static void main(String args[]) throws Exception
	{
		int answer = 0;
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[com+1];
        visited[1] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        int[][] adj = new int[com+1][com+1];
        int line = Integer.parseInt(br.readLine());
        
        for(int i=0; i<line ;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	adj[x][y] = 1;
        	adj[y][x] = 1;
        }
        
        while(!q.isEmpty()) {
        	int n = q.poll();
        	for(int i=1; i<com+1; i++) {
        		if(adj[n][i] ==1 && !visited[i]) {
        			q.add(i);
        			visited[i] = true;
        		}
        	}
        }
        
        for(int i=2; i<com+1; i++) {
        	if(visited[i])answer++;
        }
        
        System.out.print(answer);
	}
}