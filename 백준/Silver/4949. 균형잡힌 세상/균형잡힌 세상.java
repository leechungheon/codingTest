import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			Deque<Character> dq = new ArrayDeque<>();
			boolean answer = false;
			String input = br.readLine();
			if(input==null || input.equals("."))break;
			char[] arr = input.toCharArray();
			for(int i=0; i<arr.length; i++) {
				if(arr[i]=='(' || arr[i]=='[') {
					dq.addFirst(arr[i]);
				}
				if(arr[i]==')') {
					if(dq.peekFirst()!=null && dq.peekFirst()=='(') {
						dq.pollFirst();
					}else {
						break;
					}
				}
				if(arr[i]==']') {
					if(dq.peekFirst()!=null && dq.peekFirst()=='[') {
						dq.pollFirst();
					}else {
						break;
					}
				}
				if(i==arr.length-1)answer=true;
			}
			if(answer && dq.isEmpty()) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
		};
		
		System.out.println(sb);
	}
}
