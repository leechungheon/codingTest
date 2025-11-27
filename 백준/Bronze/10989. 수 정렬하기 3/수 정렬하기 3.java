import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[10000001];
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			numbers[input]++;
		}
		for(int i=1; i<numbers.length; i++) {
			if(numbers[i]!=0) {
				for(int j=0; j<numbers[i]; j++) {
					sb.append(i+"\n");
				}
			}
		}
		System.out.println(sb);
	}
}
