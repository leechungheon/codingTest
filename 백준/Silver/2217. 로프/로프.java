import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		Integer[] rope = new Integer[N];
		
		for(int i=0; i<N; i++) {
			rope[i]=Integer.parseInt(br.readLine());
		}
		
		Collections.sort(Arrays.asList(rope));
		for(int i=0; i<N; i++) {
			answer = Math.max(answer, rope[i]*(N-i));
		}
		System.out.println(answer);
	}
}
