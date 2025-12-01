import java.util.*;
import java.io.*;
import java.math.*;


class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;

		// 한 줄을 읽었는데 null이 아니면 계속함
		while((line = br.readLine()) != null) {
		    if (line.isEmpty()) break;
		    int N = Integer.parseInt(line);
		    int len = (int) Math.pow(3, N);
		    char[] cantor = new char[len];
		    Arrays.fill(cantor, '-');
		    dfs(cantor, 0, len);
		    for(int i=0; i<len; i++) {
		    	sb.append(cantor[i]);
		    }
		    sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(char[] cantor, int start, int len) {
		if(len==1)return;
		int size = len/3;
		// 가운데 비우기
		int centerStart = start+size;
		for(int i=0; i<size; i++) {
			cantor[centerStart+i]=' ';
		}
		// 왼쪽 재귀
		dfs(cantor,start,size);
		// 오른쪽 재귀
		dfs(cantor,start+size*2,size);
	}
}