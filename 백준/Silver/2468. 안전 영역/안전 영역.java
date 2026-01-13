import java.util.*;
import java.io.*;

class Main {
	static int max = 0;
	static int result = 0;
	static int N = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int[][] field = new int[N][N];
        int[][] highField = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		field[i][j] = Integer.parseInt(st.nextToken());
        		max = Math.max(field[i][j], max);
        	}
        }
        
        for(int k=0; k<=max; k++) {
        	if(k==0) {
        		result = Math.max(1, result);
        		continue;
        	}
        	int sum = 0;
        	for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		if(field[i][j]>k) {
            			highField[i][j] = 1;
            		}else {
            			highField[i][j] = 0;
            		}
            	}
            }
        	// bfs
        	for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		if(highField[i][j]==1) {
            			bfs(highField, i, j);
            			sum++;
            		}
            	}
            }
        	result = Math.max(sum, result);
        }
        
        System.out.println(result);
    }
    public static void bfs(int[][] field, int x, int y) {
    	int[] dx = {0,0,-1,1};
    	int[] dy = {1,-1,0,0};
    	
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {x,y});
    	field[x][y]=0;
    	while(!q.isEmpty()) {
    		int[] node = q.poll();
    		x = node[0];
    		y = node[1];
    		for(int i=0; i<4; i++) {
    			if(x+dx[i]<N && x+dx[i]>=0 && y+dy[i]<N && y+dy[i]>=0) {
    				if(field[x+dx[i]][y+dy[i]]==1) {
    					q.add(new int[] {x+dx[i], y+dy[i]});
    					field[x+dx[i]][y+dy[i]] = 0;
    				}
    			}
    		}
    	}
    }
}