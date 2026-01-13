import java.util.*;
import java.io.*;

class Main {
	static int N = 0;
	static int M = 0;
	static int sum1 = 0;
	static int sum2 = 0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	char[][] field = new char[N+1][N+1];
    	char[][] blindField = new char[N+1][N+1];
    	for(int i=0; i<N; i++) {
    		String s = br.readLine();
    		for(int j=0; j<s.length(); j++) {
    			field[i][j] = s.charAt(j);
    			if(s.charAt(j)=='G') { // 색약의 경우 녹색을 적색으로 처리
    				blindField[i][j] = 'R';
    			}else {
    				blindField[i][j] = s.charAt(j);
    			}
    		}
    	}
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(field[i][j]!=' ') {
    				bfs(field, i, j, field[i][j]);
    				sum1++;
    			}
    		}
    	}
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(blindField[i][j]!=' ') {
    				bfs(blindField, i, j, blindField[i][j]);
    				sum2++;
    			}
    		}
    	}
    	System.out.println(sum1+" "+sum2);
    }
    public static void bfs(char[][] field, int x, int y, char color) {
    	int[] dx = {0,0,-1,1};
    	int[] dy = {1,-1,0,0};
    	
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {x,y});
    	field[x][y]=' ';
    	
    	while(!q.isEmpty()) {
    		int[] node = q.poll();
    		x = node[0];
    		y = node[1];
    		for(int i=0; i<4; i++) {
    			if(x+dx[i]<=N && x+dx[i]>=0 && y+dy[i]<=N && y+dy[i]>=0) {
    				if(field[x+dx[i]][y+dy[i]]==color) {
    					q.add(new int[] {x+dx[i], y+dy[i]});
    					field[x+dx[i]][y+dy[i]] = ' ';
    				}
    			}
    		}
    	}
    }
}