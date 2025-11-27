import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int devilNum = 666;
		while(true) {
			if(cnt==N)break;
			devilNum++;
			if(String.valueOf(devilNum).contains("666")) {
				cnt++;
			}
		}
		System.out.println(devilNum);
	}
}
