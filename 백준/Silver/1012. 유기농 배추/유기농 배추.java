import java.util.*;
import java.io.*;

class Main {
	static int count = 0;
	static int N = 0;
	static int M = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] cabbage = new int[K][2];
            int[][] field = new int[M][N];
            
            for(int j=0; j<K; j++) {
            	StringTokenizer st1 = new StringTokenizer(br.readLine());
            	cabbage[j][0] = Integer.parseInt(st1.nextToken());
            	cabbage[j][1] = Integer.parseInt(st1.nextToken());
            	field[cabbage[j][0]][cabbage[j][1]] = 1;
            }
            
            // logic
            for(int k=0; k<K; k++) {
            	if(field[cabbage[k][0]][cabbage[k][1]]==1) {
            		count++;
            		bfs(field, cabbage[k][0], cabbage[k][1]);
            	}
            }
            sb.append(count).append("\n");
            count = 0;
        }
        System.out.println(sb);
        
    }
    public static void bfs(int[][] field, int i, int j) {
    	field[i][j]=0;
    	if(i-1>=0 && field[i-1][j]==1) {
    		bfs(field, i-1,j);
    	}
    	if(j-1>=0 && field[i][j-1]==1) {
    		bfs(field, i,j-1);
    	}
    	if(i+1<M && field[i+1][j]==1) {
    		bfs(field, i+1,j);
    	}
    	if(j+1<N && field[i][j+1]==1) {
    		bfs(field, i,j+1);
    	}
    }
}