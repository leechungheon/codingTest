import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Map<String,String> map = new TreeMap<>(Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		for(String key : map.keySet()) {
			if(map.get(key).equals("enter")) {
				sb.append(key).append("\n");
			}
		}
		System.out.print(sb);
	}
}