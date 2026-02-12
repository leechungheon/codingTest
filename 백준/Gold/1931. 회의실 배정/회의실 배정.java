import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		int[][] meeting = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i][0]=Integer.parseInt(st.nextToken());
			meeting[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting,(o1,o2)->{
			if(o1[1]==o2[1]) {
				return o1[0]-o2[0];
			}else {
				return o1[1]-o2[1];
			}
		});
		int last = 0;
		for(int i=0; i<N; i++) {
			if(meeting[i][0]>=last) {
				last=meeting[i][1];
				answer++;
			}
		}
		System.out.println(answer);
	}
}
