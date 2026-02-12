import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long answer = 0;
		int N = Integer.parseInt(br.readLine());
		long[] len = new long[N-1];
		long[] price = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<len.length; i++) {
			len[i]=Long.parseLong(st.nextToken());
		}

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<price.length; i++) {
			price[i]=Long.parseLong(st1.nextToken());
		}
		
		long minPrice = price[0];
		for(int i=0; i<N-1; i++) {
			if(price[i]<minPrice) {
				minPrice=price[i];
			}
			answer+=minPrice*len[i];
		}
		
		System.out.println(answer);
	}
}
