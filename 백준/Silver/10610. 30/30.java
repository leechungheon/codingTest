import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		boolean zeroCheck = false;
		int sum = 0;
		Integer[] arr = new Integer[s.length()];
		for(int i=0; i<s.length(); i++) {
			arr[i]=s.charAt(i)-'0';
			if(arr[i]==0) {
				zeroCheck=true;
			}
			sum+=arr[i];
		}
		if(!zeroCheck) {
			System.out.println("-1");
			return;
		}
		if(sum%3!=0) {
			System.out.println("-1");
			return;
		}
		Arrays.sort(arr,Collections.reverseOrder());
		for(int i=0; i<s.length(); i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
