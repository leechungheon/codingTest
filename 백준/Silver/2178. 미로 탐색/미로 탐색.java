import java.util.*;
import java.io.*;

class Main {
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {1,-1,0,0};
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[][] maze = new int[N][M];
    	int[][] dist = new int[N][M];
    	for(int i=0; i<N; i++) {
    		String str = br.readLine();
    		for(int j=0; j<M; j++) {
    			maze[i][j] = str.charAt(j)-'0';
    		}
    	}
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {0,0});
    	dist[0][0]=1;
    	while(!q.isEmpty()) {
    		int[] node = q.poll();
    		int x = node[0];
    		int y = node[1];
    		for(int i=0; i<4; i++) {
    			if(x+dx[i]>=0 && y+dy[i]>=0 && x+dx[i]<N && y+dy[i]<M) {
    				if(maze[x+dx[i]][y+dy[i]]==1 && dist[x+dx[i]][y+dy[i]]==0) {
    					q.add(new int[] {x+dx[i], y+dy[i]});
    					dist[x+dx[i]][y+dy[i]]=dist[x][y]+1;
    				}
    			}
    		}
    	}
    	
    	System.out.println(dist[N-1][M-1]);
    }
}