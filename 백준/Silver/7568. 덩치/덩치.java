
import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] persons = new int [N][2];
		int[] answer = new int[N];
		Arrays.fill(answer, 1);
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			persons[i][0]=Integer.parseInt(st.nextToken());
			persons[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(persons[i][0]<persons[j][0] && persons[i][1]<persons[j][1])answer[i]++;
			}
		}
		for(int i=0; i<N; i++) {
			System.out.print(answer[i]+" ");
		}
	}
}
