 	 	import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> mainLine = new Stack<>();
		Stack<Integer> waitingLine = new Stack<>();
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=N-1; i>=0; i--) {
			mainLine.push(arr[i]);
		}
		int index = 1;
		while(!mainLine.isEmpty() || !waitingLine.isEmpty()) {
			boolean popCheck = false;
			if(!mainLine.isEmpty() && mainLine.peek()==index) {
				mainLine.pop();
				popCheck = true;
				index++;
			}
			if(!waitingLine.isEmpty() && waitingLine.peek()==index) {
				waitingLine.pop();
				popCheck = true;
				index++;
			}
			if(!mainLine.isEmpty() && !popCheck) {
				int num = mainLine.pop();
				waitingLine.push(num);
			}
			if(mainLine.isEmpty() && !popCheck) {
				sb.append("Sad");
				break;
			}
		}
		if(mainLine.isEmpty() && waitingLine.isEmpty())sb.append("Nice");
		
		System.out.println(sb);
	}
}