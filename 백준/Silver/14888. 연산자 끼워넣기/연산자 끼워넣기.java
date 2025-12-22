
import java.util.*;
import java.io.*;

class Main
{
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int N;
	static int[] A;
	static int[] operator = new int[4];
	public static void main(String[] args) throws Exception{ 
		// input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	A[i]=Integer.parseInt(st.nextToken());
        }
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
        	operator[i]=Integer.parseInt(st1.nextToken());
        }
        
        // logic
        dfs(0,A[0]);
        
        // output
        System.out.println(MAX);
        System.out.println(MIN);
    }
	
	public static void dfs(int index, int sum) {
		if(index==N-1) {
			MAX=Math.max(MAX, sum);
			MIN=Math.min(MIN, sum);
			return;
		}
		for(int i=0; i<4; i++) {
			if(operator[i]>0) {
				operator[i]-=1;
				int newSum=calculator(i,sum, A[index+1]);
				dfs(index+1, newSum);
				operator[i]+=1;
			}
		}
	}
	public static int calculator(int i, int sum, int nextNumber) {
		if(i==0)return sum+nextNumber;
		if(i==1)return sum-nextNumber;
		if(i==2)return sum*nextNumber;
		return sum/nextNumber;
	}
	
}
