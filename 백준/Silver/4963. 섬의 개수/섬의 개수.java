import java.util.*;
import java.io.*;

class Main {
	static int w = 0;
	static int h = 0;
	static int cnt = 0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	while(true) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
        	w = Integer.parseInt(st.nextToken());
        	h = Integer.parseInt(st.nextToken());
        	if(w==0 && h==0)break;
    		int[][] field = new int[h][w];
    		for(int i=0; i<h; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0; j<w; j++) {
    				field[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		for(int i=0; i<h; i++) {
    			for(int j=0; j<w; j++) {
    				if(field[i][j]==1) {
    					bfs(field,i,j);
    					cnt++;
    				}
    			}
    		}
    		sb.append(cnt).append("\n");
    		cnt=0;
    	}
    	System.out.println(sb);
    }
    
    public static void bfs(int[][] field, int x, int y) {
    	int[] dx = {0,0,-1,1,-1,1,-1,1};
    	int[] dy = {1,-1,0,0,1,1,-1,-1};
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {x,y});
    	field[x][y]=0;
		while(!q.isEmpty()) {
			int[] land = q.poll();
			x = land[0];
			y = land[1];
			for(int i=0; i<8; i++) {
				if(x+dx[i]>=0 && x+dx[i]<h && y+dy[i]>=0 && y+dy[i]<w) {
					if(field[x+dx[i]][y+dy[i]]==1) {
						q.add(new int[] {x+dx[i],y+dy[i]});
						field[x+dx[i]][y+dy[i]]=0;
					}
				}
			}
		}
    }
}