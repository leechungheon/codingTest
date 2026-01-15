import java.util.*;
import java.io.*;

class Main {
	static int result = 0;
	static int[] dx = new int[] {0,0,-1,1};
	static int[] dy = new int[] {1,-1,0,0};
	static int[][] board;
	static int R;
	static int C;
	static boolean[] visited = new boolean[26];
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	board = new int[R][C];
    	for(int i=0; i<R; i++) {
    		String str = br.readLine();
    		for(int j=0; j<C; j++) {
    			board[i][j] = str.charAt(j)-'A';
    		}
    	}
    	visited[board[0][0]] = true;
    	dfs(0,0,1);
    	
    	System.out.println(result);
    }
    public static void dfs(int x, int y, int cnt) {
    	result = Math.max(result, cnt);
    	
    	for(int i=0; i<4; i++) {
    		if(x+dx[i]>=0 && y+dy[i]>=0 && x+dx[i]<R && y+dy[i]<C) {
    			int num = board[x+dx[i]][y+dy[i]];
    			if(!visited[num]) {
    				visited[num] = true;
    				dfs(x+dx[i], y+dy[i], cnt+1);
    				visited[num] = false;
    			}
    		}
    	}
    }
}