import java.util.*;
import java.io.*;
import java.math.*;


class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		for (int i = 0; i < board.length; i++) {
		    Arrays.fill(board[i], '*');
		}
		dfs(board, 0, 0, N);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(char[][] board, int startX, int startY, int len) {
		if(len==1)return;
		int size = len/3;
		// 가운데 비우기
		int center_start_X = startX + size;
		int center_start_Y = startY + size;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				board[center_start_X+i][center_start_Y+j]=' ';
			}
		}
		
		// 둘러싼 사각형 1~9까지 재귀
		// 1
		dfs(board, startX, startY, size);
		// 2
		dfs(board, startX+size, startY, size);
		// 3
		dfs(board, startX+size*2, startY, size);
		// 4
		dfs(board, startX, startY+size, size);
		// 5
		//dfs(board, startX+size, startY+size, size);
		// 6
		dfs(board, startX+size*2, startY+size, size);
		// 7
		dfs(board, startX, startY+size*2, size);
		// 8
		dfs(board, startX+size, startY+size*2, size);
		// 9
		dfs(board, startX+size*2, startY+size*2, size);
	}
}