import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] a1 = new int[3];
        int[] a2 = new int[3];
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<3; j++) {
        		a1[j]=Integer.parseInt(st.nextToken());
        	}
        	for(int j=0; j<3; j++) {
        		a2[j]=Integer.parseInt(st.nextToken());
        	}
        	double r_length = a1[2]+a2[2];
        	double a_distance = Math.sqrt(Math.pow(a1[0]-a2[0], 2)+Math.pow(a1[1]-a2[1], 2));
        	// 원이 겹칠 떄
        	if(a1[0]==a2[0] && a1[1]==a2[1] && a1[2]==a2[2]) {
        		sb.append("-1").append("\n"); // unlimited
        		continue;
        	}
        	// 원 안에 원
        	else if(a1[0]==a2[0] && a1[1]==a2[1] && a1[2]!=a2[2]) {
        		sb.append("0").append("\n");
        		continue;
        	}
        	else if(a_distance+a1[2]==a2[2] || a_distance+a2[2]==a1[2] || a_distance==r_length) {
        		sb.append("1").append("\n");
        	}
        	else if(a_distance+a1[2]<a2[2] || a_distance+a2[2]<a1[2]) {
        		sb.append("0").append("\n");
        	}
        	else if(a_distance < r_length) {
        		sb.append("2").append("\n");
        	}
        	else {
        		sb.append("0").append("\n");
        	}
        }
        System.out.println(sb);
    }
}