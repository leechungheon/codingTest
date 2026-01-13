import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int numberOfComputers = Integer.parseInt(br.readLine());
    	int numberOfLines = Integer.parseInt(br.readLine());
    	int[][] lines = new int[numberOfComputers+1][numberOfComputers+1];
    	boolean[] visited = new boolean[numberOfComputers+1];
    	
    	for(int i=0; i<numberOfLines; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		lines[x][y]=1;
    		lines[y][x]=1;
    	}
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.add(1);
    	visited[1] = true;
    	while(!q.isEmpty()) {
    		int node = q.poll();
    		for(int i=1; i<numberOfComputers+1; i++) {
    			if(lines[node][i]==1 && !visited[i]) {
    				q.add(i);
    				visited[i] = true;
    			}
    		}
    	}
    	int count = 0;
    	for(int i=1; i<numberOfComputers+1; i++) {
    		if(visited[i])count++;
    	}
    	System.out.println(count-1);
    }
}