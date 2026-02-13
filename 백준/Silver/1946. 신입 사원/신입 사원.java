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
			int answer=1;
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, (o1,o2)->{
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}else {
					return o1[0]-o2[0];
				}
			});
			
			int top = arr[0][1];
			for(int j=0; j<N; j++) { // survive
				if(arr[j][1]<top) {
					top=arr[j][1];
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}
