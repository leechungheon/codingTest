import java.util.*;
import java.io.*;

class Main {
	static int N = 0;
	static List<Integer> list = new LinkedList<Integer>();
	static int sum = 0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	N = Integer.parseInt(br.readLine());
    	int [][] map = new int[N][N];
    	for(int i=0; i<N; i++) {
    		String s = br.readLine();
    		for(int j=0; j<s.length(); j++) {
    			map[i][j] = s.charAt(j)-'0';
    		}
    	}
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(map[i][j]==1) {
    				bfs(map,i,j);
    				sum ++;
    			}
    		}
    	}
    	System.out.println(sum);
    	Collections.sort(list);
    	for(int i=0; i<list.size(); i++) {
    		sb.append(list.get(i)).append("\n");
    	}
    	System.out.println(sb);
    }
    public static void bfs(int[][] map, int x, int y) {
    	int[] dx = {0,0,-1,1};
    	int[] dy = {1,-1,0,0};
    	int cnt = 1;
    	
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {x,y});
    	map[x][y] = 0;
    	while(!q.isEmpty()) {
    		int[] node = q.poll();
    		x = node[0];
    		y = node[1];
    		for(int i=0; i<4; i++) {
    			if(x+dx[i]<N && x+dx[i]>=0 && y+dy[i]<N && y+dy[i]>=0) {
    				if(map[x+dx[i]][y+dy[i]]==1) {
    					q.add(new int[] {x+dx[i], y+dy[i]});
    					map[x+dx[i]][y+dy[i]] = 0;
    					cnt++;
    				}
    			}
    		}
    	}
    	list.add(cnt);
    }
}