 	 	import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		// 1. N을 입력
		int N = Integer.parseInt(br.readLine());
		// 2. N 크기의 입력값을 입력 (ENTER or nickname)
		String[] nickName = new String[N];
		for(int i=0; i<N; i++) {
			nickName[i]=br.readLine();
		}
		// logic
		Set<String> hello = new HashSet<>();
		for(int i=0; i<N; i++) {
			String currentChatting = nickName[i];
			if(currentChatting.equals("ENTER") && !hello.isEmpty()) {
				answer+=hello.size();
				hello.clear();
			}
			if(!currentChatting.equals("ENTER")) {
				hello.add(currentChatting);
			}
		}
		if(!hello.isEmpty())answer+=hello.size();
		System.out.println(answer);
	}
}