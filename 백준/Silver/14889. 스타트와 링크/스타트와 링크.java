import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static int[][] S;
	static int MIN = Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		// output
		System.out.println(MIN);
	}
	public static void dfs(int idx, int cnt) {
		int teamA = 0;
		int teamB = 0;
		if(N/2==cnt) {
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					if(visited[i] && visited[j])teamA+=(S[i][j]+S[j][i]);
					if(!visited[i] && !visited[j])teamB+=(S[i][j]+S[j][i]);
				}
			}
			MIN = Math.min(MIN, Math.abs(teamA-teamB));
			return;
		}
		for(int i=idx; i<N; i++) {
			visited[i]=true;
			dfs(i+1, cnt+1);
			visited[i]=false;
		}
	}
}
