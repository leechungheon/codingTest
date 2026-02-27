import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		int answer = 0;
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st1.nextToken());
        int h = Integer.parseInt(st1.nextToken());
        boolean[][] block = new boolean[w][h];
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<h; i++) {
        	int n = Integer.parseInt(st2.nextToken());
        	for(int j=0; j<n; j++) {
        		block[j][i] = true;
        	}
        }
        
        for(int i=0; i<w; i++) {
        	int start = 0;
        	int end = 0;
        	
        	for(int j=0; j<h; j++) {
        		if(block[i][j]) {
        			start=j;
        			break;
        		}
        	}
        	
        	for(int j=h-1; j>=0; j--) {
        		if(block[i][j]) {
        			end=j;
        			break;
        		}
        	}
        	
        	for(int j=start; j<end; j++) {
        		if(!block[i][j])answer++;
        	}
        }
        System.out.println(answer);
	}
}