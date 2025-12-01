import java.util.*;
import java.io.*;
import java.math.*;


class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N];
		int[] answer = new int[M];
		dfs(visited, M, answer, 0);
	}
	public static void dfs(boolean[] visited, int M, int[] answer, int offset) {
		if(offset==M) {
			for(int i=0; i<answer.length; i++) {
				System.out.print(answer[i]+" ");
			}
			System.out.println();return;
		}
		int start = 0;
		if(offset!=0)start=answer[offset-1];
		for(int i=start; i<visited.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				answer[offset]=i+1;
				dfs(visited, M, answer, offset+1);
				visited[i]=false;
			}
		}
	}
}