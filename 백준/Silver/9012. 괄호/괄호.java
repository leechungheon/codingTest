import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			Stack<Character> stack = new Stack<>();
			String test_data = br.readLine();
			for(int j=0; j<test_data.length(); j++) {
				if(test_data.charAt(j)=='(') {
					stack.push('(');
				}
				if(test_data.charAt(j)==')') {
					if(stack.isEmpty()) {
						sb.append("NO").append("\n");
						break;
					}
					stack.pop();
				}
				if(j==test_data.length()-1) {
					if(stack.isEmpty()) {
						sb.append("YES").append("\n");
					}else {
						sb.append("NO").append("\n");
					}
				}
			}
		}
		System.out.println(sb);
	}
}