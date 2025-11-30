import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if(command==1) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			if(command==2) {
				if(!stack.isEmpty()) {
					int num = stack.pop();
					sb.append(num).append("\n");
				}else {
					sb.append("-1").append("\n");
				}
			}
			if(command==3) {
				sb.append(stack.size()).append("\n");
			}
			if(command==4) {
				if(stack.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
			}
			if(command==5) {
				if(!stack.isEmpty()) {
					int num = stack.peek();
					sb.append(num).append("\n");
				}else {
					sb.append("-1").append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}