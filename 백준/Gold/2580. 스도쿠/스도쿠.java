//package pkg;
import java.util.*;
import java.io.*;

class Main
{
	static int[][] board = new int[9][9];
	static List<int[]> list = new ArrayList<int[]>();
	public static void main(String args[]) throws Exception
	{
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				int currentNum = Integer.parseInt(st.nextToken());
				board[i][j]=currentNum;
				if(currentNum==0) {
					list.add(new int[] {i,j});
				}
			}
		}
		dfs(0);
		
	}
	public static void dfs(int depth) {
		if(depth==list.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(board[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		int[] zeroIndex = list.get(depth);
		for(int i=1; i<=9; i++) {
			if(check(zeroIndex, i)) {
				board[zeroIndex[0]][zeroIndex[1]]=i;
				dfs(depth+1); // 재귀
				board[zeroIndex[0]][zeroIndex[1]]=0; // 백트래킹
			}
		}
	}
	public static boolean check(int[] zeroIndex, int number) {
		// 가로
		for(int i=0; i<9; i++) {
			if(board[zeroIndex[0]][i]==number)return false;
		}
		// 세로
		for(int i=0; i<9; i++) {
			if(board[i][zeroIndex[1]]==number)return false;
		}
		// 3x3 사각형
		int startRow = (zeroIndex[0] / 3) * 3;
        int startCol = (zeroIndex[1] / 3) * 3;
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
        		if(board[startRow+i][startCol+j]==number)return false;
        	}
        }
		return true;
	}
}
