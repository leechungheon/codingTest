import java.util.*;
import java.io.*;
import java.math.*;


class Main
{
	static int answer = 0;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		dfs(N, arr, 0);
		System.out.println(answer);
	}
	private static void dfs(int N, int[] arr, int col) {
		if(col==N) {
			answer++;
			return;
		}
		for(int i=1; i<=N; i++) {
			if(possible(arr,col,i)) {
				arr[col]=i;
				dfs(N, arr ,col+1);
				arr[col]=0;
			}
		}
	}
	private static boolean possible(int[] arr, int col, int num) {
		for(int i=0; i<col; i++) {
			if(num==arr[i])return false;
		}
		for(int i=1; i<=col; i++) {
			if(num==arr[col-i]-i)return false;
			if(num==arr[col-i]+i)return false;
		}
		return true;
	}
}