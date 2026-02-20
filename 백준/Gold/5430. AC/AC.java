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
			// 함수 p 입력
			String inputP = br.readLine();
			Deque<Character> p = new ArrayDeque<>();
			for(int j=0; j<inputP.length(); j++) {
				p.addLast(inputP.charAt(j));
			}
			
			// 배열 길이 입력
			int n = Integer.parseInt(br.readLine()); // 왜 필요한지 모르겟음
			
			// 배열 입력 및 파싱
			String inputArr = br.readLine();
			String parsedArr0 = inputArr.replace("[", "").replace("]", "");
            String[] parsedArr = parsedArr0.split(",");
			Deque<Integer> numDq = new ArrayDeque<>();
			if(!parsedArr0.isEmpty()) {
				for(int j=0; j<parsedArr.length; j++) {
					numDq.addLast(Integer.parseInt(parsedArr[j]));
				}
			}
			// result
			sb.append(func(p,numDq)).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static String func(Deque<Character> p, Deque<Integer> numDq) {
		boolean head = true;
		while(true) {
			if(p.isEmpty()) {
				int[] arr = new int[numDq.size()];
				int i=0;
				if(head) {
					while(!numDq.isEmpty()) {
						arr[i++] = numDq.pollFirst();
					}
					return Arrays.toString(arr).replace(" ", "");
				}else {
					while(!numDq.isEmpty()) {
						arr[i++] = numDq.pollLast();
					}
					return Arrays.toString(arr).replace(" ", "");
				}
			}
			if(p.peek()=='R') {
				p.poll();
				if(head) {
					head=false;
				}else {
					head=true;
				}
			}else if(p.peek()=='D') {
				p.poll();
				if(numDq.isEmpty()) {
					return "error";
				}else {
					if(head) {
						numDq.removeFirst();
					}else {
						numDq.removeLast();
					}
				}
			}
		}
	}
}
