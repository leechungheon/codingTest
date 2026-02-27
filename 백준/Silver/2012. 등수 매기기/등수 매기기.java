import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=0; i<N; i++) {
        	answer+=Math.abs(arr[i]-(i+1));
        }
        
        System.out.print(answer);
	}
}
