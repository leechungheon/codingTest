import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int answer = 0;
		
		String[] arr = str.split("-");
		for(int i=0; i<arr.length; i++) {
			String[] input = arr[i].split("\\+");
			
			int sum = 0;
			for(int j=0; j<input.length; j++) {
				sum += Integer.parseInt(input[j]);
			}
			
			if(i==0) {
				answer=sum;
			}else {
				answer-=sum;
			}
		}
		System.out.println(answer);
	}
}
