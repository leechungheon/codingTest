import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0]=st.nextToken();
			arr[i][1]=st.nextToken();
		}
		Arrays.sort(arr,(o1,o2)->{
			//if(Integer.parseInt(o1[0])==Integer.parseInt(o2[0])) {
				//continue;
			//}else {
				return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
			//}
		});
		for(int i=0; i<N; i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		System.out.print(sb);
	}
}
