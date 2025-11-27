import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		while(true) {
			int cnt = 0; // 봉지의 개수
			boolean find = false;
			for(int i=N/5; i>=0; i--) { // 5kg
				for(int j=N/3; j>=0; j--) {
					if((5*i+j*3)==N) {
						cnt = i+j;
						break;
					}
				}
				if(cnt != 0)break;
			}
			if(cnt==0) {
				System.out.print("-1");
				break;
			}
			System.out.print(cnt);
			break;
		}
	}
}
