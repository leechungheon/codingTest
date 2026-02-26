import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String sStr = br.readLine();
            map.put(sStr,1);
        }

        for (int i = 0; i < M; i++) {
            String mStr = br.readLine();
            int num = map.getOrDefault(mStr, 0);
            if(num==1)answer++;
        }
        
        System.out.print(answer);
	}
}
