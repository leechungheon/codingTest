import java.util.*;
import java.io.*;

class Main {
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {1,-1,0,0};
	static int[][] box;
	static int M;
	static int N;
	static int answer = 0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	box = new int[N][M];
    	Queue<int[]> q = new LinkedList<>();
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			box[i][j] = Integer.parseInt(st.nextToken());
    			if(box[i][j]==1)q.add(new int[] {i,j});
    		}
    	}
    	q = bfs(q);
    	while(!q.isEmpty()) {
    		q = bfs(q);
    		answer++;
    	}
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(box[i][j]==0)answer=-1;
    		}
    	}
    	System.out.println(answer);
    }
    public static Queue<int[]> bfs(Queue<int[]> q) {
    	Queue<int[]> nq = new LinkedList<>();
    	while(!q.isEmpty()) {
    		int[] node = q.poll();
    		int x = node[0];
    		int y = node[1];
    		for(int i=0; i<4; i++) {
    			if(x+dx[i]>=0 && y+dy[i]>=0 && x+dx[i]<N && y+dy[i]<M) {
    				if(box[x+dx[i]][y+dy[i]]==0) {
    					box[x+dx[i]][y+dy[i]]=1;
    					nq.add(new int[] {x+dx[i], y+dy[i]});
    				}
    			}
    		}
    	}
    	return nq;
    }
}