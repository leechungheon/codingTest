import java.util.*;
import java.io.*;

class Main {
	static int count = 0;
	static int[] start_point = new int[2];
	static int[] end_point = new int[2];
	static int planet_number = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	start_point[0]=Integer.parseInt(st.nextToken());
        	start_point[1]=Integer.parseInt(st.nextToken());
        	end_point[0]=Integer.parseInt(st.nextToken());
        	end_point[1]=Integer.parseInt(st.nextToken());
        	
        	planet_number = Integer.parseInt(br.readLine());
        	int[][] planet = new int[planet_number][3];
        	for(int j=0; j<planet_number; j++) {
        		StringTokenizer st1 = new StringTokenizer(br.readLine());
        		planet[j][0]=Integer.parseInt(st1.nextToken());
        		planet[j][1]=Integer.parseInt(st1.nextToken());
        		planet[j][2]=Integer.parseInt(st1.nextToken());
        	}
        	findRoute(planet);
        	sb.append(count).append("\n");
        	count=0;
        }
        System.out.println(sb);
    }
    public static void findRoute(int[][] planet) {
    	int idx = 0;
    	while(idx<planet_number) {
    		double d_start = Math.pow(planet[idx][0]-start_point[0], 2)+Math.pow(planet[idx][1]-start_point[1], 2);
        	double d_end = Math.pow(planet[idx][0]-end_point[0], 2)+Math.pow(planet[idx][1]-end_point[1], 2);
        	double r = Math.pow(planet[idx][2], 2);
        	
        	if(r>d_start && r>d_end) {
        		idx++;
        		continue;
        	}else if(r<d_start && r<d_end) {
        		idx++;
        		continue;
        	}else {
        		idx++;
        		count++;
        	}
    	}
    }
}