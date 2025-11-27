import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		Map<Integer, String> reverseMap = new HashMap<>();
		for(int i=1; i<=N; i++) {
			String name = br.readLine();
			map.put(name, i);
			reverseMap.put(i, name);
		}
		for(int i=1; i<=M; i++) {
			String problem = br.readLine();
			try {
			    int num = Integer.parseInt(problem);
			    sb.append(reverseMap.get(num)).append("\n");
			} catch (NumberFormatException e) {
			    sb.append(map.get(problem)).append("\n");
			}
		}
		System.out.println(sb);
	}
}