import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int[] arr = new int[n];
        	long answer = 0;
        	
        	for(int j=0; j<n; j++) {
        		arr[j]=Integer.parseInt(st.nextToken());
        	}
        	// gcd logic
        	for(int j=0; j<n-1; j++) {
        		for(int k=j+1; k<n; k++) {
        			if(arr[j]>arr[k]) {
        				answer+=gcd(arr[j],arr[k]);
        			}else {
        				answer+=gcd(arr[k],arr[j]);
        			}
        		}
        	}
        	sb.append(answer).append("\n");
        }
        System.out.print(sb);
	}
	
	public static int gcd(int a, int b) {
		if(a%b!=0) {
			return gcd(b,a%b);
		}else {
			return b;
		}
	}
}
